package ConHilos;

public class mainTienda {
	public static void main(String[] args) { 
		 
		  Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 }); 
		  Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 }); 
		 
		  // Tiempo inicial de referencia 
		  long initialTime = System.currentTimeMillis(); 
		  
		  Trabajador t1 = new Trabajador("Juan",cliente1,initialTime); 
		  Trabajador t2 = new Trabajador("Pedro",cliente2,initialTime);
		 
	
		 
		  t1.start(); 
		  t2.start(); 
		 }
	

}
