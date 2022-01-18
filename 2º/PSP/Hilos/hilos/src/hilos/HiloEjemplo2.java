package hilos;

public class HiloEjemplo2 extends Thread {
    public void run () {
    	System.out.println(
    			"\nNombre del Hilo: "+Thread.currentThread().getName()+
    			"\nPrioridad: "+Thread.currentThread().getPriority()+
    			"\nID: "+Thread.currentThread().getId()+
    			"\nHilos activos: "+Thread.currentThread().activeCount()    			
    			);
    }
	
	
	public static void main(String[] args) {
		Thread.currentThread().setName("Principal");
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().toString());
		
		HiloEjemplo2 h=null;
		for (int i=1;i<=3;i++) {
			h=new HiloEjemplo2();
			h.setName("hilo"+i);
			h.setPriority(i+1);
			h.start();
			System.out.println("Informacion del hilo "+h.getName()
			+":"+h.toString());
		}
	System.out.println("Hilos activos "+Thread.activeCount());		
		

	}

}
