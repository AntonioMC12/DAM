import java.util.Scanner;
public class Ejercicio_for_2{
	
	public static void main(String[] args){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Introduzca un valor para calcular su factorial: ");
        	int fact = scan.nextInt();

		for(int aux = fact -1  ; aux > 0 ; aux--){
			fact = fact * aux;	
		}

		System.out.println("El Factorial es: "+fact);
		scan.close();	
	}
}
