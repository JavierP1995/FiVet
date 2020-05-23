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

package contratos;

import cl.ucn.disc.pdbp.tdd.model.Control;
import cl.ucn.disc.pdbp.tdd.model.Ficha;
import cl.ucn.disc.pdbp.tdd.model.Persona;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import dao.RepositoryOrmLite;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ContratosImpl implements Contratos {

  /**
   * The Logger.
   */
  private static final Logger log = LoggerFactory.getLogger(ContratosImpl.class);

  /**
   * The connection to the backend.
   */
  private final ConnectionSource connectionSource;

  /**
   * The {@link RepositoryOrmLite} of Ficha.
   */
  private final RepositoryOrmLite<Ficha, Long> repoFicha;

  /**
   * The {@link RepositoryOrmLite} of Ficha.
   */
  private final RepositoryOrmLite<Persona, Long> repoPersona;

  /**
   * The {@link RepositoryOrmLite} of Ficha.
   */
  private final RepositoryOrmLite<Control, Long> repoControl;

  /**
   * The Constructor.
   *
   * @param databaseUrl to use to connect.
   */
  public ContratosImpl(String databaseUrl) {

    log.debug("Using <{}> as databaseUrl ..", databaseUrl);
    try {

      // The connection
      log.debug("Creating the Connection ..");
      connectionSource = new JdbcConnectionSource(databaseUrl);

      // Create the table
      log.debug("Creating the Tables ..");
      TableUtils.createTableIfNotExists(connectionSource, Ficha.class);
      TableUtils.createTableIfNotExists(connectionSource, Persona.class);
      TableUtils.createTableIfNotExists(connectionSource, Control.class);

      // The repo
      log.debug("Creating the Repos ..");
      repoFicha = new RepositoryOrmLite<>(connectionSource, Ficha.class);
      repoPersona = new RepositoryOrmLite<>(connectionSource, Persona.class);
      repoControl = new RepositoryOrmLite<>(connectionSource, Control.class);

    } catch (SQLException throwables) {
      throw new RuntimeException(throwables);
    }
  }

  /**
   * Contrato: C01-Registrar los datos de un Paciente.
   *
   * @param ficha a insertar.
   * @return the {@link Ficha} en backend.
   */
  @Override
  public Ficha registrarPaciente(Ficha ficha) {
    return null;
  }

  /**
   * Contrato: C02-Registrar los datos de una Persona.
   *
   * @param persona a insertar.
   * @return the {@link Persona} en backend.
   */
  @Override
  public Persona registrarPersona(Persona persona) {
    return null;
  }

  /**
   * Contrato: C03-Buscar Ficha
   *
   * @param indicio a buscar.
   * @return the {@link List} of {@link Ficha}.
   */
  @Override
  public List<Ficha> buscarFicha(String indicio) {
    // The main list
    List<Ficha> fichas = new ArrayList<>();

    try {

      // Indicio numerico
      if (StringUtils.isNumeric(indicio)) {

        // 1. Encontrar por numero
        log.debug("buscando por numero ..");
        fichas.addAll(this.repoFicha.findAll("numero", indicio));

        // 2. Encontrar por fragmento de rut
        // https://ormlite.com/javadoc/ormlite-core/doc-files/ormlite_3.html#Join-Queries
        log.debug("buscando por rut ..");
        QueryBuilder<Persona, Long> personaQuery = repoPersona.getQuery();

        personaQuery.where().like("rut", "%" + indicio + "%");

        fichas.addAll(this.repoFicha.getQuery().join(personaQuery).query());

      }

      // 3. Encontrar por fragmento del paciente
      log.debug("buscando por nombre paciente ..");
      fichas.addAll(this.repoFicha.getQuery().where().like("nombrePaciente", "%" + indicio + "%").query()
      );

      // 4. Encontrar por fragmento del nommbre del cuidador
      log.debug("buscando por nombre cuidador ..");
      QueryBuilder<Persona, Long> personaQuery = repoPersona.getQuery();
      personaQuery.where().like("nombre", "%" + indicio + "%");

      fichas.addAll(repoFicha.getQuery().join(personaQuery).query()
      );

    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }

    // Remove duplicated (by id)
    return new ArrayList<>(
            fichas.stream().collect(
                    Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Ficha::getId)))
            )
    );
  }
}
