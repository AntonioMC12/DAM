public class Ejecutable {

	public static void main(String[] args) {
		Parking p=new Parking();
		System.out.println(p);
		p.addCoche(new Coche("2324FGH","123"));
		p.addCoche(new Coche("9999HHH","456"));
		p.addCoche(new Coche("2324FGH","987"));
		System.out.println(p);
		p.removeCoche("2324FGH");
		p.removeCoche("7878GHG");
		System.out.println(p);
		p.removeCoche("456");
		System.out.println(p);
	}

}
