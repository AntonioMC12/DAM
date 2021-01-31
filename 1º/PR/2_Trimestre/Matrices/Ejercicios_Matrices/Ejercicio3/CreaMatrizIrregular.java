package Ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Problema 3:Haz un programa que permita crear una matriz irregular y luego
 * imprimir la matriz en forma completa.
 * 
 * @author Antonio
 *
 */

public class CreaMatrizIrregular {

  public static void main(String[] args) {

    int[][] matriz = creaMatriz();
    imprimeMatriz(matriz);

  }

  /**
   * Crea un vector de enteros del tamaño que le pasamos como argumento El vector
   * es creado y rellenado con valores aleatorios entre el 1 y el 9.
   * 
   * @param tam tamaño del vector
   * @return vector inicializado.
   */
  public static int[] creaVector(int tam) {
    int[] vector = null;
    if (tam > 0) {
      vector = new int[tam];
      for (int i = 0; i < vector.length; i++) {
        vector[i] = (int) ((Math.random() * 9) + 1);
      }
    }
    return vector;
  }

  public static int[][] creaMatriz() {
    int[][] matriz = null;

    int numeroFilas = getInt("Inserte el número de filas de la matriz: ");
    matriz = new int[numeroFilas][];

    for (int i = 0; i < numeroFilas; i++) {
      int tam = getInt("Inserta el tamaño de la fila " + (i + 1) + ": ");
      matriz[i] = creaVector(tam);
    }

    System.out.println("");
    System.out.println("Matriz creada con éxito");
    System.out.println("");

    return matriz;
  }

  /**
   * Devuelve un entero que se ha introducido por teclado con el control de
   * errores, el argumento es el texto a mostrar por pantalla.
   * 
   * @param text texto a mostrar por pantalla
   * @return valor introducido por teclado.
   */
  public static int getInt(String text) {

    boolean validNum = true;
    Scanner scan = new Scanner(System.in);
    int num = 0;

    do {
      try {
        System.out.print(text);
        num = scan.nextInt();
        validNum = false;

      } catch (InputMismatchException ex) {

        scan.nextLine();
        validNum = true;
        System.out.println("Debe ingresar obligatoriamente un numero valido.");

      } catch (Exception e) {

        scan.nextLine();
        validNum = true;
        System.out.println("Debe ingresar obligatoriamente un numero valido.");

      }
    } while (validNum);

    return num;
  }

  /**
   * método que imprime la matriz introducida
   * 
   * @param matriz a imprimir
   */
  public static void imprimeMatriz(int[][] matriz) {
    if (matriz != null) {
      for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
          System.out.print(matriz[i][j] + "  ");
        }
        System.out.println("");
      }
      System.out.println("");
    }
  }

}
