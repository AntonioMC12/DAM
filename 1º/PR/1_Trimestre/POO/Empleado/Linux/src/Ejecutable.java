import com.Trabajo.Empleado;
import com.Utils.Imprimir;
import com.Utils.Menus;
/**
 * Esta es la clase Main del programa Empleado creado para la asignatura
 * Programación del IES Francisco de los Ríos.
 * 
 * @author Antonio Muñoz Cubero
 */
public class Ejecutable {
  /**
   * Clase Main del programa, solo inicia un método para que el programa
   * se inicie.
   * 
   * @param args String de argumentos por terminal
   */
  public static void main(String[] args) {
    

    Empleado E1 = new Empleado("Antonio", "Programación", 21, 900);
    Imprimir.P(""+E1);

    Menus.startProgram(E1);
  }
}