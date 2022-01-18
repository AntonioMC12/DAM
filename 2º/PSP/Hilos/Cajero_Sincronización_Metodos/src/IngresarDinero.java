
public class IngresarDinero extends Thread {
	private Cuenta c;
	String nombre;
	float cantidad;
	public IngresarDinero(Cuenta c, String nombre, float cantidad) {
		this.c = c;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	public void run() {
		c.sumaSaldo(cantidad, nombre);
	}
}
