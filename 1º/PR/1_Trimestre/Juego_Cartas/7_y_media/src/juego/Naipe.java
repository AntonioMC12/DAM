/**
 * 
 */
package juego;

/**
 * Clase Naipe, clase que guarda las características de un naipe. Su valor o
 * número y el palo al que pertenece.
 * 
 * Para el juego de las 7 y media vamos a utilizar la baraja Española.
 * 
 * @author Antonio
 *
 */
public class Naipe {
  
  private int valor;
  private String palo;

  /**
   * Constructor de la clase Naipe, le pasamos por parámetro el valor y el palo.
   * 
   * @param valor de la carta
   * @param palo  de la carta
   */
  public Naipe(int valor, String palo) {
    this.palo = palo;
    this.valor = valor;
  }

  /**
   * Constructor por defecto del naipe, inicializado con valores basura.
   */
  public Naipe() {
    this(-1, "None");
  }

  /**
   * @return the valor
   */
  public int getValor() {
    return valor;
  }

  /**
   * @param valor the valor to set
   */
  public void setValor(int valor) {
    this.valor = valor;
  }

  /**
   * @return the palo
   */
  public String getPalo() {
    return palo;
  }

  /**
   * @param palo the palo to set
   */
  public void setPalo(String palo) {
    this.palo = palo;
  }

  @Override
  public String toString() {
    return "Naipe [valor=" + valor + ", palo=" + palo + "]";
  }

}
