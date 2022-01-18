package Ejercicio2;

public class Consumidor extends Thread {
	private Cubeta cubeta;
	private String name;

	public Consumidor(String name, Cubeta cubeta) {
		this.cubeta = cubeta;
		this.name = name;
	}

	public void run() {
		this.cubeta.sacaAgua(generateNumber());
	}

	public int generateNumber() {
		double value = (Math.random() * 7) + 1;
		return (int) value;

	}

}
