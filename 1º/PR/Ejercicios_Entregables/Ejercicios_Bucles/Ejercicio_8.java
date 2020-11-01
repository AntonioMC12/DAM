package Ejercicios_Bucles;
import java.util.Scanner;
import java.util.InputMismatchException;;


public class Ejercicio_8 {
  public static void main(String[] args) {

    //Escribe un programa que muestre, cuente y sume los múltiplos de 3 que hay entre 1 y un número leído por teclado.
    
    int totalCount = 0;
    int totalAdd = 0;
    int imputNum = -1;
    boolean validNum = false;
    Scanner scan = new Scanner(System.in);

    do {

      System.out.print("Por favor, introduzca un número: ");
      try {
        imputNum = scan.nextInt();

        if(imputNum < 0){

          validNum = false;
          System.out.println("Introduzca un valor válido.");

        }else{
          validNum = true;
        }
      }  catch (InputMismatchException ex) {
        
        scan.next();
        validNum = false;
        System.out.println("Introduzca un valor válido.");

      } catch (Exception e) {

        validNum = false;
        System.out.println("Introduzca un valor válido.");

      }
    } while(!validNum);

    System.out.print("Son multiplos de 3: ");
    for (int i = 1; i < imputNum; i++) {
      if (i%3==0) {
        System.out.print(i+", ");
        totalAdd += i;
        totalCount++;
      }
    }
    
    System.out.println("La suma total de los múltiplos es: "+totalAdd);
    System.out.println("Se ha iterado un total de  "+totalCount+" veces.");
    

    scan.close();
  }
}
