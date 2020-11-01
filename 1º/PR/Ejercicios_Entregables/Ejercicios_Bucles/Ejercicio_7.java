import java.util.Scanner;

public class Ejercicio_7{
  public static void main(String[] args) {
    
    //Realiza un programa que pida un número por teclado y que luego muestre ese número al revés.
    Scanner scan = new Scanner(System.in);
    int num = -1;
    int aux = -1;

    System.out.print("Introduce un número: ");
    num = scan.nextInt();
    System.out.print("El número "+num+" al revés es: ");

    while (num > 0){
      aux = num%10;
      System.out.print(aux);
      num = (num - aux)/10;
    } 
    scan.close();
  }
}