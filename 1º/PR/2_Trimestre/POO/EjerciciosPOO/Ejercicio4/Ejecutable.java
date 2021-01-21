package Ejercicio4;

import java.util.Arrays;
import java.util.Scanner;

public class Ejecutable {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scan = new Scanner(System.in);

    Profesor[] arrayProfesores;
    int nFuncionario = 0;
    int nInterino = 0;
    System.out.print("Introduce el número de profesores: ");
    int tamArray = scan.nextInt();
    arrayProfesores = new Profesor[tamArray];

    // creacion de los profes
    for (int i = 0; i < arrayProfesores.length; i++) {
      if (interinoOFuncionario() == 1) {
        nInterino++;
        boolean apto = false;
        while (!apto) {
          ProfesorInterino auxiliar = setProfesorInterino();
          apto = true;
          for (Profesor aux : arrayProfesores) {
            if (auxiliar.equals(aux)) {
              apto = false;
              System.out.println("Numero de identificacion repetido, vuelva a empezar...");
            }
          }
          if(apto)arrayProfesores[i] = auxiliar;
        }
      } else {
        nFuncionario++;
        boolean apto = false;
        while (!apto) {
          ProfesorFuncionario auxiliar = setProfesorFuncionario();
          apto = true;
          for (Profesor aux : arrayProfesores) {
            if (auxiliar.equals(aux)) {
              apto = false;
              System.out.println("Numero de identificacion repetido, vuelva a empezar...");
            }
          }
          if(apto)arrayProfesores[i] = auxiliar;
        }
      }
    }

    System.out.println(Arrays.toString(arrayProfesores));
    System.out.println("Hay " + nFuncionario + " funcionarios y " + nInterino + " interinos.");
    scan.close();
  }

  public static int interinoOFuncionario() {
    Scanner scan = new Scanner(System.in);
    boolean apto = false;
    int opcion = 0;
    while (!apto) {
      System.out.println("Pulse 1 para añadir un profesor interino");
      System.out.println("Pulse 2 para añadir un profesor funcionario");
      opcion = scan.nextInt();
      if (opcion == 1 || opcion == 2) {
        apto = true;
      }
    }
    return opcion;
  }

  public static ProfesorInterino setProfesorInterino() {
    ProfesorInterino Profe;
    Scanner scan = new Scanner(System.in);

    System.out.println("introduce el nombre:");
    String nombre = scan.nextLine();
    System.out.println("introduce los apellidos:");
    String apellidos = scan.nextLine();
    System.out.println("introduce la edad:");
    int edad = scan.nextInt();
    System.out.println("introduce el identificador:");
    String id = scan.next();
    System.out.println("introduce el tiempo de servicio");
    double tiempo = scan.nextDouble();

    Profe = new ProfesorInterino(nombre, apellidos, edad, tiempo);
    Profe.setIDProfesorInterino(id);

    return Profe;
  }

  public static ProfesorFuncionario setProfesorFuncionario() {
    ProfesorFuncionario Profe;
    Scanner scan = new Scanner(System.in);

    System.out.println("introduce el nombre:");
    String nombre = scan.nextLine();
    System.out.println("introduce los apellidos:");
    String apellidos = scan.nextLine();
    System.out.println("introduce la edad:");
    int edad = scan.nextInt();
    System.out.println("introduce el identificador:");
    String id = scan.next();
    System.out.println("introduce el destino");
    String destino = scan.next();

    Profe = new ProfesorFuncionario(nombre, apellidos, edad, destino);
    Profe.setIDProfesorFuncionario(id);

    return Profe;
  }

}
