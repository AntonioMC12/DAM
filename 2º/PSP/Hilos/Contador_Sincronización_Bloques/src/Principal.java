
public class Principal {

	public static void main(String[] args) {
		Contador c = new Contador(50);
		HiloIncrementa h1 = new HiloIncrementa("Hilo Incrementa", c);
		HiloDecrementa h2 = new HiloDecrementa("Hilo Decrementa", c);
		
		h1.start();
		h2.start();

	}

}
