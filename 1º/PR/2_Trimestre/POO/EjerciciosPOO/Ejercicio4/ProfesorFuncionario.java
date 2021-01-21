package Ejercicio4;

public class ProfesorFuncionario extends Profesor {

  private String destino;

  public ProfesorFuncionario() {
    // TODO Auto-generated constructor stub
    this.destino = "Unknow";
  }

  public ProfesorFuncionario(String nombre, String apellidos, int edad, String destino) {
    super(nombre, apellidos, edad);
    // TODO Auto-generated constructor stub
    this.destino = destino;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public void setIDProfesorFuncionario(String IDProfesor) {
    this.setIDProfesor(IDProfesor + "-F");
  }

  @Override
  public String toString() {
    return "\n\nDatos Profesor \n" + "Identificador: " + this.getIDProfesor() + "\n" + "Nombre: " + this.getNombre() + " "
        + this.getApellidos() + "\n" + "Edad: " + this.getEdad() + "\n" + "Destino Funcionariado. Destino: "
        + this.destino;
  }

}
