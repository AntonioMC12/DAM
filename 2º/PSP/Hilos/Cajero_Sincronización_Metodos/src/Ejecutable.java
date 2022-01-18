
public class Ejecutable {

	public static void main(String[] args) {
		
		Cuenta cuenta= new Cuenta(50);
		SacarDinero ana = new SacarDinero(cuenta,"Ana",30);
		SacarDinero pepe = new SacarDinero(cuenta,"Pepe",10);
		SacarDinero antonio = new SacarDinero(cuenta,"Antonio",20);
		SacarDinero andrea = new SacarDinero(cuenta,"Andrea",30);
		
		IngresarDinero ana1 = new IngresarDinero(cuenta,"Ana",30);
		IngresarDinero pepe1 = new IngresarDinero(cuenta,"Pepe",10);
		IngresarDinero antonio1 = new IngresarDinero(cuenta,"Antonio",20);
		IngresarDinero andrea1 = new IngresarDinero(cuenta,"Andrea",30);
		
		ana.start();
		pepe.start();
		antonio.start();
		andrea.start();
		ana1.start();
		pepe1.start();
		antonio1.start();
		andrea1.start();
	}

}
