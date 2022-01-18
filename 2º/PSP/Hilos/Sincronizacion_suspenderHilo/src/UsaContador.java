import java.util.Scanner;

public class UsaContador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		Contador c1 = new Contador(0,"C1");
		Thread t = new Thread(c1);
		
		t.start();
		
		String cadena="";
		while(!cadena.equals("*")) {
			System.out.println("Pulsa S para suspender / R para reanudar la cuenta");
			cadena=sc.nextLine();
			//Si se introduce S, paro el hilo
			if(cadena.equals("S")) {
				c1.getSuspendido().setSuspendido(true);
			}
			
			if(cadena.equals("R")) {
				c1.getSuspendido().setSuspendido(false);
			}
			
			if(cadena.equals("*")) {
				t.interrupt();
			}
		}
		System.out.println("FIN DEL PROGRAMA");
	
	
	}

}
