package com.Utils;

/**
 * Clase para acortar el método de print
 * 
 * @author Antonio Muñoz Cubero
 */

public class Imprimir {

  /**
   * Sustituye a System.out.print
   * 
   * @param text
   */
  public static void p(String text) {
    System.out.print(text);
  }
  
  /**
   * Sustituye a System.out.println
   * 
   * @param text
   */
  public static void P(String text) {
    System.out.println(text);
  }
}
