package Ejercicios_Bucles;
import java.util.Scanner;

public class Ejercicio_2 {

	public static void main(String[] args) {
		/*
		 * 2.-Escribe un programa que obtenga los numeros enteros comprendidosentre dos numeros introducidos
		 *    por teclado y validados como distintos. El programa debe empezar por el menor de los enteros
		 *    introducidos e ir incrementando de 7 en 7
		 */
		
		//We ask for the variables to the user
		
		System.out.println("please type a number and press enter");
		
		//start the scanner
		
		Scanner scan = new Scanner(System.in);
		
		//create the variable for the numbers
		
		double num1 = scan.nextDouble();
		
		//ask for the other variable
		
		System.out.println("please type a number and press enter again");
		
		double num2 = scan.nextDouble();
		
		//check that aren't equals
		
		System.out.println("checking if the numbers are equals...\n");
		
		if(num1 == num2) {
			
			while(num1 == num2) {
				System.out.println("the numbers are equals...\n");
				
				System.out.println("please type a number");
				num1 = scan.nextDouble();
				
				System.out.println("please type another number");
				num2 = scan.nextDouble();
			}
		}
		
		System.out.println("The numbers aren't equals.\n");
		
		//put the small number in num1 variable
		
		if(num1>num2) {
			//create a aux variable to switch the variable
			double aux = num2;
			num2 = num1;
			num1 = aux;
		}
		
		//variable for count the number of repetition
		double count = 0;
		
		System.out.println("The numbers between adding 7 at each time are...");
		
		while(num1 < num2) {		
			if((num2-num1) > 7) {
				num1 = num1 + 7;
				System.out.println(num1);
				count++;
			}
			if(count == 0) {
				System.out.println("The are no number between, adding 7.");
			}break;
		}
		
		//close the scanner
		//le pongo algo de retardo por hacerlo algo mas estetito, se que es muy ineficiente.
		
		System.out.println("Closing Scanner...");
		scan.close();
				
	}

}
