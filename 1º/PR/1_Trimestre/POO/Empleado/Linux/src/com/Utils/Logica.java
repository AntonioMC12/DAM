package com.Utils;
import com.Trabajo.Empleado;

/**
 * Clase donde incluyo la lógica de los menús y la lógica principal del programa.
 * 
 * @author Antonio Muñoz Cubero
 */

public class Logica {

  /**
   * Funcion para realizar las diferentes opciones del menú principal
   * 
   * @param E1 Clase Empleado para modificar sus parámetros
   * @param op La opcion del menú
   */
  public static void switchPrincipal(Empleado E1,int op){

    switch (op) {
      case 1:
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Menus.showMenuParametros();
        switchParametros(E1, Menus.getMenuParametros());

        break;

      case 2:

        E1.increaseSalary(Introducir.getDouble("Introduzca el aumento del salario en €: "));
        Imprimir.P(""+E1);
        Menus.showMenuPrincipal();
        switchPrincipal(E1, Menus.getMenuPrincipal());

        break;

      case 3:

        E1.increaseSalary(Introducir.getInt("Introduzca el aumento del salario en %: "));
        Imprimir.P(""+E1);
        Menus.showMenuPrincipal();
        switchPrincipal(E1, Menus.getMenuPrincipal());

        break;

      case 4:

        //Menus.showEnd();

        break;
   
      default:

        Menus.showError();

        break;
    }
  }
  
  /**
   * Función para realizar las diferentes opciones del menú de modificar los parámetros
   * 
   * @param E1 La clase Empleado
   * @param op La opción a realizar
   */
  public static void switchParametros(Empleado E1, int op){

    switch (op) {
      case 1:
        
        E1.setName(Introducir.getString("Introduzca su nuevo nombre: "));
        Imprimir.P(""+E1);
        Menus.showMenuParametros();
        switchParametros(E1, Menus.getMenuParametros());
        break;

      case 2:
        
        E1.setDpto(Introducir.getString("Introduzca su nuevo departamento: "));
        Imprimir.P(""+E1);
        Menus.showMenuParametros();
        switchParametros(E1, Menus.getMenuParametros());
        break;

      case 3:
        
        E1.setAge(Introducir.getIntAge("Introduzca su nueva edad: "));
        Imprimir.P(""+E1);
        Menus.showMenuParametros();
        switchParametros(E1, Menus.getMenuParametros());
        break;

      case 4:
        
        E1.setSalary(Introducir.getDouble("Introduzca su nuevo salario: "));
        Imprimir.P(""+E1);
                Menus.showMenuParametros();
        switchParametros(E1, Menus.getMenuParametros());
        break;

      case 5:
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Imprimir.P("");
        Menus.showMenuPrincipal();
        switchPrincipal(E1, Menus.getMenuPrincipal());

        break;

      default:
        break;
    }
  }

  /**
   * Recibe la clase con la que trabajaremos y ejecuta la lógica principal del programa. Cuando sale del 
   * manú principal, muestra una selección de opciones que confirma si quieres salir o no del programa.
   * 
   * @param E1 Clase Empleado.
   */
  public static void program(Empleado E1){
    Menus.showMenuPrincipal();
    switchPrincipal(E1, Menus.getMenuPrincipal());
    Menus.exitProgram(E1);
  }
}
