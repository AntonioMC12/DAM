import java.util.Scanner;

  public class Ejercicio_If_2 {

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
        Mi tienda de ropa preferida, tiene los siguientes descuentos esta semana: Si la compra es inferior a 30 euros,
        no hay dto. Si la compra está entre 30 y 50, dto de 10% Si la compra es superior a 50 euros,dto de 15%.Realiza
          un programa que pida el importe de la compra, y devuelva el importe final que hay que pagar, con el descuento 
          adecuado.Sería adecuado usar una sola línea "println" para mostrar el resultado.Ej: precio compra 100 euros, 
          salida del programa = "se le ha realizado un descuento de 15 %, precio final = 85 euros".
      */
        /*
        --------------------------------------------------------------
        | Importe menor de 30€     ----> No hay descuento disponible |
        | Importe entre 30€ y 50€  ----> 10% de descuento            |
        | Importe superior a 50€   ----> 15% de descuento            | 
        --------------------------------------------------------------
        */


    public static void main(String[] args) {

      Scanner scan = new Scanner(System.in);
      double price = 0;
      double discount_10 = 0.1;
      double discount_15 = 0.15;
      double final_price = 0;
      boolean valid_price = false;

      System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLUE + " -------------------------------------------------------------- ");
      System.out.println(" | Importe menor de 30€     ----> No hay descuento disponible | ");
      System.out.println(" | Importe entre 30€ y 50€  ----> 10% de descuento            | ");
      System.out.println(" | Importe superior a 50€   ----> 15% de descuento            | ");
      System.out.println(" -------------------------------------------------------------- " + ANSI_RESET);

      while(!valid_price){ //bucle para controlar que el precio es introducido correctamente        
        System.out.print(ANSI_RESET+ANSI_RED_BACKGROUND + "Por favor, Introduzca el importe de su compra:" + ANSI_RESET + " " +  ANSI_GREEN);
        price = scan.nextDouble();
        if(price > -1){
          valid_price = true;
        }
      }

      if(price < 30){

        final_price = price;
        System.out.println(ANSI_CYAN_BACKGROUND + ANSI_RED + "Su Importe total es menor a 30€, por tanto, no tiene ningún descuento.");
        System.out.println(ANSI_CYAN_BACKGROUND + "El Precio Total es de = " + ANSI_GREEN_BACKGROUND + final_price + ANSI_RESET);

      }else if(price < 50){

        final_price = price - price * discount_10;
        System.out.println(ANSI_CYAN_BACKGROUND + ANSI_RED +"Su Importe total es menor a 50€, por tanto, tiene un descuento del 10%" + ANSI_GREEN_BACKGROUND);
        System.out.println(ANSI_CYAN_BACKGROUND + "El Precio Total es de = " + ANSI_GREEN_BACKGROUND + final_price + ANSI_RESET);
      }else{

        final_price = price - price * discount_15;
        System.out.println(ANSI_CYAN_BACKGROUND + ANSI_RED +"Su Importe total es superior a 50€, por tanto, tiene un descuento del 15%" + ANSI_GREEN_BACKGROUND);
        System.out.println(ANSI_CYAN_BACKGROUND + "El Precio Final es de = " + ANSI_GREEN_BACKGROUND + final_price + ANSI_RESET);

      }

      System.out.println("");
      System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLUE + " -------------------------------------------------------------- ");
      System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLUE + " |                   ¡GRACIAS POR SU COMPRA!                  | ");
      System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLUE + " -------------------------------------------------------------- ");
      scan.close();
    }
}
