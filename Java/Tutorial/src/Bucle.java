
public class Bucle {

	public static void main(String[] args) {
		//Make a loop with the number divisible for 2 and 3
		
		for(int i = 1 ; i <= 100 ; i++) {
			if((i%2==0)&&(i%3==0)) {
				System.out.println("El numero "+i+" es divisible por 2 y 3");
			}
		}

	}

}
