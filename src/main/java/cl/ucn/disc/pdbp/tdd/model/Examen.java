package cl.ucn.disc.pdbp.tdd.model;

import java.time.LocalDateTime;

public class Examen {
  private String nombre;
  private String resultado;
  private LocalDateTime fecha;

  public Examen(String nombre, String resultado, LocalDateTime fecha) {
    this.nombre = nombre;
    this.resultado = resultado;
    this.fecha = fecha;
  }

  public String getNombre() {
    return nombre;
  }

  public String getResultado() {
    return resultado;
  }

  public LocalDateTime getFecha() {
    return fecha;
  }
}
