import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

public class HiloEjInterrumpir extends Thread {
	public void run() {
	  try {	
		while(!isInterrupted()) {
			System.out.println("Dentro del hilo");
			sleep(1000);
		}
	  }catch(InterruptedException e) {
		  System.out.println("ha ocurrido excepcion");
	  }
		System.out.println("fin del hilo");
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		HiloEjInterrumpir h = new HiloEjInterrumpir();
		h.start();
		String cadena="";
		while(!cadena.equals("S")) {
			System.out.println("Pulsa S para detener");
			cadena=sc.nextLine();
			//Si se introduce S, paro el hilo
			if(cadena.equals("S")) {
				h.interrupt();
			}
			
		}
		System.out.println("FIN DEL PROGRAMA");	
	}
	

}
