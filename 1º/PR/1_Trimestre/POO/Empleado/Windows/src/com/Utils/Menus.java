package com.Utils;

import com.Trabajo.Empleado;

/**
 * Clase donde guardos los menús y los métodos que estos usan para recibir las opciones correspondientes.
 * 
 * @author Antonio Muñoz Cubero
 */

public class Menus {

  /**
   * Muestra el menú principal
   */
  public static void showMenuPrincipal() {
    Imprimir.P("");
    Imprimir.P("");
    Imprimir.P(" +------------------------- MENÚ PRINCIPAL -------------------------+ ");
    Imprimir.P("");
    Imprimir.P("");
    Imprimir.P(" +------------------------ EMPLEADO   V.1 ---------------------------+ ");
    Imprimir.P(" | INTRODUZCA LA TECLA [1] PARA MODIFICAR PARÁMETROS                 | ");
    Imprimir.P(" | INTRODUZCA LA TECLA [2] PARA AUMENTAR SUELDO CON IMPORTE FIJO     | ");
    Imprimir.P(" | INTRODUZCA LA TECLA [3] PARA AUMENTAR EL SUELDO CON PORCENTAJE    | ");
    Imprimir.P(" | INTRODUZCA LA TECLA [4] PARA SALIR                                | ");
    Imprimir.P(" +-------------------------------------------------------------------+ ");
  }

  /**
   * Devuelve la opción elegida en el menú principal con el control de errores
   * 
   * @return
   */
  public static int getMenuPrincipal() {
    
    boolean valid = false;
    int op_menu = -1;
    
    do{ 
      
      valid = false;                
      op_menu = Introducir.getInt("INSERTA AQUI SU ELECCION ----> ");      
      
      if(op_menu != 1 && op_menu != 2 && op_menu != 3 && op_menu != 4){     
        
        Imprimir.P("Debe insertar un valor valido...");          
        valid = true;
        
      }          
    }while(valid);
    
    return op_menu;
  }

  /**
   * Muestra el menú de modificación de parámetros
   */
  public static void showMenuParametros(){
    Imprimir.P("");
    Imprimir.P("");
    Imprimir.P("+------------------------- MENÚ PARÁMETROS -------------------------+ " );
    Imprimir.P("");
    Imprimir.P("");
    Imprimir.P(" +------------------------ EMPLEADO   V.1 ---------------------------+ ");
    Imprimir.P(" | INTRODUZCA LA TECLA [1] PARA MODIFICAR EL NOMBRE                  | ");
    Imprimir.P(" | INTRODUZCA LA TECLA [2] PARA MODIFICAR EL DEPARTAMENTO            | ");
    Imprimir.P(" | INTRODUZCA LA TECLA [3] PARA MODIFICAR LA EDAD                    | ");
    Imprimir.P(" | INTRODUZCA LA TECLA [4] PARA MODIFICAR EL SALARIO                 | ");
    Imprimir.P(" | INTRODUZCA LA TECLA [5] PARA VOLVER                               | ");
    Imprimir.P(" +-------------------------------------------------------------------+ ");
  }

  /**
   * Devuelve la opción elegida en el menú de los parámetros con el previo control de errores.
   * 
   * @return
   */
  public static int getMenuParametros() {
    
    boolean valid = false;
    int op_menu = -1;
    
    do{ 
      
      valid = false;                
      op_menu = Introducir.getInt("INSERTA AQUI SU ELECCION ----> ");      
      
      if(op_menu != 1 && op_menu != 2 && op_menu != 3 && op_menu != 4 && op_menu != 5){     
        
        Imprimir.P("Debe insertar un valor valido...");          
        valid = true;
        
      }          
    }while(valid);
    
    return op_menu;
  }

  /**
   * Muestra un texto de despedida.
   */
  public static void showEnd(){
    
      Imprimir.P("Gracias por usar mi programa. Hasta la proxima!");

    }
  
  /**
   * Muestra un texto de error
   */
  public static void showError(){

    Imprimir.P("UPS!! SE HA PRODUCIDO UN ERROR!");

  }

  /**
   * Pequeño método que confirma si quieres o no iniciar el programa, que recibe y devuelve la clase 
   * con la que trabajamos.
   * 
   * @param E1
   */
  public static void startProgram(Empleado E1){
    
    Imprimir.P("");
    Imprimir.P("");
    Imprimir.p("¿Quiere empezar el programa? y/n: ");
    if (Introducir.getChar() == 'y'){
      Logica.program(E1);
    }else{
      showEnd();
    }
  }

  /**
   * Menú que confirma si quieres o no salir del programa, recibe y devuelve la clase con la que estamos
   * trabajando.
   * 
   * @param E1
   */
  public static void exitProgram(Empleado E1){

    Imprimir.P("");
    Imprimir.P("");
    Imprimir.p("¿Está seguro de querer salir? y/n: ");
    if (Introducir.getChar() == 'n'){
      Logica.program(E1);
    }else{
      showEnd();
    }
  }
}