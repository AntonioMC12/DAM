import java.util.Scanner;

public class piramide2 {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    /*
     
    
        *   
       * *
      *   *
     ******* 
     
     
     */

    System.out.println("Inserte la altura: ");
    int altura = scan.nextInt();
    int aux = altura;

    for (int fila = 1; fila <= altura; fila++) {
      for (int nEspacios = aux - 1; nEspacios >= 0; nEspacios--) {
        // Para los espacios
        System.out.print(" ");
      }
      for (int nAsteriscos = 1; nAsteriscos <= (fila * 2) - 1; nAsteriscos++) {
        // Para los asteriscos
        if (nAsteriscos == 1 || nAsteriscos == (fila * 2) - 1 || fila == altura) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      aux--;
      System.out.println("");
    }
    scan.close();
  }
}