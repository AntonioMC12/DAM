package Ejercicio3;

public class Empleado {
  
  private String nombre;
  
  public Empleado(String nombre) {
    this.nombre = nombre;
  }
  
  public Empleado() {
    this("Nombre Desconocido");
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "Empleado " + nombre +" ";
  }
  
  
}
