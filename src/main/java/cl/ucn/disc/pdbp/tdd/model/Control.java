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
  private Persona veterinario;

  /**
   * ficha de la mascota
   */
  private Ficha ficha;

  /**
   * constructor del control
   * @param fecha
   * @param proximoControl
   * @param temperatura
   * @param peso
   * @param altura
   * @param diagnostico
   * @param veterinario
   * @param ficha
   */
  public Control(LocalDateTime fecha, LocalDateTime proximoControl, float temperatura, float peso, float altura,
                 String diagnostico, Persona veterinario, Ficha ficha) {
    this.fecha = fecha;
    this.proximoControl = proximoControl;
    this.temperatura = temperatura;
    this.peso = peso;
    this.altura = altura;
    this.diagnostico = diagnostico;
    this.veterinario = veterinario;
    this.ficha = ficha;
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
  public Persona getVeterinario() {
    return veterinario;
  }

  /**
   * @return ficha de la mascota
   */
  public Ficha getFicha() { return ficha; }
}
