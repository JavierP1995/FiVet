package cl.ucn.disc.pdbp.tdd.model;

import java.time.LocalDateTime;

public class Ficha {
  private int numero;
  private String nombre;
  private String especie;
  private LocalDateTime fechaNacimiento;
  private String raza;
  private char sexo;
  private String color;
  private char tipo;

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

  public int getNumero() {
    return numero;
  }

  public String getNombre() {
    return nombre;
  }

  public String getEspecie() {
    return especie;
  }

  public LocalDateTime getFechaNacimiento() {
    return fechaNacimiento;
  }

  public String getRaza() {
    return raza;
  }

  public char getSexo() {
    return sexo;
  }

  public String getColor() {
    return color;
  }

  public char getTipo() {
    return tipo;
  }
}
