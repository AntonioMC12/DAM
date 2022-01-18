package ConHilos;

public class mainTienda2 {
	public static void main(String[] args) { 
		 
		  Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 }); 
		  Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 }); 
		 
		  // Tiempo inicial de referencia 
		  long initialTime = System.currentTimeMillis(); 
		  
		  Trabajador2 t1 = new Trabajador2("Juan",cliente1,initialTime); 
		  Trabajador2 t2 = new Trabajador2("Pedro",cliente2,initialTime);
		 
		  Thread h1 = new Thread(t1);
		  Thread h2 = new Thread(t2);
		 
		  h1.start(); 
		  h2.start(); 
		 }
	

}
