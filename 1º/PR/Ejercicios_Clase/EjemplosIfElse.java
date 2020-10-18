import java.util.Scanner;

public class EjemplosIfElse{

    public static void main(String[] args) {    
    
    Scanner scan = new Scanner(System.in);

    System.out.println("Introduzca su edad...");

    int num = scan.nextInt();

    if( num > 0 && num < 18 ){
        
        System.out.println("Eres menor de edad.");
    }
    if( num > 18){

        System.out.println("Eres mayor de edad.");
    }else { 

        System.out.println("error, no has nacido aun...");

    }

    
    }
}
    