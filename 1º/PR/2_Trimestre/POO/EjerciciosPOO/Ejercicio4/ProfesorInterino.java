package Ejercicio4;

public class ProfesorInterino extends Profesor {

  private double tiempoServicio;

  public ProfesorInterino() {
    // TODO Auto-generated constructor stub
    this.tiempoServicio = 0;
  }

  public ProfesorInterino(String nombre, String apellidos, int edad, double tiempoServicio) {
    super(nombre, apellidos, edad);
    // TODO Auto-generated constructor stub
    this.tiempoServicio = tiempoServicio;
  }

  public double getTiempoServicio() {
    return tiempoServicio;
  }

  public void setTiempoServicio(double tiempoServicio) {
    this.tiempoServicio = tiempoServicio;
  }

  public void setIDProfesor(String IDProfesor) {
    super.setIDProfesor(IDProfesor+"-I");
  }

  @Override
  public String toString() {
    return "\n\nDatos Profesor \n" + "Identificador: " + this.getIDProfesor() + "\n" + "Nombre: " + this.getNombre() + " "
        + this.getApellidos() + "\n" + "Edad: " + this.getEdad() + "\n" + "Datos Interinidad. Tiempo de Servicio: "
        + this.tiempoServicio;
  }

}
