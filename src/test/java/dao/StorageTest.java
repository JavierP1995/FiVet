/*
 * MIT License
 *
 * Copyright (c) 2020 Javier Palacios Arce
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dao;

import checkers.units.quals.A;
import cl.ucn.disc.pdbp.tdd.model.Ficha;
import cl.ucn.disc.pdbp.tdd.model.Persona;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tdd.util.Entity;

import java.io.IOException;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.List;

public class StorageTest {

  private static final Logger log = LoggerFactory.getLogger(StorageTest.class);

  @Test
  public void testDatabase() throws SQLException {

    // Base de datos simulada (in RAM memory)
    String databaseUrl = "jdbc:h2:mem:fivet_db";

    // conexión: autoclose with the try/catch
    try (ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
      TableUtils.createTableIfNotExists(connectionSource, Persona.class);
      Dao<Persona, Long> daoPersona = DaoManager.createDao(connectionSource, Persona.class);
      Persona persona = new Persona("Nathaly", "Montevideo 2873", null, 56632523, "newJam@ucn.cl", "19098723K");
      int tuples = daoPersona.create(persona);
      log.debug("Id: {}", persona.getId());
      Assertions.assertEquals(1, tuples, "Save tuples != 1");

      // Obtener
      Persona personaDb = daoPersona.queryForId(persona.getId());

      Assertions.assertEquals(persona.getNombre(), personaDb.getNombre(), "Nombre not equals!");
      Assertions.assertEquals(persona.getRut(), personaDb.getRut(), "Rut not equals!");

      // Buscar por rut
      List<Persona> personaList = daoPersona.queryForEq("rut", "19098723K");
      Assertions.assertEquals(1, personaList.size(), "More than one person?!");

      // Not found by rut
      Assertions.assertEquals(0, daoPersona.queryForEq("rut", "19").size(), "Found something !?");

    } catch (IOException e) {
      log.error("Error", e);
    }
  }

  /**
   * Testing the Repository of Ficha.
   */
  @Test
  public void testRepositoryFicha() {

    // The database to use (in RAM memory)
    String databaseUrl = "jdbc:h2:mem:fivet_db";

    try (ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {

      //creacion de las tablas
      TableUtils.createTableIfNotExists(connectionSource, Ficha.class);
      TableUtils.createTableIfNotExists(connectionSource, Persona.class);

      //nueva persona
      Persona persona = new Persona("Nathaly", "Montevideo 2873", null, 56632523, "newJam@ucn.cl", "19098723K");
      if (!new RepositoryOrmLite<Persona, Long>(connectionSource, Persona.class).create(persona)) {
        Assertions.fail("No ´puede insertarse la persona");
      }
      //nueva ficha
      Ficha ficha = new Ficha(123, "Dancer", "gato", ZonedDateTime.now(), "Quiltro", 'H', "Blanco de pies grises",
              'I', persona);

      //repositorio de fichas
      Repository<Ficha, Long> repositorioFicha = new RepositoryOrmLite<>(connectionSource, Ficha.class);
      if (!repositorioFicha.create(ficha)) {
        Assertions.fail("Can't insert!");
      }
      Ficha validFicha = repositorioFicha.findById(1L);
      Assertions.assertNotNull(validFicha, "La ficha no es nula");
      Assertions.assertNotNull(validFicha.getFechaNacimiento(), "La ficha no es nula");
      Assertions.assertNotNull(validFicha.getCuidador().getRut(), "La ficha no es nula");
      log.debug("Ficha: {}.", Entity.toString(validFicha));
      log.debug("Ficha: {}.", Entity.toString(validFicha.getCuidador()));

    } catch (SQLException | IOException exception) {
      throw new RuntimeException(exception);
    }

  }

  @Test
  public void testRepository(){
    String databaseUrl = "jdbc:h2:mem:fivet_db";
    try (ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
      Repository<Persona, Long> theRepo = new RepositoryOrmLite<>(connectionSource, Persona.class);
      List<Persona> personas = theRepo.findAll();
      Assertions.assertEquals(0, personas.size(), "Size != 0");
    }catch (IOException | SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
