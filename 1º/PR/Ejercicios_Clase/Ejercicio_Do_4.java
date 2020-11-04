

//import java.util.Scanner;
public class Ejercicio_Do_4 {
  public static void main(String[] args) {
    // Modifica el programa del ejercicio 2, para que te muestre las tablas de multiplicar de los números entre 1 y 10.
    //Scanner scan = new Scanner(System.in);
    int base = 1;
    int count = 0;
    int resultado = 0;

    do{

      System.out.println("Tabla del "+base);
        
      do {
          
          resultado = count * base;
          System.out.println(count + " x " + base + " = " + resultado);
          count++;

      } while (count < 11);

        base++;
        count = 0;
        System.out.println();

    }while(base < 11);
  }
}
