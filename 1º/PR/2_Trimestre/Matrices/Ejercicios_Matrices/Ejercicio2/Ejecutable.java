package Ejercicio2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Problema 2: Se tiene la siguiente información: · Nombres de 4 empleados. ·
 * Ingresos en concepto de sueldo, cobrado por cada empleado, en los últimos 3
 * meses. Confeccionar el programa para: 
 * a) Realizar la carga de la información mencionada. 
 * b) Generar un vector que contenga el ingreso acumulado en sueldos en los 
 * últimos 3 meses para cada empleado. 
 * c) Mostrar por pantalla el total pagado en sueldos a todos los empleados en 
 * los últimos 3 meses 
 * d) Obtener el nombre del empleado que tuvo el mayor ingreso acumulado
 * 
 * @author Antonio
 *
 */
public class Ejecutable {

  public static void main(String[] args) {

    int numeroEmpleados = getInt("Introduzca el número de empleados a crear: ");
    Empleado[] empleados = new Empleado[numeroEmpleados];

    inicializaEmpleados(empleados);

    int numeroMeses = getInt("Inserte el número de meses que han trabajado: ");
    calculaAhorros(empleados, numeroMeses);

    System.out.println("El total pagado por la empresa es: " + calculaTotalAhorros(empleados));

    Arrays.sort(empleados);
    System.out.println("El empleado con más ahorros es: " + empleados[empleados.length - 1]);
  }

  /**
   * Devuelve un entero positivo que se ha introducido por teclado con el control
   * de errores, el argumento es el texto a mostrar por pantalla.
   * 
   * @param text texto a mostrar por pantalla
   * @return valor introducido por teclado.
   */
  public static int getInt(String text) {

    boolean validNum = true;
    Scanner scan = new Scanner(System.in);
    int num = 0;

    do {
      try {
        System.out.print(text);
        num = scan.nextInt();
        if (num < 1) {
          System.out.println("Inserte un valor positivo.");
          validNum = true;
        } else {
          validNum = false;
        }

      } catch (InputMismatchException ex) {

        scan.nextLine();
        validNum = true;
        System.out.println("Debe ingresar obligatoriamente un numero valido.");

      } catch (Exception e) {

        scan.nextLine();
        validNum = true;
        System.out.println("Debe ingresar obligatoriamente un numero valido.");

      }
    } while (validNum);

    return num;
  }

  /**
   * Devuelve un double positivo que se ha introducido por teclado con el control
   * de errores, el argumento es el texto a mostrar por pantalla.
   * 
   * @param text texto a mostrar por pantalla
   * @return valor introducido por teclado.
   */
  public static double getDouble(String text) {

    boolean validNum = true;
    Scanner scan = new Scanner(System.in);
    double num = 0;

    do {
      try {
        System.out.print(text);
        num = scan.nextDouble();
        if (num < 0) {
          System.out.println("Inserte un valor positivo.");
          validNum = true;
        } else {
          validNum = false;
        }

      } catch (InputMismatchException ex) {

        scan.nextLine();
        validNum = true;
        System.out.println("Debe ingresar obligatoriamente un numero valido.");

      } catch (Exception e) {

        scan.nextLine();
        validNum = true;
        System.out.println("Debe ingresar obligatoriamente un numero valido.");

      }
    } while (validNum);

    return num;
  }

  /**
   * Devuelve un String introducido por teclado
   * 
   * @param text texto a mostrar por pantalla
   * @return valor introducido por teclado.
   */
  public static String getString(String text) {
    String texto = "";
    Scanner scan = new Scanner(System.in);
    System.out.println(text);
    texto = scan.next();

    return texto;
  }

  /**
   * Funcion que inicializa un array de empleados añadiendo su nombre y sueldo de
   * cada empleado.
   * 
   * @param empleados array de empleados
   */
  public static void inicializaEmpleados(Empleado[] empleados) {
    if (empleados != null && empleados.length > 0) {
      for (int i = 0; i < empleados.length; i++) {
        String nombre = getString("Introduzca el nombre: ");
        double sueldo = getDouble("Introduzca el sueldo: ");
        empleados[i] = new Empleado(nombre, sueldo);
        System.out.println("");
        System.out.println("Empleado creado con éxito...");
        System.out.println("");
      }
    }
  }

  /**
   * Funcion que calcula los ahorros usando el sueldo y los meses trabajados, que
   * son pasados por parámetros.
   * 
   * @param empleados   Array de empleados.
   * @param numeroMeses meses trabajados.
   */
  public static void calculaAhorros(Empleado[] empleados, int numeroMeses) {
    if (empleados != null && empleados.length > 0 && numeroMeses > 0) {
      for (int i = 0; i < empleados.length; i++) {
        empleados[i].setAhorros(empleados[i].getSueldo() * numeroMeses);
      }
    }
  }

  /**
   * Calcula el total gastado por la empresa en sueldos de los empleados sumando
   * los ahorros de todos los empleados.
   * 
   * @param empleados Array de empleados.
   * @return total Total gastado por la empresa.
   */
  public static double calculaTotalAhorros(Empleado[] empleados) {
    double total = 0;
    if (empleados != null && empleados.length > 0) {
      for (Empleado empleado : empleados) {
        total += empleado.getAhorros();
      }
    }

    return total;
  }

}
