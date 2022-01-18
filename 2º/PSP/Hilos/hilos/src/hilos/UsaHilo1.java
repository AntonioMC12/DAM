package hilos;

public class UsaHilo1 {

	public static void main(String[] args) {
		
		Ej1Hilos hilo1 = new Ej1Hilos (10,"hilo1");
		Ej1Hilos hilo2 = new Ej1Hilos (10,"hilo2");
		Ej1Hilos hilo3 = new Ej1Hilos (10,"hilo3");
		Thread t1=new Thread(hilo1);
		Thread t2=new Thread(hilo2);
		Thread t3=new Thread(hilo3);
		t1.start();
		t2.start();
		t3.start();
		
		
		System.out.println("Estoy en el programa principal");
		
		

	}

}
