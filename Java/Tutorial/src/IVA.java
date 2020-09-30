import java.util.Scanner;

public class IVA {

	public static void main(String[] args) {
		//get the price of the product from the user
		
		System.out.println("Introduce the price of your \nproduct and press enter");
		
		//scan the variable in the console
		
		Scanner scan = new Scanner(System.in);
		
		int price = scan.nextInt();
		
		//once we get the price, then, calculate the final price
		
		//iva is a constant of 21%
		
		float iva = (float) 0.21;
		float total_price = price + price*iva;
		
		//show the result
		System.out.println("El precio total es: "+total_price);
		
		//closing the scanner
		System.out.println("Closing scanner...");
		try {
			
			Thread.sleep(1*1000);
			scan.close();
			
		}	catch(Exception exc) {
				
				System.out.println(exc);
				
			};
		
		System.out.println("Scanner closed.");
	}

}	
