package Ejercicio2;

public class Productor extends Thread {

	private Cubeta cubeta;

	public Productor(Cubeta cubeta) {
		this.cubeta = cubeta;
	}

	public void run() {

		// echa agua 3 veces.
		for (int i = 0; i < 3; i++) {
			cubeta.echaAgua(generateNumber());
		}
	}

	public int generateNumber() {
		double value = (Math.random() * 7) + 1;
		return (int) value;

	}

}