import java.util.Scanner;
import java.util.InputMismatchException;
//import java.lang.Match;

public class Calculadora{

  //Introduzco una seria de comando ANSI para tener colores en la consola de Linux (Compatible solo en Linux y Mac)

    //Reset
    public static final String ANSI_RESET = "\u001B[0m";
    //Colores de letra
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    //Colores de fondo
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

  public static void main(String[] args) {
    
    //El programa te da a elejir entre sumar, multiplicar, restar y dividir dos numeros introducidos por teclado
    
    Scanner scan = new Scanner(System.in);    
    boolean valid; //auxiliar para entrar y salir de los bucles 
    int op_menu = 0;  //variables para seleccionar la operacion
    double num1 = 0;  //primer valor introducido
    double num2 = 0;  //segundo valor introducido
    double total = 0; //valor total
    boolean infinity = false; //determina si hemos divido entre 0

    //cabezera grafica de la calculadora
    System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLUE + " -------------- CALCULADORA V.0 -------------- ");

    System.out.println(" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"1" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA SUMAR          | ");

    System.out.println(" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"2" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA RESTAR         | ");

    System.out.println(" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"3" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA MULTIPLICAR    | ");

    System.out.println(" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"4" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA DIVIDIR        | ");

    System.out.println(" --------------------------------------------- " + ANSI_RESET);

    do{ //control de errores de la selección de la operación, solo avance el progrma si introduce un char valido dentro de nuestro rango

        try {
          
          valid = false;
          
          System.out.print(ANSI_WHITE_BACKGROUND + ANSI_RED + "INSERTA AQUÍ ---->" + ANSI_RESET + " " + ANSI_GREEN);
          
          op_menu = scan.nextInt(); //entero para determina la entrada en el menú de la calculadora
          
          if(op_menu != 1 && op_menu != 2 && op_menu != 3 && op_menu != 4){
          
            System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK +"Debe insertar un valor válido..." + ANSI_RESET);
          
            valid = true;
          }
          
        } catch (InputMismatchException ex) {

          System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + "Debe ingresar obligatoriamente un número entero." + ANSI_RESET);

          scan.next();

          valid = true;
        }

    }while(valid);
    
    do{ //control de errores del primer digito que introducimos, solo avance el progrma si introduce un char valido dentro de nuestro rango

      try {
        
        valid = false;
        
        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_RED + "INSERTA AQUÍ SU PRIMER VALOR ---->" + ANSI_RESET + " " + ANSI_GREEN);
        
        num1 = scan.nextDouble(); //entero para determina la entrada en el menú de la calculadora
        
      } catch (InputMismatchException ex) {

        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + "Debe ingresar obligatoriamente un número real." + ANSI_RESET);

        scan.next();

        valid = true;
      }

    }while(valid);

    do{ //control de errores del segundo digito que introducimos, solo avance el progrma si introduce un char valido dentro de nuestro rango

      try {
        
        valid = false;
        
        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_RED + "INSERTA AQUÍ SU SEGUNDO VALOR ---->" + ANSI_RESET + " " + ANSI_GREEN);
        
        num2 = scan.nextDouble(); //entero para determina la entrada en el menú de la calculadora
        
      } catch (InputMismatchException ex) {

        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + "Debe ingresar obligatoriamente un número real." + ANSI_RESET);

        scan.next();

        valid = true;
      }

    }while(valid);
  
    //hacemos el switch para realizar la operación elegida
    switch (op_menu) {

      //1 suma, 2 resta, 3 multiplica, 3 divide
      
      case 1:
        
        total = num1 + num2;

        break;
      
      case 2:
        
        total = num1 - num2;

        break;

      case 3:
        
        total = num1 * num2;

        break;
        
      case 4:
        
        if(num2 == 0){
          
          System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + "El resultado es infinito, no podemos dividir por 0" + ANSI_RESET);

          infinity = true;

          break;
        }

        total = num1 / num2;

        break;      
      
      default:

        System.out.print(ANSI_RED_BACKGROUND + ANSI_BLACK + "Syntax Error" + ANSI_RESET);

        break;
    }

    if(!infinity){

    System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLUE + " -------------------------------------------------------------- ");
    System.out.println(ANSI_RESET + "                      EL RESULTADO ES: " + total + "                   " + ANSI_RESET);
    System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLUE + " -------------------------------------------------------------- ");
    
    }


  }
}