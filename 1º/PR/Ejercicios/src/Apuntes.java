
public class Apuntes {

	public static void main(String[] args) {
		//print the add of the 100 first pair number
		/*
		short i = 2;
		int add = 0;
		
		System.out.println("The program will show the add of the pair number before 101.\n");
		while(i < 101) {
			add+=i;
			i+=2;
		}
		System.out.println("The final add is: "+add);
		*/
		short i = 2;
		int add = 0;
		int count = 0;
		
		
		System.out.println("The program will show the mean of the pair number before 101...\n");
		while(i<101) {
			add+=i;
			i+=2;
			count++;
		}
		
		System.out.println("The mean is: "+add/count);
	}	

}
