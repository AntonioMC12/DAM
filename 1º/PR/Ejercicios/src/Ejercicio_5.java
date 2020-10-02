import java.util.Scanner;

public class Ejercicio_5 {

	public static void main(String[] args) {
		/*
		 * 5.-Escribe un programa que permita ir introduciendo una serie indeterminada de números mientras
		 *    su suma no supere el valor 10000.Cuando esto último ocurra, se debe mostrar el total acumulado,
		 *    el contador de los números introducidos y la media.
		 */
		
		//create a variable for the total add
		//create a variable for the count of the introduced numbers
		double add = 0;
		double count = 0;
		
		//start the scanner
		Scanner scan = new Scanner(System.in);

		while(add <= 10000) {
			System.out.println("Type a number");
			double input_number = scan.nextDouble();
			add = add + input_number;
			count++;
		}
		
		System.out.println("The total add is: "+add);
		System.out.println("The total number introduced was: "+count);
		System.out.println("The mean is: "+add/count);
		
		scan.close();
		
	}

}
