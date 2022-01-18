package SinHilo;

public class Cliente {
	private int [] carroCompra;
	private String nombre;
	
	public Cliente(String nombre,int[] carroCompra) {
		super();
		this.carroCompra = carroCompra;
		this.nombre = nombre;
	}
	public int[] getCarroCompra() {
		return carroCompra;
	}
	public void setCarroCompra(int[] carroCompra) {
		this.carroCompra = carroCompra;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
