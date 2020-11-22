import Trabajo.Empleado;
import Utils.Imprimir;
import Utils.Menus;

public class Ejecutable {
  public static void main(String[] args) {
    

    Empleado E1 = new Empleado("Antonio", "Programación", 21, 900);
    Imprimir.P(""+E1);

    Menus.startProgram(E1);
  }
}