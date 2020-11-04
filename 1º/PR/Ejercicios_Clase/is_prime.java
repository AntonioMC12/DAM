
import java.util.Scanner;

public class is_prime {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    System.out.print("Introduce un numero para determinar si es par o no: ");
    int num = scan.nextInt();
    int count = 0;
    int div = 0;

    while(div <= num) { //dividimos entre todos los numeros
      div++;
      if(num%div == 0) { //cuando sea divisible aumenta el contador
        count++;
      }
    }
    //if count is 2, its prime
    if(count == 2) {
      System.out.println("Es primo");
    }else{
      System.out.println("No es primo");
    } 
    scan.close();
  }
}
