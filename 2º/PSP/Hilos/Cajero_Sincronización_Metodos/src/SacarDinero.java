
public class SacarDinero extends Thread {
	private Cuenta c;
	String nombre;
	float cantidad;
	public SacarDinero(Cuenta c, String nombre, float cantidad) {
		this.c = c;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	public void run() {
		c.restaSaldo(cantidad, nombre);
	}

}
