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

import java.time.ZonedDateTime;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.ZonedDateTimeType;


/**
 * ficha con los datos de una mascota paciente de la veterinaria
 * @autor Javier Palacios
 */
@DatabaseTable(tableName = "Ficha")
public class Ficha {
  /**
   * clave primaria autoincremental
   */
  @DatabaseField(generatedId = true)
  private Long id;
  /**
   * numero identificiador de la ficha
   */
  @DatabaseField
  private int numero;
  /**
   * nombre de la mascota
   */
  @DatabaseField(canBeNull = false)
  private String nombre;
  /**
   * especie biologica de la mascota
   */
  @DatabaseField(canBeNull = false)
  private String especie;
  /**
   * fecha de nacimiento de la mascota
   */
  @DatabaseField(persisterClass = ZonedDateTimeType.class)
  private ZonedDateTime fechaNacimiento;
  /**
   * raza de la mascota
   */
  @DatabaseField
  private String raza;
  /**
   * sexo de la mascota f/m (femenino/masculino)
   */
  @DatabaseField(canBeNull = false)
  private Character sexo;
  /**
   * color de la mascota
   */
  @DatabaseField
  private String color;
  /**
   * tipo de tratamiento a la mascota i/e (interno/externo)
   */
  @DatabaseField(canBeNull = false)
  private Character tipo;
  /**
   * cuidador a cargo de la mascota
   */
  @DatabaseField(foreign = true, canBeNull = false, foreignAutoRefresh = true)
  private Persona cuidador;

  Ficha(){
    //constructor vacio
  }

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
  public Ficha(int numero, String nombre, String especie, ZonedDateTime fechaNacimiento, String raza, Character sexo,
               String color, Character tipo, Persona cuidador) {
    this.numero = numero;
    this.nombre = nombre;
    this.especie = especie;
    this.fechaNacimiento = fechaNacimiento;
    this.raza = raza;
    this.sexo = sexo;
    this.color = color;
    this.tipo = tipo;
    this.cuidador = cuidador;
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
  public ZonedDateTime getFechaNacimiento() {
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
  public Character getSexo() {
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
  public Character getTipo() {
    return tipo;
  }

  public Long getId() {
    return id;
  }

  public Persona getCuidador() {
    return cuidador;
  }
}
