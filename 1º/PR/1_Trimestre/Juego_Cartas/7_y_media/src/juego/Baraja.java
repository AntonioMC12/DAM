/**
 * 
 */
package juego;

import java.util.Arrays;

/**
 * Clase baraja, es un array de Naipes, depende de la baraja, ser� de un tama�o
 * u otro, al tratarse de la baraja espa�ola el array tendr� una longitud de 40
 * naipes. Tambien tiene un c�digo para identificar la baraja.
 * 
 * @author Antonio
 *
 */
public class Baraja {

  final static int TAMANO_BARAJA = 40;
  static int serialNumber = 0;

  private int code;
  private Naipe[] cartas;

  /**
   * Constructor de baraja, asigna un c�digo �nico, y crea un array de 40 naipes.
   */
  public Baraja() {
    this.code = serialNumber;
    serialNumber++;
    this.cartas = new Naipe[TAMANO_BARAJA];
  }

  /**
   * @return the code
   */
  public int getCode() {
    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode(int code) {
    this.code = code;
  }

  /**
   * @return the cartas
   */
  public Naipe[] getCartas() {
    return cartas;
  }

  /**
   * @param cartas the cartas to set
   */
  public void setCartas(Naipe[] cartas) {
    this.cartas = cartas;
  }

  @Override
  public String toString() {
    return "Baraja [code=" + code + ", cartas=" + Arrays.toString(cartas) + "]";
  }
  
  
}
