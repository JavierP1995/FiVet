package cl.ucn.disc.pdbp.tdd.model;

import tdd.util.Validation;

/**
 * persona responsable de una mascota
 * @autor Javier Palacios
 */
public class Persona {
  /**
   * nombre de la persona
   */
  private String nombre;
  /**
   * direccion de la persona
   */
  private String direccion;
  /**
   * telefono fijo de la persona
   */
  private int telefonoFijo;
  /**
   * telefono movil de la persona
   */
  private int telefonoMovil;
  /**
   * correo electronico de la persona
   */
  private String correo;
  /**
   * rut de la persona;
   */
  private String rut;

  /**
   * constructor de la persona
   * @param nombre
   * @param direccion
   * @param telefonoFijo
   * @param telefonoMovil
   * @param correo
   * @param rut
   */
  public Persona(String nombre, String direccion, int telefonoFijo, int telefonoMovil, String correo, String rut) {
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
  public int getTelefonoFijo() {
    return telefonoFijo;
  }

  /**
   * @return telefono movil
   */
  public int getTelefonoMovil() {
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
}
