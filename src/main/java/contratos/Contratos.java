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

import tdd.model.Ficha;
import tdd.model.Persona;

import java.util.List;

public interface Contratos {
  /**
   * Contrato: C01-Registrar los datos de un Paciente.
   *
   * @param ficha a insertar.
   * @return the {@link Ficha} en backend.
   */
  Ficha registrarPaciente(Ficha ficha);

  /**
   * Contrato: C02-Registrar los datos de una Persona.
   *
   * @param cuidador a insertar.
   * @return the {@link Persona} en backend.
   */
  Persona registrarCuidador(Persona cuidador);

  /**
   * Contrato: C03-Buscar Ficha
   *
   * @param indicio a buscar.
   * @return the {@link List} of {@link Ficha}.
   */
  List<Ficha> buscarFicha(String indicio);

  /**
   *
   * @param numero de ficha
   * @return cuidador de la mascota a la cual la ficha pertenece
   */
  Persona getPersonaFromFicha(Integer numero);

  /**
   *
   * @return todas las fichas
   */
  List<Ficha> getAllFichas();

  /**
   *
   * @return todas las personas
   */
  List<Persona> getAllPersonas();

  /**
   * @param idCuidador identificador
   * @return cuidador correspondiente al id
   */
  Persona getCuidador(Long idCuidador);

  /**
   * @param idFicha identificador
   * @return ficha correspondiente al id
   */
  Ficha getFicha(Long idFicha);
}
