package Utils;
import java.util.Scanner;

public class Validaciones
{

//metodo que lee un numero entero y comprueba todos los errores, una vez verificado, lo devuelve
	public static int readNumber() {
        int numero = 0;
        boolean valid = false;
        Scanner teclado = new Scanner(System.in);

        do {
            try {

                System.out.print("\nIntroduzca un numero: ");
                numero = teclado.nextInt();
                valid = true;
            } catch (Exception e) {
               // valid = false;
                System.out.println("Introduzca un numero correcto");
                teclado = new Scanner(System.in);
            }
        } while (!valid);
        return numero;
	}
	
	//metodo que lee un numero double y comprueba todos los errores, una vez verificado, lo devuelve
	public static double readNumberD() {
        double numero = 0;
        boolean valid = false;
        Scanner teclado = new Scanner(System.in);

        do {
            try {

                System.out.print("\nIntroduzca un valor: ");
                numero = teclado.nextDouble();
                valid = true;
            } catch (Exception e) {
               // valid = false;
                System.out.println("Introduzca un valor correcto");
                teclado = new Scanner(System.in);
            }
        } while (!valid);
        return numero;
	}
}