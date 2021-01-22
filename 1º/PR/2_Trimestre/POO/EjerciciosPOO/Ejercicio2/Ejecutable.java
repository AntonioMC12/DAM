package Ejercicio2;

import java.util.Scanner;

public class Ejecutable {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner scan = new Scanner(System.in);

    System.out.print("Introduzca un número para crear un vector de array, con la cantidad introducida: ");
    int tamArray = scan.nextInt();

    Password[] arrayPassword = new Password[tamArray];
    boolean[] passFuertes = new boolean[tamArray];

    System.out.print("Introduzca el tamaño de las contraseñas: ");
    int tamPass = scan.nextInt();

    iniciaArray(arrayPassword, tamPass);
    passFuertes(passFuertes, arrayPassword);
    mostrarResultado(arrayPassword, passFuertes);

    scan.close();
  }

  /**
   * Inicia un array con tamaño del parametro pasado
   * 
   * @param array   a iniciar
   * @param tamPass tamaño del array
   */
  public static void iniciaArray(Password[] array, int tamPass) {
    for (int i = 0; i < array.length; i++) {
      array[i] = new Password(tamPass);
    }
  }

  /**
   * Devuelve un array de booleanos con la posicion de cada contraseña, mostrando
   * true si es fuerte y false si no lo es.
   * 
   * @param array de contraseñas
   * @return array de booleanos
   */
  public static void passFuertes(boolean[] passFuertes, Password[] array) {
    for (int i = 0; i < array.length; i++) {
      if (array[i].esFuerte()) {
        passFuertes[i] = true;
      } else {
        passFuertes[i] = false;
      }
    }
  }

  /**
   * Funcion que muestra los resultados
   * 
   * @param arrayPass
   * @param arrayFuertes
   */
  public static void mostrarResultado(Password[] arrayPass, boolean[] arrayFuertes) {
    for (int i = 0; i < arrayPass.length; i++) {
      if (arrayFuertes[i]) {
        System.out.println("La Contraseña " + i + " es fuerte");
      } else {
        System.out.println("La Contraseña " + i + " es débil");
      }
      System.out.println(arrayPass[i].getContrasenia());
    }
  }
}
