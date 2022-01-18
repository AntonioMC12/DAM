
public class Cola {
	private int numero;
	private boolean disponible=false; //no hay numeros disponibles
	
	public synchronized int get() {
		while(!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
			
			disponible=false;
			
			notifyAll();
		
		return numero;
			
	}
	public synchronized void put(int n) {
		
		while(disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		numero = n;
		disponible = true; //hay un numero en la cola
		notifyAll();
	}
	

}
