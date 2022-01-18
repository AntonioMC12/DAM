package model;

public class Banca {

	private int dinero;

	public Banca() {
		this.dinero = 500;
	}

	public Banca(int dinero) {
		this.dinero = dinero;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public void addDinero(int dinero, String nombre) {
		this.dinero += dinero;
	}

	public int takeDinero(int dinero, String nombre) {
		int takeDinero = 0;
		if (this.dinero <= 0) {
		} else if (this.dinero - dinero < 0) {
			takeDinero = this.dinero;
			this.dinero = 0;
		} else {
			takeDinero = dinero;
			this.dinero = this.dinero - dinero;
		}
		return takeDinero;
	}
}
