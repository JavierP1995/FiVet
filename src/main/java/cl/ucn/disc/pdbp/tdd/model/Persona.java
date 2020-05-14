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

import tdd.util.Validation;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * persona responsable de una mascota
 * @autor Javier Palacios
 */
@DatabaseTable(tableName = "Persona")
public class Persona {
  /**
   * clave primaria con autoincremento
   */
  @DatabaseField(generatedId = true)
  private long id;
  /**
   * nombre de la persona
   */
  @DatabaseField(canBeNull = false)
  private String nombre;
  /**
   * direccion de la persona
   */
  @DatabaseField()
  private String direccion;
  /**
   * telefono fijo de la persona
   */
  @DatabaseField()
  private Integer telefonoFijo;
  /**
   * telefono movil de la persona
   */
  @DatabaseField()
  private Integer telefonoMovil;
  /**
   * correo electronico de la persona
   */
  @DatabaseField()
  private String correo;
  /**
   * rut de la persona;
   */
  @DatabaseField(canBeNull = false, index = true)
  private String rut;

  /**
   * contructor vacio: Default visibility + empty body.
   */
  Persona() {
    // nothing here.
  }

  /**
   * constructor de la persona
   * @param nombre
   * @param direccion
   * @param telefonoFijo
   * @param telefonoMovil
   * @param correo
   * @param rut
   */
  public Persona(String nombre, String direccion, Integer telefonoFijo, Integer telefonoMovil, String correo, String rut) {
    if (nombre == null || rut == null || (telefonoMovil == 0 && telefonoFijo == 0)) {
      throw new NullPointerException("La persona debe otorgar al menos un nombre, un telefono y un rut");
    }
    if (telefonoFijo > 999999 || telefonoFijo < 200000) {
      throw new RuntimeException("El telefono fijo no es válido");
    }
    if (telefonoFijo > 99999999 || telefonoFijo < 40000000) {
      throw new RuntimeException("El telefono movil no es válido");
    }
    if (nombre.length() < 2) {
      throw new RuntimeException("El nombre debe tener al menos 2 letras");
    }
    if (!Validation.isEmailValid(correo)) {
      throw new RuntimeException("El correo no es valido");
    }
    if (!Validation.isRutValid(rut)) {
      throw new RuntimeException("El rut no es valido");
    }
    this.nombre = nombre;
    this.direccion = direccion;
    this.telefonoFijo = telefonoFijo;
    this.telefonoMovil = telefonoMovil;
    this.correo = correo;
    this.rut = rut;
  }

  /**
   * @return nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @return direccion
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * @return telefono fijo
   */
  public Integer getTelefonoFijo() {
    return telefonoFijo;
  }

  /**
   * @return telefono movil
   */
  public Integer getTelefonoMovil() {
    return telefonoMovil;
  }

  /**
   * @return correo electronico
   */
  public String getCorreo() {
    return correo;
  }

  /**
   * @return rut
   */
  public String getRut() {
    return rut;
  }

  /**
   * @return id
   */
  public long getId() {
    return id;
  }
}
