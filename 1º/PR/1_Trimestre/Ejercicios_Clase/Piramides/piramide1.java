import java.util.Scanner;

public class piramide1{
  public static void main(String[] args) {


    /*
           *
          ***
         *****
        ******* 
    */
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Inserte la altura: ");
    int alt = scan.nextInt();
    int aux = alt;
    
    for (int fila = 1; fila <= alt; fila++) {
      for(int nEspacios = aux -1; nEspacios >= 0 ; nEspacios--){
        //Para los espacios
        System.out.print("  ");
      }
      for(int nAsteriscos = 1 ; nAsteriscos <= (fila*2)-1 ; nAsteriscos++){
        //Para los asteriscos
        System.out.print("* ");   
      }
      aux--;
      System.out.println(""); 
    }
    scan.close();
  }
}