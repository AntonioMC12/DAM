package Ejercicio2;

public class Ejecutable {
	private static final int N_CONSUMIDORES = 5;

	public static void main(String[] args) {
		Cubeta c = new Cubeta(10, true);
		Productor grifo = new Productor(c);
		Thread[] personas = new Thread[N_CONSUMIDORES];
		for (int i = 0; i < N_CONSUMIDORES; i++) { // Crea 5 hilos consumidores
			Thread consumidor = new Thread(new Consumidor("Persona" + i, c));
			personas[i] = consumidor;
		}
		grifo.start(); // lanzamos el productor
		for (Thread consumidor : personas) { // Lanza hilos consumidores
			consumidor.start();
		}
	}
}
