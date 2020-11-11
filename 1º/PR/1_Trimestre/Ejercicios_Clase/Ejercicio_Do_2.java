

import java.util.Scanner;

public class Ejercicio_Do_2 {
  public static void main(String[] args) {

    //Realiza un programa que pida un número que pida un número, y muestre su tabla de multiplicar.

    Scanner scan = new Scanner(System.in);
    int base;
    int count = 0;
    int resultado = 0;
    System.out.print("Introduzca un numero para mostrar su tabla de multiplicar: ");
    base = scan.nextInt();

    
    System.out.println("Tabla del "+base);

    do {
      
      resultado = count * base;
      System.out.println(count + " x " + base + " = " + resultado);
      count++;

    } while (count < 11);
  
  }
  
}
