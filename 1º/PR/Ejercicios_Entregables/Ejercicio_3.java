import java.util.Scanner;

public class Ejercicio_3 {

	public static void main(String[] args) {
		/*
		 * 3.-Realiza un programa que vaya pidiendo números hasta que se introduzca un número
		 *    negativo y nos diga cuantos números se han introducido, la media de los impares y
		 *    el mayor de los pares. El número negativo sólo seutiliza para indicar el final 
		 *    de la introducción de datos pero no se incluye enel cómputo.
		 */

		//start the scaner variable
		
		Scanner scan = new Scanner(System.in);
		double high = 0;    //auxiliar variable for the higher number 
		int count = 0;      //counter for the input number
		int mean_count = 0; //counter for the mean
		double mean = 0;    //auxiliar for the mean
		boolean valid = true;
		//do a loop with a trivial condition
		
		while(valid){//remodelado para que pare cuando el introducido sea impar
		
		//ask the user for a number
		
		System.out.println("please type a number and press enter");
		
		double input_num = scan.nextDouble();
		
		//check if the number is positive
		
		if(input_num%2 != 0) {
			valid = false;
		}
			
		count++;
			//check if is pair
			
			if(input_num%2 == 0) {
				
				//save the higher number
				if(input_num > high) {
					high = input_num;
				}
			}else {
				
				//calculate the add and later do the mean
				mean = mean + input_num;	
				mean_count++;
			
			}		
		}
		//show the results
		System.out.println("The higher pair number is: "+high);
		System.out.println("The mean of the inpair number is: "+mean/mean_count);
		System.out.println("The total of numbers intruduced was: "+count);
		scan.close();
	}

}
