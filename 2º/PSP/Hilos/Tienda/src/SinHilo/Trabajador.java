package SinHilo;

public class Trabajador {
	private String nombre;

	public Trabajador(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void procesarCompra(Cliente cliente, long time) { 
		 
		  System.out.println("Trabajador " + this.nombre +  
				  " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + 
				  cliente.getNombre() + " EN EL TIEMPO: " + 
				  (System.currentTimeMillis() - time) / 1000 + "seg"); 
		 
		  for (int i = 0; i < cliente.getCarroCompra().length; i++) {  
			  this.esperarXsegundos(cliente.getCarroCompra()[i]);  
			  System.out.println("Trabajador "+this.nombre+", procesado el producto " 
					  + (i + 1) + " ->Tiempo: " + (System.currentTimeMillis() - time) / 1000 
					  +"seg"); 
		  } 
		 
		System.out.println("El trabajador " + this.nombre + " HA TERMINADO DE PROCESAR " 
		+ cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - time) 
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
