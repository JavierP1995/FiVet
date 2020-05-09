package cl.ucn.disc.pdbp.tdd.model;

import tdd.util.Validation;

public class Persona {
  private String nombre;
  private String direccion;
  private long telefonoFijo;
  private long telefonoMovil;
  private String correo;
  private String rut;

  public Persona(String nombre, String direccion, long telefonoFijo, long telefonoMovil, String correo, String rut) {
    if (nombre == null || rut == null || (telefonoMovil == 0 && telefonoFijo == 0)) {
      throw new NullPointerException("La persona debe otorgar al menos un nombre, un telefono y un rut");
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

  public String getNombre() {
    return nombre;
  }

  public String getDireccion() {
    return direccion;
  }

  public long getTelefonoFijo() {
    return telefonoFijo;
  }

  public long getTelefonoMovil() {
    return telefonoMovil;
  }

  public String getCorreo() {
    return correo;
  }

  public String getRut() {
    return rut;
  }
}
