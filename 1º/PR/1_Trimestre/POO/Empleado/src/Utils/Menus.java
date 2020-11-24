package Utils;

import Trabajo.Empleado;

public class Menus {

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

  public static void showMenuPrincipal() {
    Imprimir.P("");
    Imprimir.P("");
    Imprimir.P(ANSI_GREEN + "+------------------------- MENÚ PRINCIPAL -------------------------+ " + ANSI_RESET);
    Imprimir.P("");
    Imprimir.P("");
    Imprimir.P(ANSI_WHITE_BACKGROUND + ANSI_BLUE + " +------------------------ EMPLEADO   V.1 -------------------------+ " + ANSI_RESET);
    Imprimir.P(ANSI_WHITE_BACKGROUND + ANSI_BLUE +" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"1" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA MODIFICAR PARÁMETROS                 | " + ANSI_RESET);
    Imprimir.P(ANSI_WHITE_BACKGROUND + ANSI_BLUE +" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"2" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA AUMENTAR SUELDO CON IMPORTE FIJO     | " + ANSI_RESET);
    Imprimir.P(ANSI_WHITE_BACKGROUND + ANSI_BLUE +" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"3" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA AUMENTAR EL SUELDO CON PORCENTAJE    | " + ANSI_RESET);
    Imprimir.P(ANSI_WHITE_BACKGROUND + ANSI_BLUE +" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"4" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA SALIR                                | " + ANSI_RESET);
    Imprimir.P(ANSI_WHITE_BACKGROUND + ANSI_BLUE +" +-----------------------------------------------------------------+ " + ANSI_RESET);
  }

  public static int getMenuPrincipal() {
    
    boolean valid = false;
    int op_menu = -1;
    
    do{ 
      
      valid = false;                
      op_menu = Introducir.getInt(ANSI_WHITE_BACKGROUND + ANSI_RED + "INSERTA AQUI SU ELECCION ---->" + ANSI_RESET + " " + ANSI_GREEN);      
      
      if(op_menu != 1 && op_menu != 2 && op_menu != 3 && op_menu != 4){     
        
        Imprimir.P(ANSI_RED_BACKGROUND + ANSI_WHITE +"Debe insertar un valor valido..." + ANSI_RESET);          
        valid = true;
        
      }          
    }while(valid);
    
    return op_menu;
  }

  public static void showMenuParametros(){
    Imprimir.P("");
    Imprimir.P("");
    Imprimir.P(ANSI_GREEN + "+------------------------- MENÚ PARÁMETROS -------------------------+ " + ANSI_RESET);
    Imprimir.P("");
    Imprimir.P("");
    Imprimir.P(ANSI_WHITE_BACKGROUND + ANSI_BLUE + " +------------------------ EMPLEADO   V.1 -------------------------+ " + ANSI_RESET);
    Imprimir.P(ANSI_WHITE_BACKGROUND + ANSI_BLUE +" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"1" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA MODIFICAR EL NOMBRE                  | " + ANSI_RESET);
    Imprimir.P(ANSI_WHITE_BACKGROUND + ANSI_BLUE +" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"2" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA MODIFICAR EL DEPARTAMENTO            | " + ANSI_RESET);
    Imprimir.P(ANSI_WHITE_BACKGROUND + ANSI_BLUE +" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"3" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA MODIFICAR LA EDAD                    | " + ANSI_RESET);
    Imprimir.P(ANSI_WHITE_BACKGROUND + ANSI_BLUE +" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"4" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA MODIFICAR EL SALARIO                 | " + ANSI_RESET);
    Imprimir.P(ANSI_WHITE_BACKGROUND + ANSI_BLUE +" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"5" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA VOLVER                               | " + ANSI_RESET);
    Imprimir.P(ANSI_WHITE_BACKGROUND + ANSI_BLUE +" +-----------------------------------------------------------------+ " + ANSI_RESET);
  }

  public static int getMenuParametros() {
    
    boolean valid = false;
    int op_menu = -1;
    
    do{ 
      
      valid = false;                
      op_menu = Introducir.getInt(ANSI_WHITE_BACKGROUND + ANSI_RED + "INSERTA AQUI SU ELECCION ---->" + ANSI_RESET + " " + ANSI_GREEN);      
      
      if(op_menu != 1 && op_menu != 2 && op_menu != 3 && op_menu != 4 && op_menu != 5){     
        
        Imprimir.P(ANSI_RED_BACKGROUND + ANSI_WHITE +"Debe insertar un valor valido..." + ANSI_RESET);          
        valid = true;
        
      }          
    }while(valid);
    
    return op_menu;
  }

  public static void showEnd(){
    
      Imprimir.P(ANSI_GREEN_BACKGROUND + ANSI_BLACK +"Gracias por usar mi programa. Hasta la proxima!" + ANSI_RESET);

    }
  
  public static void showError(){

    Imprimir.P(ANSI_RED_BACKGROUND + ANSI_BLACK +"UPS!! SE HA PRODUCIDO UN ERROR!" + ANSI_RESET);

  }

  public static void startProgram(Empleado E1){

    Imprimir.p(ANSI_GREEN + "¿Quiere empezar el programa? y/n: ");
    if (Introducir.getChar() == 'y'){
      Logica.program(E1);
    }else{
      showEnd();
    }
  }

  public static void exitProgram(Empleado E1){

    Imprimir.P("");
    Imprimir.P("");
    Imprimir.p(ANSI_GREEN + "¿Está seguro de querer salir? y/n: ");
    if (Introducir.getChar() == 'n'){
      Logica.program(E1);
    }else{
      showEnd();
    }
  }
}