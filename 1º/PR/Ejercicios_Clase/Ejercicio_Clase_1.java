
import java.util.Scanner;

    public class Ejercicio_Clase_1 {
    
        public static void main(String[] args) {
                
                /*
                programa que lea y prueba si es multiplo de 5
                */

            Scanner scan = new Scanner(System.in);

            System.out.println("Please, Type a number...");

            int num = scan.nextInt();

            if(num % 5 == 0){

                System.out.println("The number " + num + " is divisible by 5.");
         
            }else{
                
                System.out.println("The number " + num + " is NOT divisible by 5.");

            }

            scan.close();

        }          
}
