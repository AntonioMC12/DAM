import java.util.Scanner;
import java.lang.Math;

  public class Ejercicio_If_3 {

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


    /*
    Programa quecalcule el índice de masa corporal de una persona (IMC = peso [kg] /altura^2[m])
     e indique el estado en el que se encuentra esa persona en función del valor de IMC:Valor de IMC Diagnóstico
     < 16 Criterio de ingreso en hospital
     de 16 a 18 bajo peso
     de 18a 25 peso normal (saludable)
     de 25 a 30 sobrepeso (obesidad de grado I)
     de 30 a 35 sobrepeso crónico (obesidad de grado II)
     de 35 a 40 obesidad premórbida (obesidad de grado III)
     >40 obesidad mórbida (obesidad de grado IV)
     Indicaciones:
     Emplea sentencias if–else anidadas.
     Los operandos (peso y altura) deben ser introducidos por teclado por el usuario.
    */


    public static void main(String[] args) {
      
      Scanner scan = new Scanner(System.in);

      double weigth = 0;
      float heigth = 0;
      boolean valid_weigth = false;
      boolean valid_heigth = false;
      double IMC = 0;

      System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLUE + " ----------------------- LISTA DE VALORES ----------------------- ");
      System.out.println(" | IMC < 16       | Criterio de ingreso en hospital             | ");
      System.out.println(" | IMC de 16 a 18 | bajo peso                                   | ");
      System.out.println(" | IMC de 18a 25  | peso normal (saludable)                     | ");
      System.out.println(" | IMC de 25 a 30 | sobrepeso (obesidad de grado I)             | ");
      System.out.println(" | IMC de 30 a 35 | sobrepeso crónico (obesidad de grado II)    | ");
      System.out.println(" | IMC de 35 a 40 | obesidad premórbida (obesidad de grado III) | ");
      System.out.println(" | IMC > 40       | obesidad mórbida (obesidad de grado IV)     | ");
      System.out.println(" ---------------------------------------------------------------- " + ANSI_RESET);

      while(!valid_heigth){ //bucle para controlar que la altura es introducida correctamente
        
        System.out.println(ANSI_RESET+ANSI_PURPLE_BACKGROUND + "Por favor, Introduzca su altura en METROS: " + ANSI_RESET + ANSI_GREEN);
        heigth= scan.nextFloat();

        if(heigth >= 0 && heigth < 2.5){
          valid_heigth = true;
        }
      }
      
      while(!valid_weigth){ //bucle para controlar que el peso es introducido correctamente

        System.out.println(ANSI_RESET+ANSI_PURPLE_BACKGROUND + "Por favor, Introduzca su peso en KILOS: " + ANSI_RESET + ANSI_GREEN);
        weigth= scan.nextDouble();

        if(weigth >= 0 && weigth < 250){
          valid_weigth = true;
        }
      }

      IMC = weigth/Math.pow(heigth, 2);

      if(IMC < 16){

        System.out.println(ANSI_RESET + ANSI_RED + ANSI_WHITE_BACKGROUND + "Su IMC es de: " + ANSI_RESET + ANSI_RED_BACKGROUND + IMC + ANSI_RED + ANSI_WHITE_BACKGROUND +" Debería visitar a su médico de cabezera...");

      }else if(IMC < 18){

        System.out.println(ANSI_RESET + ANSI_RED + ANSI_WHITE_BACKGROUND + "Su IMC es de: " + ANSI_RESET + ANSI_BLUE_BACKGROUND + IMC + ANSI_RED + ANSI_WHITE_BACKGROUND +" Tiene un peso bajo...");
      
      }else if(IMC < 25){

        System.out.println(ANSI_RESET + ANSI_RED + ANSI_WHITE_BACKGROUND + "Su IMC es de: " + ANSI_RESET + ANSI_GREEN_BACKGROUND + IMC + ANSI_RED + ANSI_WHITE_BACKGROUND +" Usted está saludable...");
      
      }else if(IMC < 30){

        System.out.println(ANSI_RESET + ANSI_RED + ANSI_WHITE_BACKGROUND + "Su IMC es de: " + ANSI_RESET + ANSI_BLUE_BACKGROUND + IMC + ANSI_RED + ANSI_WHITE_BACKGROUND +" Tiene obesidad de grado 1 ...");
      
      }else if(IMC < 35){

        System.out.println(ANSI_RESET + ANSI_RED + ANSI_WHITE_BACKGROUND + "Su IMC es de: " + ANSI_RESET + ANSI_RED_BACKGROUND + IMC + ANSI_RED + ANSI_WHITE_BACKGROUND +" Tiene obesidad de grado 2 ...");
      
      }else if(IMC < 40){

        System.out.println(ANSI_RESET + ANSI_RED + ANSI_WHITE_BACKGROUND + "Su IMC es de: " + ANSI_RESET + ANSI_RED_BACKGROUND + IMC + ANSI_RED + ANSI_WHITE_BACKGROUND +" Tiene obesidad de grado 3 ...");
      
      }else{

        System.out.println(ANSI_RESET + ANSI_RED + ANSI_WHITE_BACKGROUND + "Su IMC es de: " + ANSI_RESET + ANSI_WHITE + ANSI_BLACK_BACKGROUND + IMC + ANSI_RED + ANSI_WHITE_BACKGROUND +" Tiene obesidad de grado 4 ...");

      }

      scan.close();

    }  
  }
