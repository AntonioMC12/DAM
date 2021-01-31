package Ejercicio2;

public class Empleado implements Comparable<Empleado> {
  
  private String nombre;
  private double sueldo;
  private double ahorros;
  
  
  
  public Empleado(String nombre, double sueldo) {
    super();
    this.nombre = nombre;
    this.sueldo = sueldo;
    this.ahorros = 0;
  }
  
  public double getAhorros() {
    return ahorros;
  }

  public void setAhorros(double ahorros) {
    this.ahorros = ahorros;
  }

  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public double getSueldo() {
    return sueldo;
  }
  public void setSueldo(double sueldo) {
    this.sueldo = sueldo;
  }

  @Override
  public String toString() {
    return "Empleado [nombre=" + nombre + ", sueldo=" + sueldo + ", ahorros=" + ahorros + "]";
  }
  
  public int compareTo(Empleado auxiliar) {
    
    int resultado=0;
    if(auxiliar!=null && auxiliar instanceof Empleado) {
      Empleado otro=(Empleado)auxiliar;
      resultado= (int) (this.ahorros-otro.ahorros);
    }
    return resultado;
  }
  
  
  
}
