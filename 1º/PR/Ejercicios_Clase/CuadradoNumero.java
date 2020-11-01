package Ejercicios_Clase;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CuadradoNumero {
    public static void main(String[] ar) {
        Scanner teclado = new Scanner(System.in);
        int num;
        boolean continua;
        do {
            try {
                continua = false;
                System.out.print("Ingrese un valor entero:");
                num = teclado.nextInt();
                int cuadrado = num * num;
                System.out.print("El cuadrado de " + num + " es " + cuadrado);
            } catch (InputMismatchException ex) {
                System.out.println("Debe ingresar obligatoriamente un número entero.");
                teclado.next();
                continua = true;
            }
        } while (continua);
    teclado.close();
    }

}