package tdd.util;

public class Validation {

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
        if (i == 8){
          i = 2;
        }
        suma = suma + Character.getNumericValue(rut.charAt(iterador))*i;
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



}
