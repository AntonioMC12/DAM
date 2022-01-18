
public class Consumidor extends Thread{
	private Cola cola;

	public Consumidor(Cola cola) {
		this.cola = cola;
	}
	
	public void run() {
		int valor=0;
		for(int i=0;i<5;i++) {
			valor=cola.get();//recoge un numero
			System.out.println("Consume: "+valor);
		}
	}
	
}
