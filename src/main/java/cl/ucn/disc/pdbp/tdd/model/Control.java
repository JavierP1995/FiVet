package cl.ucn.disc.pdbp.tdd.model;

import java.time.LocalDateTime;

public class Control {
  private LocalDateTime fecha;
  private LocalDateTime proximoControl;
  private float temperatura;
  private float peso;
  private float altura;
  private String diagnostico;
  private String veterinario;

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

  public LocalDateTime getFecha() {
    return fecha;
  }

  public LocalDateTime getProximoControl() {
    return proximoControl;
  }

  public float getTemperatura() {
    return temperatura;
  }

  public float getPeso() {
    return peso;
  }

  public float getAltura() {
    return altura;
  }

  public String getDiagnostico() {
    return diagnostico;
  }

  public String getVeterinario() {
    return veterinario;
  }
}
