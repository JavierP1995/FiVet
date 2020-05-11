package cl.ucn.disc.pdbp.tdd.model;

import java.time.LocalDateTime;

/**
 * control realizado por una mascota
 * @autor Javier Palacios
 */
public class Control {
  /**
   * fecha en que se realizo el control
   */
  private LocalDateTime fecha;
  /**
   * fecha en la que debe realizar el proximo control
   */
  private LocalDateTime proximoControl;
  /**
   * temperatura que registro la mascota
   */
  private float temperatura;
  /**
   * peso que registro la mascota
   */
  private float peso;
  /**
   * altura que registro la mascota
   */
  private float altura;
  /**
   * diagnostico para la mascota
   */
  private String diagnostico;
  /**
   * veterinario que atendio a la mascota
   */
  private String veterinario;

  /**
   * constructor del control
   * @param fecha
   * @param proximoControl
   * @param temperatura
   * @param peso
   * @param altura
   * @param diagnostico
   * @param veterinario
   */
  public Control(LocalDateTime fecha, LocalDateTime proximoControl, float temperatura, float peso, float altura,
                 String diagnostico, String veterinario) {
    this.fecha = fecha;
    this.proximoControl = proximoControl;
    this.temperatura = temperatura;
    this.peso = peso;
    this.altura = altura;
    this.diagnostico = diagnostico;
    this.veterinario = veterinario;
  }

  /**
   * @return fecha control
   */
  public LocalDateTime getFecha() {
    return fecha;
  }

  /**
   * @return fecha proximo control
   */
  public LocalDateTime getProximoControl() {
    return proximoControl;
  }

  /**
   * @return temperatura registrada
   */
  public float getTemperatura() {
    return temperatura;
  }

  /**
   * @return peso registrado
   */
  public float getPeso() {
    return peso;
  }

  /**
   * @return altura registrada
   */
  public float getAltura() {
    return altura;
  }

  /**
   * @return diagnostico recibido
   */
  public String getDiagnostico() {
    return diagnostico;
  }

  /**
   * @return veterinario responsable
   */
  public String getVeterinario() {
    return veterinario;
  }
}
