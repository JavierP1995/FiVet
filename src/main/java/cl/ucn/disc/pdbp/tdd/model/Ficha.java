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
 * ficha con los datos de una mascota paciente de la veterinaria
 * @autor Javier Palacios
 */
public class Ficha {
  /**
   * numero identificiador de la ficha
   */
  private int numero;
  /**
   * nombre de la mascota
   */
  private String nombre;
  /**
   * especie biologica de la mascota
   */
  private String especie;
  /**
   * fecha de nacimiento de la mascota
   */
  private LocalDateTime fechaNacimiento;
  /**
   * raza de la mascota
   */
  private String raza;
  /**
   * sexo de la mascota f/m (femenino/masculino)
   */
  private char sexo;
  /**
   * color de la mascota
   */
  private String color;
  /**
   * tipo de tratamiento a la mascota i/e (interno/externo)
   */
  private char tipo;

  /**
   * constructor de la ficha
   * @param numero
   * @param nombre
   * @param especie
   * @param fechaNacimiento
   * @param raza
   * @param sexo
   * @param color
   * @param tipo
   */
  public Ficha(int numero, String nombre, String especie, LocalDateTime fechaNacimiento, String raza, char sexo,
               String color, char tipo) {
    this.numero = numero;
    this.nombre = nombre;
    this.especie = especie;
    this.fechaNacimiento = fechaNacimiento;
    this.raza = raza;
    this.sexo = sexo;
    this.color = color;
    this.tipo = tipo;
  }

  /**
   * @return numero
   */
  public int getNumero() {
    return numero;
  }

  /**
   * @return nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @return especie
   */
  public String getEspecie() {
    return especie;
  }

  /**
   * @return fecha de nacimiento
   */
  public LocalDateTime getFechaNacimiento() {
    return fechaNacimiento;
  }

  /**
   * @return raza
   */
  public String getRaza() {
    return raza;
  }

  /**
   * @return sexo
   */
  public char getSexo() {
    return sexo;
  }

  /**
   * @return color
   */
  public String getColor() {
    return color;
  }

  /**
   * @return tipo de tratamiento
   */
  public char getTipo() {
    return tipo;
  }
}
