package hilos;

public class Ej1Hilos implements Runnable {
	private int x;
	String nombre;
	
	
	public Ej1Hilos(int x,String nombre) {
		this.nombre=nombre;
		this.x=x;
		
	}
	
	public void run() {
		for(int i=0; i<x ;i++) {
			System.out.println("Estoy en el Hilo "+nombre+" ..."+i);
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
