import java.util.Scanner;
public class Ejercicio_Do_3 {
  public static void main(String[] args) {

    /* Mejorael programa anterior, controlando que el número que se pida esté en el rango 1 –10 (incluidos).  Si  se  incluye  un  número  fuera  de  rango, 
       debe  mostrar  mensaje  de error  y  volver  a  pedirlo.  Si  el  número  está  en el  rango,  muestra  una salida  como en el ejercicio anterior.    */

    Scanner scan = new Scanner(System.in);
    int base;
    int count = 0;
    int resultado = 0;
    boolean valid_value = false;  
    
    System.out.print("Introduzca un numero para mostrar su tabla de multiplicar: ");
    base = scan.nextInt();

    if(base > 0 && base < 11){
      valid_value = true;
    }

    while(!valid_value){

      System.out.print("Introduzca un valor entre 1 y 10: ");
      base = scan.nextInt();
      
      if(base > 0 && base < 11){
        valid_value = true;
      }
    }

    System.out.println("Tabla del "+base);
    
    do {
    
    resultado = count * base;
    System.out.println(count + " x " + base + " = " + resultado);
    count++;

  } while (count < 11);
  }
}
