
public class SolicitaSuspender {
	private boolean suspendido; //false -> hilo está corriendo  // true -> hilo parado
	
	public boolean getSuspendido() {
		return suspendido;
	}
	
	
	public synchronized void setSuspendido(boolean b) {
		this.suspendido=b;
		
		notifyAll();
	}
	
	public synchronized void waitReanudar() throws InterruptedException {
		while(this.suspendido) {
			wait();
		}
	}
	
}
