import java.util.InputMismatchException;
import java.util.Scanner;

public class iniciaMatriz {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    System.out.println("Se va a crear una matriz 3x5...");
    System.out.println("Creando matriz...");
    System.out.println("");
    System.out.println("");

    int[][] matriz = new int[3][5];

    System.out.println("Procediendo a inicializar la matriz 3x5...");
    System.out.println("");

    creaMatriz(matriz);

    System.out.println("");
    System.out.println("Matriz inicializada.");
    System.out.println("Mostrando matriz...");
    System.out.println("");

    imprimeMatriz(matriz);

    scan.close();
  }

  /**
   * inicializa una matriz con numeros introducidos por teclado
   * 
   * @param matriz a inicializar
   * @return matriz inicializada
   */
  public static int[][] creaMatriz(int[][] matriz) {
    if (matriz != null) {
      for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
          matriz[i][j] = getInt("Introduzca el elemento " + i + "," + j + ": ");
        }
      }
    }
    return matriz;
  }

  /**
   * Devuelve un entero introducido por teclado despues de comprobar que es un
   * entero. si no lo es, lo pide hasta que introduzca uno.
   * 
   * @param text texto a mostrar al usuario.
   * @return entero introducido por teclado.
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
