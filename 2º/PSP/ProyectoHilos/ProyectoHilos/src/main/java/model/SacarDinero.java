package model;

public class SacarDinero extends Thread {

	private Banca bank;
	private Jugador pj;
	private int cantidad;

	public SacarDinero(Banca bank, Jugador pj, int cantidad) {
		this.bank = bank;
		this.pj = pj;
		this.cantidad = cantidad;
	}

	public SacarDinero() {
		this(new Banca(), new Jugador(), 0);
	}

	public void run() {
		bank.takeDinero(cantidad, pj.getNombre());
	}
}