import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio_9 {
  public static void main(String[] args) {

    /* Visualizar los enteros comprendidos entre dos números introducidos porteclado, validados como distintos,
     el programa empezara por el mayor y serealizará un decremento correspondiente a un tercer entero introducido 
     por tecladoy validado mayor que cero  */

     Scanner scan = new Scanner(System.in);
     int inputMayor = -1;
     int inputMenor = -1;
     int inputDecrease = -1;
     boolean validNum = true;

    
    /*

    No se como detectar cuando no ha saltado un catch para poder salir del bucle

    do {
      System.out.print("Por favor, introduzca otro número: ");
      try {
        inputMenor = scan.nextInt();

      }  catch (InputMismatchException ex) {
        
        scan.next();
        validNum = false;
        System.out.println("Introduzca un valor válido.");

      } catch (Exception e) {

        validNum = false;
        System.out.println("Introduzca un valor válido.");

      }
      if(inputMenor>-999999999 && inputMenor<999999999){
        validNum = true;
      }
    } while(!validNum);
    */

    System.out.print("Introduzca un número: ");
    inputMayor = scan.nextInt();
    System.out.print("Introduzca otro número: ");
    inputMenor = scan.nextInt();


    if(inputMayor < inputMenor){
      int aux = inputMayor;
      inputMayor = inputMenor;
      inputMenor = aux;
    }
    
    do {

      System.out.print("Por favor, introduzca un decrementador(mayor que 0): ");
      try {
        inputDecrease = scan.nextInt();

        if(inputDecrease < 0){

          validNum = false;
          System.out.println("Introduzca un valor válido.");

        }else{
          validNum = true;
        }
      }  catch (InputMismatchException ex) {
        
        scan.next();
        validNum = false;
        System.out.println("Introduzca un valor válido.");

      } catch (Exception e) {

        validNum = false;
        System.out.println("Introduzca un valor válido.");

      }
    } while(!validNum);

    System.out.println("Visualización final del programa...");
    for(int i = inputMayor ; i >= inputMenor ; i-=inputDecrease){
      System.out.print(i+", ");
    }
    scan.close();
  }
}
