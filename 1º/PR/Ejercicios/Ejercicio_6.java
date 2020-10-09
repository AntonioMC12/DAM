import java.util.Scanner;

    public class Ejercicio_6 {

        public static void main(String[] args) {

        /*
        6.-Escribe un programa que lea un número N e imprima una pirámidede números con N filas como en la siguiente figura:
                                                            1
                                                           121
                                                          12321
                                                         1234321 
        */
        

        Scanner scan = new Scanner(System.in);
        
        int rows = scan.nextInt(); //variablo to store the number of rows
        int point = 1;             //auxiliar varible for the loop is point the row
        int spaces = 1;
                    

        for(point ; point <= rows ; point++){ //main loop that make every row

            for(spaces ; spaces < rows - point ; spaces++){
                
                System.out.print(" ");

            }

            for()

            System.out.println();
        
        }
    }


