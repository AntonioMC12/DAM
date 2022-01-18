package Ejercicio1;

/**
 * Desarrolla una clase de nombre HiloInterrumpido, que sume cada segundo un
 * n�mero aleatorio (entre 1 y 10) a un acumulador, de forma infinita, hasta que
 * sea interrumpido por el hilo principal. Cuando sea interrumpido mostrar� un
 * mensaje con el texto: �Se ha interrumpido el Hilo NombreHilo, el valor del
 * acumulador es X� . Debes hacer esta clase implementando Runnable, en el
 * constructor recibir� el nombre del hilo (String) y el valor inicial del
 * acumulador. Para probarlo debes crear un hilo en el main, lanzarlo y 8
 * segundos despu�s interrumpirlo.
 * 
 * @author Antonio
 *
 */
public class HiloInterrumpido implements Runnable {

	private int acumulador = 0;
	public boolean valid = true;

	@Override
	public void run() {
		try {
			while(valid) {
				this.acumulador += generateNumber();
				Thread.sleep(1000);
			}
			
		} catch (Exception e) {
			System.out.println("*** Se ha interrumpido el hilo acumulador ***");
			System.out.println("*** Valor acumulado es: "+this.acumulador+" ***");
		}
	}

	public int generateNumber() {
		double value =  (Math.random()*10);
		System.out.println((int)value);
		return (int) value;
		
	}

}
