import java.util.Scanner;

    public class Ejercicio_Clase_2 {
    
        public static void main(String[] args) {
                
                /* introduce dos numero y comprueba si el mayor es divisible entre le menor  */

            Scanner scan = new Scanner(System.in);

            System.out.println("Please, type a number...");

            int mayor = scan.nextInt();

            System.out.println("Please, type another number...");

            int menor = scan.nextInt();

            if(menor > mayor){
                int aux = mayor;
                mayor = menor;
                menor = aux;
            }

            if(mayor%menor == 0){

                System.out.println("The number " + mayor + " is divisible by    " + menor);
         
            }else{
                
                System.out.println("The number " + mayor + " is NOT divisible " + menor);

            }

            scan.close();

        }          
}
