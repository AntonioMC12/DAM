package vehiculo;

public class Coche {

  String matricula;
  String marca;
  String color;
  String observaciones;
  String dniPropietario;
  String nombrePropietario;
  Motor motor;

  Coche(String matricula, String marca, String color, String observaciones, String dniPropietario, String nombrePropietario, Motor motor) {
    this.matricula = matricula;
    this.marca = marca;
    this.color = color;
    this.dniPropietario = dniPropietario;
    this.nombrePropietario = nombrePropietario;
    this.motor = motor;
  }
 
  Coche() {
    this("default", "default", "default", "default", "default", "default", new Motor());
  }

  String infoCoche(){
    return "El coche tiene matricula " + this.matricula + " , es de la marca " + this.marca + " , de color " + this.color + " , cuyo propietario es " + this.nombrePropietario + " , ademas lleva un motor " + this.motor;
  }

  String infoPropietario(){
    return "El propietario del coche es " + this.nombrePropietario + " con DNI " + this.dniPropietario;
  }

  public String toString(){
    return this.infoCoche() + " " + this.infoPropietario();
  }
}
