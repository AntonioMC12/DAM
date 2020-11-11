import java.util.Scanner;
import java.util.InputMismatchException;

public class funciones {

  static int count = 0;
  static float mean = 0;
  static int mean_count = 0;
  static int high = 0;
  public static void main(String[] args) {
    		/*
		 * 3.-Realiza un programa que vaya pidiendo números hasta que se introduzca un número
		 *    negativo y nos diga cuantos números se han introducido, la media de los impares y
		 *    el mayor de los pares. El número negativo sólo seutiliza para indicar el final 
		 *    de la introducción de datos pero no se incluye enel cómputo.
		 */

    //realizamos el bucle para pedir número hasta que meta un negativo
    int num = 0;
 

    do {
      num = InputNum();
      if(!isNegative(num)){

        if(isPair(num)){
          high = higher(num, high);
        }else{
          mean += num;
          mean_count++;
        };

        count++;
      }
    } while (!isNegative(num));

    solucion();
  }

  static boolean isPair(int num){
    boolean pair = false;
    if(num % 2 == 0){
      pair = true;
    }
    return pair;
  }

  static void solucion(){
    System.out.println("The higher pair number is: "+high);
		System.out.println("The mean of the inpair number is: "+mean/mean_count);
		System.out.println("The total of numbers intruduced was: "+count); 
  }

  static int higher(int num1, int num2){

    if(num1 < num2){
      int aux = num1;
      num1 = num2;
      num2 = aux;
    }
    return num1;
  }

  static boolean isNegative(int num){
    boolean isNegative = false;
    if(num < 0){
      isNegative = true;
    }
    return isNegative;
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
  
}
