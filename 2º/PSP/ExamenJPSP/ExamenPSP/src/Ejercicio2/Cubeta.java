package Ejercicio2;

/**
 * Usando el modelo productor consumidor, implementa una clase que controle los
 * litros de agua de una cubeta. Debes generar una clase Cubeta, que tiene un
 * par�metro, litros. Esta clase tiene dos m�todos, echaAgua y sacaAgua. Ambos
 * m�todos recibir�n los litros que quieren sacar o echar y el nombre del hilo
 * que los hecha. La cubeta no puede tener menos de 2 litros nunca, ni m�s de 10
 * litros. Mientras se est� sacando agua, no se puede echar, ya que podr�an
 * superarse los l�mites. El hilo consumidor echar� agua en 3 ocasiones y cada
 * productor podr� sacar agua 1 vez, usando los m�todos del objeto de tipo
 * cubeta que comparten. Se pide resolver el problema usando sincronizaci�n en
 * los m�todos (no en bloques) y comunicaci�n entre hilos usando el modelo
 * productor � consumidor. Se adjunta el c�digo del programa principal (no
 * podr�s cambiar ni una l�nea)
 * 
 * @author Antonio
 *
 */

public class Cubeta {

	private final int CAPACIDAD = 10;
	private int litros;
	private boolean disponible = true; // false no echa agua

	public Cubeta(int litros, boolean disponible) {
		this.litros = litros;
		this.disponible = disponible;
	}

	public synchronized void sacaAgua(int l) {
		while (!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (this.litros - l < 2) {
			System.out.println("La cubeta tiene " + this.litros + "L");
			System.out.println("No se pueden sacar " + l + " litros, porque la cubeta quedar�a por debajo de 0L");
		} else {
			this.litros -= l;
			System.out.println("Ha sacado "+l+"L quedan "+this.litros+"L");
		}

		this.disponible = false;
		notifyAll();
	}

	public synchronized void echaAgua(int l) {

		while (disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (this.litros + l > 10) {
			System.out.println(
					"La cubeta tiene " + this.litros + " no se pueden echar " + l + " litros porque supera el m�ximo");
		} else {
			this.litros += l;
			System.out.println("Han echado "+l+"L de agua, ahora hay "+this.litros+"L");
		}
		this.disponible = true;
		notifyAll();
	}

}
