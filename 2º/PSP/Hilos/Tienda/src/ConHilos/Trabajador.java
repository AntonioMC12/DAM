package ConHilos;

public class Trabajador extends Thread {
	private String nombre;
	private Cliente cliente;
	private long time;

	public Trabajador(String nombre,Cliente c,long t) {
		super();
		this.nombre = nombre;
		this.cliente=c;
		this.time=t;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void run() { 
		 
		  System.out.println("Trabajador " + this.nombre +  
				  " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + 
				  this.cliente.getNombre() + " EN EL TIEMPO: " + 
				  (System.currentTimeMillis() - this.time) / 1000 + "seg"); 
		 
		  for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {  
			  this.esperarXsegundos(cliente.getCarroCompra()[i]);  
			  System.out.println("Trabajador "+this.nombre+", procesado el producto " 
					  + (i + 1) + " ->Tiempo: " + (System.currentTimeMillis() - this.time) / 1000 
					  +"seg"); 
		  } 
		 
		System.out.println("El trabajador " + this.nombre + " HA TERMINADO DE PROCESAR " 
		+ this.cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - time) 
		/ 1000 + "seg"); 
		 
		 }
	
	private void esperarXsegundos(int segundos) { 
		  try { 
			  Thread.sleep(segundos * 1000); 
		  } catch (InterruptedException ex) { 
			  Thread.currentThread().interrupt(); 
		  } 
		 } 
	

}
