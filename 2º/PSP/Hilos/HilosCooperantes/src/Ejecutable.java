
public class Ejecutable {
	
	private static final int NUM_HILOS = 5;
	private static final int CUENTA_TOTAL = 500;

	public static void main(String[] args) {
		Contador c = new Contador();
		Thread[] hilos = new Thread[NUM_HILOS];
		
		for (int i = 0; i < NUM_HILOS; i++) {
		      Thread th = new Thread(new Hilo(i, CUENTA_TOTAL / NUM_HILOS, c));
		      th.start();
		      hilos[i] = th;
		    }
		for(Thread h: hilos) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	
		System.out.printf("Cuenta global: %s\n", c.getCuenta());

	
	
	}

}
