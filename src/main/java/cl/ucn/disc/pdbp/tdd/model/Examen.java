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

package cl.ucn.disc.pdbp.tdd.model;

import java.time.LocalDateTime;

/**
 * examen completado a una mascota
 * @author Javier Palacios
 */
public class Examen {
  /**
   * nombre del examen
   */
  private String nombre;
  /**
   * resultado del examen
   */
  private String resultado;
  /**
   * fecha en la que se realizo en examen
   */
  private LocalDateTime fecha;

  /**
   * constructor del examen
   * @param nombre
   * @param resultado
   * @param fecha
   */
  public Examen(String nombre, String resultado, LocalDateTime fecha) {
    this.nombre = nombre;
    this.resultado = resultado;
    this.fecha = fecha;
  }

  /**
   * @return nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @return resultado
   */
  public String getResultado() {
    return resultado;
  }

  /**
   * @return fecha
   */
  public LocalDateTime getFecha() {
    return fecha;
  }
}
