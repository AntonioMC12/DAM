import java.util.Scanner;

    public class Ejercicio_Clase_3 {
        
        public static void main(String[] args) {
            
            /* Introducir una letra y que el programa distinga si es mayúscula o minúscula
            usando la tabla ascii */

            Scanner scan = new Scanner(System.in);

            System.out.println("Type a single character");

            char letter = scan.next().charAt(0);

            if(64 < letter && letter < 91){

                System.out.println("The character is a Capital");

            }else{

                System.out.println("The character is a lowe case");

            }
        }
    }
