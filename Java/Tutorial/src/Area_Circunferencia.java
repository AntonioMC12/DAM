//usamos el metodo scan
import java.util.Locale;
import java.util.Scanner;

public class Area_Circunferencia {

	public static void main(String[] args) {
		//Calcular el area de una circunferencia
		
		//Pedimos al usuario que intruduzca el radio de la circunferencia
		System.out.println("Introduzca el Radio de una circunferencia y pulse 'intro'");
		
		//creammos una variable para los datos introducidos por consola
		Scanner scan = new Scanner(System.in);
		
		scan.useLocale(Locale.US);
		
		
		//pasamos el string a un double
		
		double radio = scan.nextDouble();
		
		//Realizamos la formula del circulo
		
		double area = Math.PI*Math.pow(radio, 2);
		
		//Expresamos por pantalla la solucion
		
		System.out.println("El área es: " + area +"\n");
			
		//Cerramos el scanner
		
		System.out.println("Cerrando Scanner...\n");
		
	    scan.close();
	    
	    try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(1*1000);
         } catch (Exception e) {
            System.out.println(e);
         };
	    System.out.println("Scanner Cerrado.");
	}
}
