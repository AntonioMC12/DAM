
public class UsaHiloJoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HiloJoin h1= new HiloJoin(2,"Hilo1");
		HiloJoin h2= new HiloJoin(5,"Hilo2");
		HiloJoin h3= new HiloJoin(8,"Hilo3");
		h2.start();
		h1.start();
		h3.start();
		try {
			h2.join();
			h3.join();
			h1.join();
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		for (int i = 0; i < 8; i++) {
			System.out.println("el hilo principal ha terminado");
		}
		

	}

}
