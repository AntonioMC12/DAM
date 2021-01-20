package Ejercicio1;

public class Cuenta {

  private String titular;
  private double cantidad;

  public Cuenta(String titular, double cantidad) {
    super();
    this.titular = titular;
    if (cantidad >= 0) {
      this.cantidad = cantidad;
    } else
      this.cantidad = 0;

  }

  public Cuenta(String titular) {
    super();
    this.titular = titular;
    this.cantidad = 0;
  }

  public String getTitular() {
    return titular;
  }

  public void setTitular(String titular) {
    this.titular = titular;
  }

  public double getCantidad() {
    return cantidad;
  }

  public void setCantidad(double cantidad) {
    if (cantidad > 0) {
      this.cantidad = cantidad;
    } else
      this.cantidad = 0;
  }

  @Override
  public String toString() {
    return "titular=" + titular + "\nCantidad=" + cantidad + " Euros";
  }

  public boolean ingresar(double cantidad) {
    boolean operacionValida = false;
    if (cantidad >= 0) {
      this.setCantidad(this.cantidad + cantidad);
      operacionValida = true;
    }
    return operacionValida;
  }

  public boolean retirar(double cantidad) {
    boolean operacionValida = false;

    this.setCantidad(this.cantidad - cantidad);

    return operacionValida;
  }

}
