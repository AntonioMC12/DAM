package vehiculo;

public class Motor {

  public int combustible;
  public int cilindrada;
  public int potencia;
  public int kilometros;

  
  public Motor(int combustible, int cilindrada, int potencia, int kilometros){
    this.combustible = combustible;
    this.cilindrada = cilindrada;
    this.potencia = potencia;
    this.kilometros = kilometros;
  }

  public Motor(){
    // this(-1,-1,-1,-1);
    // this busca un constructor que reciba los parametros introducidos.
    this.combustible = -1;
    this.cilindrada = -1;
    this.potencia = -1;
    this.kilometros = -1;
  }

  public String toString(){ 
    return "Combustible: " + this.tipoCombustible(combustible) + " CC: " + this.cilindrada + " CV: " + this.potencia + " Kms: " + this.kilometros;
  }

  /**
   * Segun el parametro que le pasemos, devuelve el equivalente a su tipo en un String
   * @param t
   * @return el tipo de combustible
   */
  public String tipoCombustible(int t){
    String tipo = "default";
    switch (t) {
      case 0:
        tipo = "default";
        break;
      case 1:
      tipo = "gasolina";
        break;
      case 2:
      tipo = "gasoil";
        break;
      case 3:
      tipo = "electrico";
        break;
      case 4:
      tipo = "hibrido";
        break;
    
      default:
      tipo = "desconocido";
        break;
    }
    return tipo;
  }

  
}
