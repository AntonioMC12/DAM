
public class Ejecutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cola cola = new Cola();
		Productor p = new Productor(cola); //produce 5 numeros (los valores de i)
		Consumidor c = new Consumidor (cola); //Consume 5 numeros de la cola
		p.start();
		c.start();

	}

}
