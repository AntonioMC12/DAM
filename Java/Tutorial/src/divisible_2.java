import java.util.Scanner;

public class divisible_2 {

	public static void main(String[] args) {
		
		//introducimos un numero por consola y decimos si es divisible entre 2
		//pedimos al usuario introducir el nombre por consola
		
		System.out.println("Introduzca un número\npara saber si es\ndivisible entre 2 \n\n PULSE INTRO CUANDO INTRODUZCA LA VARIABLE");
		
		//inicializamos el scanner
		Scanner scan = new Scanner(System.in);
				
		byte num = scan.nextByte();
		
		//ahora realizamos la operacion
		
		if(num%2 == 0) {
			System.out.println("El número "+num+" es divisible entre 2");
		}
		else {
			System.out.println("El número "+num+" no es divisible entre 2");
		}
		
		//close the scanner
		System.out.println("Cerrando Escaner...");
		try {
			Thread.sleep(1*1000);
			scan.close();
		} catch(Exception exc){
			System.out.println(exc);
		};
		
		System.out.println("Escaner Cerrado.");
	}
	
}
