//package Ejercicios_Bucles;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio_11{

  /*
  11. Escribe un programa que muestre por pantalla todos los números enteros positivos 
  menores a uno leído por teclado que no sean divisibles entre otro también leído de 
  igual forma
  */

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int num1 = getInt("Intoduzca un número: ", scan);
    int num2 = getInt("Introduzca otro número: ", scan);
    int div = getInt("Introduzca su divisor: ", scan);

    int high = getHigher(num1, num2);
    int low = getLower(num1, num2);

    for( ; high > low ; high--){
      if(isDivisible(high, div)){
        p(high + ", ");
      }
    }
    scan.close();
    
  }

  static boolean isDivisible(int num1, int div){

    if(num1 % div == 0){
      return true;
    }else{
      return false;
    }
  }

  static int getLower(int num1, int num2){
    
    if (num1 > num2) {
      int aux = num1;
      num1 = num2;
      num2 = aux;
    }
    
    return num1;
  }
  
  static int getHigher(int num1, int num2){
    
    if (num1 < num2) {
      int aux = num1;
      num1 = num2;
      num2 = aux;
    }
    
    return num1;
  }

  static int getInt(String texto, Scanner scan){
    //Funcion para la introduccion de números por teclado

    int resultado = -1;
    boolean valid = false;

    do{			

      try{
        p(texto);
        resultado=scan.nextInt();
        valid=true;
       

      }catch(InputMismatchException ex){
        //ex.printStackTrace();
        //teclado=new Scanner(System.in);

        P("¡Error! inserte un numero entero");
        scan.nextLine();
      }
    }while(!valid); 

    return resultado;
  }

  static void P(String texto){
    System.out.println(texto);
  }

  static void p(String texto){
    System.out.print(texto);
  }



}