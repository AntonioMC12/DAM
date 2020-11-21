import Trabajo.Empleado;

public class Ejecutable{
  public static void main(String[] args) {
    Empleado E1 = new Empleado();
    System.out.println(E1);
    Empleado E2 = new Empleado("Antonio",20);
    System.out.println(E2);
    Empleado E3 = new Empleado("Antonio",20,1200);
    System.out.println(E3);
    Empleado E4 = new Empleado("Antonio","Programacion",20,1200);
    System.out.println(E4);

    System.out.println("Aunmento de salario por Double");
    double increaseDouble = 200;
    E4.increaseSalary(increaseDouble);
    System.out.println(E4);

    System.out.println("Aunmento de salario por int");
    int increaseInt = 50;
    E4.increaseSalary(increaseInt);
    System.out.println(E4);
  }
}