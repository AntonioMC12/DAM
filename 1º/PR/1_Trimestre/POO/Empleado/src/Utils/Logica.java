package Utils;
import Trabajo.Empleado;

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
        
        E1.setAge(Introducir.getInt("Introduzca su nueva edad: "));
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

  public static void program(Empleado E1){
    Menus.showMenuPrincipal();
    switchPrincipal(E1, Menus.getMenuPrincipal());
    Menus.exitProgram(E1);
  }
}
