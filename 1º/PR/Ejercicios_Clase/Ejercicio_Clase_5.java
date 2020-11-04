

import java.util.Scanner;

public class Ejercicio_Clase_5 {

    public static void main(String[] args) {

      /*
      Programa que nos pida una nota entre 1 y 10, si la nota no está en ese intervalo, mensaje de error
      y vuleve a pedir la hora, si la nota es menor de 3, muy deficiente, entre 3 y 5(no incluido) insuficiente
      entre 5 y 7 aprobado, entre 7 y 9 notable, entre 9 y 10 sobresaliente.
      */

      double qualy = 0;
      int count = 0;
      boolean valid = false;

      Scanner scan = new Scanner(System.in);

      while(!valid){
      
      System.out.println("Please type your qualification...");

      if(count > 0){

        System.out.println("Type your qualification right, please...");

      }

      qualy = scan.nextDouble();

      if(qualy > -1 && qualy < 11){
        
        break;

      }

      

      count++;

      }

      if(qualy > -1 && qualy < 3){

        System.out.println("Your qualification is very deficient");

      }
      if(qualy >= 3 && qualy < 5){

        System.out.println("Your qualification is deficient");
        
      }
      if(qualy >= 5 && qualy < 7){

        System.out.println("Your qualification is aproved");
        
      }
      if(qualy >= 7 && qualy < 9){

        System.out.println("Your qualification is remarkable");
        
      }
      if(qualy >= 9 && qualy < 10){

        System.out.println("Your qualification is very outstanding");
        
      }

    }
  
}
