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
