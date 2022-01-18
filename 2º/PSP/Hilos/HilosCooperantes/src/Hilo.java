
public class Hilo implements Runnable {
	int numHilo;
	int miParte; //la cantidad que tiene que contar este hilo
	int miCuenta = 0;
	
	private final Contador cont;

	public int getMiCuenta() {
	    return miCuenta;
	  }

	Hilo(int numHilo, int miParte, Contador c) {
	    this.numHilo = numHilo;
	    this.miParte = miParte;
	    this.cont = c;
	  }

	  @Override
	  public void run() {
	    for (int i = 0; i < miParte; i++) {
	      this.cont.incrementa();
	      miCuenta++;
	    }
	    System.out.printf("Hilo %d terminado, cuenta: %d\n", numHilo, getMiCuenta());
	  }

}
