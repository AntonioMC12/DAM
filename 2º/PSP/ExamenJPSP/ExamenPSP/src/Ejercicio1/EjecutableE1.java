package Ejercicio1;

public class EjecutableE1 {

	public static void main(String[] args) {
		HiloInterrumpido h1 = new HiloInterrumpido();
		
		Thread t1 = new Thread(h1);
		
		try{
			t1.start();
			Thread.sleep(8000);
			t1.interrupt();
		}catch (Exception e) {
			System.out.println("*** Se ha interrumpido el hilo acumulador ***");
			System.out.println("*** Valor acumulado es:  ***");
		}

	}

}
