package Ejercicio4;

public class Profesor extends Persona {

  private String IDProfesor;

  public Profesor() {
    // TODO Auto-generated constructor stub
    this.IDProfesor = "Unknow";
  }

  public Profesor(String nombre, String apellidos, int edad) {
    super(nombre, apellidos, edad);
    this.IDProfesor = "Unknow";
    // TODO Auto-generated constructor stub
  }

  public String getIDProfesor() {
    return IDProfesor;
  }

  public void setIDProfesor(String iDProfesor) {
    IDProfesor = iDProfesor;
  }

  @Override
  public String toString() {
    return "\n\nDatos Profesor \n" + "Identificador: " + this.IDProfesor + "\n" + "Nombre: " + this.getNombre() + " "
        + this.getApellidos() + "\n" + "Edad: " + this.getEdad();
  }

  @Override
  public boolean equals(Object o) {
    boolean result = false;
    if (this == o) {
      result = true;
    } else if (o instanceof Profesor) {
      Profesor a = (Profesor) o;
      String n = a.getIDProfesor();
      if (this.IDProfesor.equals(n)) {
        result = true;
      }
    }
    return result;
  }

}
