package Ejercicio3;

public class Operario extends Empleado {

  public Operario(String nombre) {
    super(nombre);
    // TODO Auto-generated constructor stub
  }

  public Operario() {
    // TODO Auto-generated constructor stub
    super();
  }

  @Override
  public String toString() {
    return super.toString()+" -> Operario ";
  }
  
  

}
