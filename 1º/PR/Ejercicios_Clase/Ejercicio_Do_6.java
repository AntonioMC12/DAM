package Ejercicios_Clase;

import java.util.Scanner;

public class Ejercicio_Do_6 {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int day;
    int moth = 0;
    int year = 0;
    boolean valid_imput = false;

    do{

      System.out.println("Introduzca el dia");
      day = scan.nextInt();

      if(day > 0 && day < 31){
        valid_imput = true;
      }else{
        System.out.println("Dia incorrecto, vuelva a empezar...");
        valid_imput = false;
      }

      if(valid_imput){
        System.out.println("Introduzca el mes");
        moth = scan.nextInt();

        if(moth > 0 && moth < 13){
          valid_imput = true;
        }else{
          System.out.println("Mes incorrecto, vuelva a empezar...");
          valid_imput = false;
        }
      }

      if(valid_imput){
        System.out.println("Introduzca el anio");
        year = scan.nextInt();

        if(year > 0 && year < 2021){
          valid_imput = true;
        }else{
          System.out.println("Anio incorrecto, vuelva a empezar...");
          valid_imput = false;
        }
      }
    }while(!valid_imput);
    
    scan.close();
    System.out.println("La fecha introducida es: " + day + "-" + moth + "-" + year);
  }
}
