import java.util.Scanner;

public class Introducir_nombre {

	public static void main(String[] args) {
		//introducir nombre por consola y darle la bienvenida
		
		//Creamos la funcion para escanear lo introducido por consola
		Scanner scan = new Scanner(System.in);
		
		//Pedimos al usuario que introduzca su nombre para usarlo posteriormente
		System.out.println("Introduzca su nombre y pulse 'intro'");
		
		//Scaneamos el nombre introducido creando la variable nombre
		String nombre = scan.nextLine();
		
		//Le damos la bienvenida
		System.out.println("Bienvenido " + nombre + "!");
		
		scan.close();
	}

}
