package Ejercicio2;

public class Password {

  final static int DEFAULT_LONGITUD = 8;
  final static char[] ELEMENTOS_PASS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
      'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C',
      'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
      'Z' }; // 62 elementos

  private int longitud;
  private String contrasenia;

  public Password(int longitud) {
    super();
    if (longitud > 8) {
      this.longitud = longitud;
    } else
      this.longitud = DEFAULT_LONGITUD;
    this.contrasenia = generatePass();
  }

  public Password() {
    super();
    this.longitud = DEFAULT_LONGITUD;
    this.contrasenia = generatePass();
  }

  public int getLongitud() {
    return longitud;
  }

  public void setLongitud(int longitud) {
    this.longitud = longitud;
  }

  public String getContrasenia() {
    return contrasenia;
  }

  private String generatePass() {
    String password = "";
    char[] elementos = new char[this.longitud];

    for (int i = 0; i < elementos.length; i++) {
      elementos[i] = ELEMENTOS_PASS[(int) (Math.random() * 62)];
      password += elementos[i];
    }
    return password;
  }

  public boolean esFuerte() {
    int numberOfMayus = 0;
    int numberOfMinus = 0;
    int numberOfNumber = 0;
    boolean esFuerte = false;

    for (int i = 0; i < this.longitud; i++) {
      if (96 < (int) this.contrasenia.charAt(i) && (int) this.contrasenia.charAt(i) < 123) {
        numberOfMinus++;
      } else if (64 < (int) this.contrasenia.charAt(i) && (int) this.contrasenia.charAt(i) < 91) {
        numberOfMayus++;
      } else if (47 < (int) this.contrasenia.charAt(i) && (int) this.contrasenia.charAt(i) < 58) {
        numberOfNumber++;
      }

    }

    if (numberOfMayus > 2 && numberOfMinus > 1 && numberOfNumber > 5) {
      esFuerte = true;
    }
    
    return esFuerte;
  }

}
