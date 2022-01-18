package model;

public class IngresarDinero extends Thread{
	
	private Banca bank;
	private Jugador pj;
	private int cantidad;
	
	public IngresarDinero(Banca bank, Jugador pj, int cantidad) {
		this.bank = bank;
		this.pj = pj;
		this.cantidad = cantidad;
	}
	
	public IngresarDinero() {
		this(new Banca(), new Jugador(), 0);
	}
	
	public void run() {
		bank.addDinero(cantidad, pj.getNombre());
	}
}
