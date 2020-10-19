
public class Ejercicio_4 {

	public static void main(String[] args) {
		/*
		 *  4.-Muestra por pantalla todos los números primos entre 2 y 100,ambos incluidos.
		 */
		//make a loop to check the 100 first numbers
		
		for(int i = 1 ; i < 101 ; i++) {
			//check if is prime testing all the divisible number
			//create a variable for count the divisible numbers
			int count = 0;
			
			for(int x = 1 ; x < 101 ; x++) {
				if(i%x == 0) {
					count++;
				}
			}
			//if count is 2, its prime
			if(count == 2) {
				System.out.println("Is prime: "+i);
			}
		}
		
		
		
		
	}

}
