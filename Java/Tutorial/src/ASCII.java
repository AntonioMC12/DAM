import java.util.Scanner;

public class ASCII {

	public static void main(String[] args) {
		//A class that show the ASCII equivalent 
		
		System.out.println("Introduzca un caracter y pulse intro");
		
		//iniciamos el scanner
		
		Scanner scan = new Scanner(System.in);
		
		char carac = scan.next().charAt(0);
		
		//pasamos el string a ASCII
		
		int ascii = (int) carac;
		
		//mostramos el ascii por pantalla
		
		System.out.println("El número correspondiente es: "+ascii);
		
		//cerramos el scaner
		
		System.out.println("Cerrando escaner...");
		
		try {
			
			Thread.sleep(1*1000);
			scan.close();
			
		}catch(Exception exc){
			
			System.out.println(exc);
			
		};
		
		System.out.println("Escaner Cerrado.");
	}

}
