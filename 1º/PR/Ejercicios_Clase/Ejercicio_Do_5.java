package Ejercicios_Clase;

import java.util.Scanner;

public class Ejercicio_Do_5 {
  public static void main(String[] args) {

    /* Realiza un programa que pida edades de personas, debe controlar que la edad sea un número positivo(si se introdujese una edad negativa, 
    debe volver a pedir la edad de esa persona. Cada vez que se introduzca la edad de una nueva persona, se debe calcular el promedio de las 
    edades introducidas. El programa finalizará cuando el promedio supere 30 años.*/

    int edad = 0, add_edad = 0; 
    float mean; 
    int count = 1; // para llevar la cuenta de personas
    Scanner scan = new Scanner(System.in);
    boolean valid_value = false; //para entrar y salir del bucle de la eddad valida

    do { //bucle para introducir edades hasta superar la media

      while(!valid_value){  //bucle para introducir la edad con valor positivo

        System.out.print("Introduzca la edad de la persona " + count + ": ");
        edad = scan.nextInt();

        if(edad < 0){
          System.out.print("Intruduzca un valor positivo, por favor. ");
        }else{
          valid_value=true;
        }
      } // end bucle para validad la edad

      add_edad += edad;
      mean = add_edad / count;
      valid_value = false;

      count++;
    } while (mean <= 30);
    
    scan.close();
    System.out.println("El promedio de edad introducido es: "+mean);
  }
}
