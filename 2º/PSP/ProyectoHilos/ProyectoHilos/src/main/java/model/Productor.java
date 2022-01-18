package model;

import java.util.Random;

import controller.SecondaryController;

public class Productor extends Thread {

	private Cola cola;
	private Random aleatorio = new Random();
	private Random max = new Random();

	public Productor(Cola cola) {
		this.cola = cola;
	}

	public void run() {
		int tope = max.nextInt(30);
		for (int i = 0; i < tope; i++) {
			SecondaryController.isFinished = (i == tope - 1) ? true : false;
			int poner = aleatorio.nextInt(36);
			cola.put(poner);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.err.println("Productor: Error en run -> " + e.getMessage());
			}
		}
	}
}
