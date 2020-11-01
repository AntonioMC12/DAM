package Ejercicios_Clase;

import java.util.Scanner;

public class EjemplosIfElse_2{
  /*
    saber si es par o no el numero introducido
  */

  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);

    System.out.println("Type a number...");

    int num = scan.nextInt();

    if( num % 2 == 0){

      System.out.println("The introduced number is pair.");
      
    }else{

      System.out.println("The introduced number is not pair.");

    }

    scan.close();
  }
}