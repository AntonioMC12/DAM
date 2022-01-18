
public class Contador implements Runnable {
	
	private int contador;
	private String nombre;
	private SolicitaSuspender suspendido=new SolicitaSuspender();
	
	public SolicitaSuspender getSuspendido() {
		return suspendido;
	}

	public void setSuspendido(SolicitaSuspender suspendido) {
		this.suspendido = suspendido;
	}

	public Contador(int contador, String nombre) {
		this.contador = contador;
		this.nombre = nombre;
		this.suspendido.setSuspendido(false);
	}
	
	public void run() {
		
		while(!this.suspendido.getSuspendido()) {
			System.out.println(contador);
			contador++;
			
			try {
				Thread.sleep(1000);
				this.suspendido.waitReanudar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.exit(0);
			}
			
		}
	}
	
	

}
