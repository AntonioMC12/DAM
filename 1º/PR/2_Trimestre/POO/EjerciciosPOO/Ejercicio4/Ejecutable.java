package Ejercicio4;

import java.util.Arrays;
import java.util.Scanner;

public class Ejecutable {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scan = new Scanner(System.in);

    Profesor[] arrayProfesores;
    System.out.print("Introduce el número de profesores: ");
    int tamArray = scan.nextInt();
    arrayProfesores = new Profesor[tamArray];

    // creacion de los profes
    for (int i = 0; i < arrayProfesores.length; i++) {
      if (interinoOFuncionario() == 1) {
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
          if (apto)
            arrayProfesores[i] = auxiliar;
        }
      } else {
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
          if (apto)
            arrayProfesores[i] = auxiliar;
        }
      }
    }

    int nFuncionario = cuentaFuncionarios(arrayProfesores);
    int nInterino = cuentaInterinos(arrayProfesores);
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
    Profe.setIDProfesor(id);

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
    Profe.setIDProfesor(id);

    return Profe;
  }

  public static int cuentaInterinos(Profesor[] arrayProfesores) {
    int numberOfInterinos = 0;
    for (Profesor auxiliar : arrayProfesores) {
      if (auxiliar instanceof ProfesorInterino) {
        numberOfInterinos++;
      }
    }
    return numberOfInterinos;
  }

  public static int cuentaFuncionarios(Profesor[] arrayProfesores) {
    int numberOfFuncionarios = 0;
    for (Profesor auxiliar : arrayProfesores) {
      if (auxiliar instanceof ProfesorFuncionario) {
        numberOfFuncionarios++;
      }
    }
    return numberOfFuncionarios;
  }
}
