package Ejercicios_Clase;

import java.util.Scanner;

public class Ejercicio_Clase_4 {
  
  public static void main(String[] args) {
    /*
    programa que lea por teclado 3 numeros enteros H, M, S correspondientes a hora, minutos y segundos respectivamente. 
    comprueba si la hora que indica es una hora válida.
    Muestra si es valido o no.
    */

    int Hour = 0;
    int Minut = 0;
    int Seconds = 0;

    Scanner scan = new Scanner(System.in);

    System.out.println("Please, introduce the hour... (24h format)");

    Hour = scan.nextInt();

    
    System.out.println("Please, introduce the minutes...");

    Minut = scan.nextInt();

    
    System.out.println("Please, introduce the seconds...");

    Seconds = scan.nextInt();

    if( ( (Hour > -1 && Hour < 25) && (Minut > -1 && Minut < 61) ) && (Seconds > -1 && Seconds < 61) ){

      System.out.println("The time is valid");

    }else{

      System.out.println("The time is not valid");
    
    }
    /*
    if(-1 < Hour && Hour < 25){

      if(-1 < Minut && Minut < 61){

        if(-1 < Seconds && Seconds < 61){

          System.out.println("The time is valid");

        }else{System.out.println("The time is not valid");}

      }else{System.out.println("The time is not valid");}

    }else{System.out.println("The time is not valid");}
    */
    scan.close();
  }
}
