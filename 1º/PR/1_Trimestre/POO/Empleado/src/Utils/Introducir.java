package Utils;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Introducir {

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

  public static char getChar() {
    
    Scanner scan = new Scanner(System.in);
    
    char value = scan.next().charAt(0);
    
    return value;
  }

  public static int getInt(String text) {
    
    boolean validNum = true;
    Scanner scan = new Scanner(System.in);
    int num = 0;

    do {   
      try {
        Imprimir.p(text);
        num = scan.nextInt();
        validNum = false;

        
      }  catch (InputMismatchException ex) {
        
        scan.nextLine();
        validNum = true;
        Imprimir.P(ANSI_RED_BACKGROUND + ANSI_WHITE + "Debe ingresar obligatoriamente un numero valido." + ANSI_RESET);
        

      } catch (Exception e) {
        
        scan.nextLine();
        validNum = true;
        Imprimir.P(ANSI_RED_BACKGROUND + ANSI_WHITE + "Debe ingresar obligatoriamente un numero valido." + ANSI_RESET);

      }
    } while(validNum);
    
    return num;
  }

  public static float getFloat(String text) {
    boolean validNum = true;
    Scanner scan = new Scanner(System.in);
    float num = -1;

    do {   
      try {
        Imprimir.p(text);
        num = scan.nextFloat();
        validNum = false;

        
      }  catch (InputMismatchException ex) {
        
        scan.nextLine();
        validNum = true;
        Imprimir.P(ANSI_RED_BACKGROUND + ANSI_WHITE + "Debe ingresar obligatoriamente un numero valido." + ANSI_RESET);
        

      } catch (Exception e) {
        
        scan.nextLine();
        validNum = true;
        Imprimir.P(ANSI_RED_BACKGROUND + ANSI_WHITE + "Debe ingresar obligatoriamente un numero valido." + ANSI_RESET);

      }
    } while(validNum);
    
    return num;
  }
  
  public static double getDouble(String text) {
    
    boolean validNum = true;
    Scanner scan = new Scanner(System.in);
    double num = 0;

    do {   
      try {
        Imprimir.p(text);
        num = scan.nextDouble();
        validNum = false;

        
      }  catch (InputMismatchException ex) {
        
        scan.nextLine();
        validNum = true;
        Imprimir.P(ANSI_RED_BACKGROUND + ANSI_WHITE + "Debe ingresar obligatoriamente un numero valido." + ANSI_RESET);
        

      } catch (Exception e) {
        
        scan.nextLine();
        validNum = true;
        Imprimir.P(ANSI_RED_BACKGROUND + ANSI_WHITE + "Debe ingresar obligatoriamente un numero valido." + ANSI_RESET);

      }
    } while(validNum);
    
    return num;
  }

  public static String getString(String text){
    Scanner scan = new Scanner(System.in);
    String value;

    Imprimir.p(text);
    value = scan.next();

    return value;
  }
}
