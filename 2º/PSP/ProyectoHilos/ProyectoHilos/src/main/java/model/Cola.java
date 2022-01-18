package model;

import java.util.Observable;
import java.util.Observer;

public class Cola extends Observable {

	private int numero;
	private boolean disponible = false; // no hay numeros disponibles
	private Observer observer;

	public synchronized int get() {
		while (!this.disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Contenedor: Error en get -> " + e.getMessage());
			}
		}
		this.disponible = Boolean.FALSE;
		notifyAll();
		setChanged();
		notifyObservers();
		return this.numero;
	}

	public synchronized void put(int n) {
		while (this.disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Contenedor: Error en put -> " + e.getMessage());
			}
		}
		this.numero = n;
		this.disponible = Boolean.TRUE;
		notifyAll();
	}

	@Override
	public synchronized void addObserver(Observer o) {
		this.observer = o;
	}

	@Override
	public void notifyObservers() {
		if (observer != null) {
			observer.update(this, numero);
		}
	}

}
