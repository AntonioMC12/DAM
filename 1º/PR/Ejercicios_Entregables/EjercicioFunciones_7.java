import java.util.Scanner;
import java.util.InputMismatchException;

public class EjercicioFunciones_7 {

  public static void main(String[] args) {

        //Realiza un programa que pida un número por teclado y que luego muestre ese número al revés.

        System.out.print("Introduce un número: ");
        num = InputNum();

        System.out.print("El número "+num+" al revés es: ");
        reves();
  }

  static int InputNum(){

    boolean validNum = true;
    Scanner scan = new Scanner(System.in);
    int num = 0;

    do {
      try {
        System.out.print("Por favor, introduzca un número: ");
        num = scan.nextInt();
        validNum = false;

        
      }  catch (InputMismatchException ex) {
        
        scan.next();
        validNum = true;
        System.out.println("Introduzca un valor válido.");
        scan.nextLine();

      } catch (Exception e) {

        validNum = true;
        System.out.println("Introduzca un valor válido.");
        scan.nextLine();

      }
    } while(validNum);
    
    return num;
  }

  static void reves(){
    int aux = -1;
    while (num > 0){
      aux = num%10;
      System.out.print(aux);
      num = (num - aux)/10;
    } 
  }
}