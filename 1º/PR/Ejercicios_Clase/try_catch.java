import java.util.Scanner;

import java.util.Scanner;
import java.util.InputMismatchException;

public class try_catch {
  //leer sucesivaente numero hasta que salga un numero comprendido entre 1 y 5 inclusives, se sale
  //CON CONTROL DE ERRORES
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    int input_num;
    boolean valid = true;
    System.out.print("Introduzca un número ");
    do {
      try {
        input_num = scan.nextInt();

        if(input_num > 0 || input_num < 6){
          valid = false;
        }
        
      } catch (InputMismatchException e) {
        System.out.println("Introduzca un número.");
      } finally{
        System.out.println("Fin del programa");
      }
    } while (valid);
  System.out.println("Fin del programa");
  scan.close();
  }
}
