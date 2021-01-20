package Ejercicio2;

import java.util.Scanner;

public class Ejecutable {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner scan = new Scanner(System.in);

    System.out.print("Introduzca un número para crear un vector de array, con la cantidad introducida: ");
    int tamArray = scan.nextInt();

    Password[] arrayPassword = new Password[tamArray];

    System.out.print("Introduzca el tamaño de las contraseñas: ");
    int tamPass = scan.nextInt();

    iniciaArray(arrayPassword, tamPass);
    boolean[] passFuertes = passFuertes(arrayPassword);
    mostrarResultado(arrayPassword, passFuertes);

    scan.close();
  }

  public static void iniciaArray(Password[] array, int tamPass) {
    for (int i = 0; i < array.length; i++) {
      array[i] = new Password(tamPass);
    }
  }

  public static boolean[] passFuertes(Password[] array) {
    boolean[] passFuertes = new boolean[array.length];
    for (int i = 0; i < array.length; i++) {
      if (array[i].esFuerte()) {
        passFuertes[i] = true;
      }
    }
    return passFuertes;
  }

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
