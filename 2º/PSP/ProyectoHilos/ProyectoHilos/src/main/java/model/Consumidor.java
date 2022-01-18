package model;

public class Consumidor extends Thread {
	private Cola cola;

	public Consumidor(Cola cola) {
		this.cola = cola;
	}

	/**
	 * Implementaci�n de la hebra
	 */
	public void run() {
		while (Boolean.TRUE) {
			cola.get();
		}
	}
}
