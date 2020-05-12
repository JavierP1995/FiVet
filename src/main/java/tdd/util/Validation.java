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

package tdd.util;

/**
 * clase auxiliar con metodos de validacion para entradas de datos
 * @autor Javier Palacios
 */
public class Validation {

  /**
   * Valida el rut a través del digito verificador
   * @param rut ruta a validar
   * @return yes/no validez del rut
   * @throws RuntimeException en caso de que el rut contenga valores no numericos
   */
  public static boolean isRutValid(String rut) throws RuntimeException {
    char verificador = rut.charAt(rut.length() - 1);
    int iterador = rut.length() - 2;
    int suma = 0;
    int i = 2;
    try {
      while (true) {
        if (iterador == -1) {
          break;
        }
        if (i == 8) {
          i = 2;
        }
        suma = suma + Character.getNumericValue(rut.charAt(iterador)) * i;
        iterador--;
        i++;
      }
    } catch (java.lang.NumberFormatException error) {
      throw new RuntimeException("Rut con valores no numericos");
    }
    suma = 11 - suma % 11;
    if (suma == 10 && verificador == 'K') {
      return true;
    } else if (suma == Character.getNumericValue(verificador)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * valida el correo a traves de la expresion regular tipica
   * @param correo correo a ser revisado
   * @return yes/no la validez del correo
   */
  public static boolean isEmailValid(String correo) {
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    if (correo.matches(regex)) {
      return true;
    }
    return false;
  }

}
