package Ejercicio1;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/*
 * Problema 1: Crear una matriz de n * m filas (cargar n y m por teclado) 
 * Imprimir el mayor elemento y la fila y columna donde se almacena.
 */

public class Problema1 {

  public static void main(String[] args) {

    int filas = 0;
    int columnas = 0;

    filas = getInt("Inserte el número de filas: ");
    columnas = getInt("Inserte el número de columnas: ");

    int[][] matriz = new int[filas][columnas];

    creaMatriz(matriz);
    imprimeMatriz(matriz);
    imprimeMayor(matriz);

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
   * inicializa una matriz con numeros aleatorios entre el 0 y el 9
   * 
   * @param matriz a inicializar
   * @return matriz inicializada
   */
  public static int[][] creaMatriz(int[][] matriz) {
    if (matriz != null) {
      for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
          matriz[i][j] = (int) (Math.random() * 10);
        }
      }
    }
    return matriz;
  }

  /**
   * método que imprime la matriz introducida
   * 
   * @param matriz a imprimir
   */
  public static void imprimeMatriz(int[][] matriz) {
    if (matriz != null) {
      System.out.println("");
      for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
          System.out.print(matriz[i][j] + "  ");
        }
        System.out.println("");
      }
      System.out.println("");
    }
  }

  public static void imprimeMayor(int[][] matriz) {
    if (matriz != null) {

      int fila = 0;
      int columna = 0;
      int mayor = matriz[0][0];

      for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
          if (matriz[i][j] > mayor) {
            fila = i;
            columna = j;
            mayor = matriz[i][j];
          }
        }
      }

      System.out.println("El número más grande de la matriz es: " + mayor);
      System.out.println("Que está en la fila " + (fila + 1) + " y la columan " + (columna + 1));

    }
  }

}
