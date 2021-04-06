package p1;

public class Ejecutable {
	public static void main(String[] args) {
		Comprador c=new Comprador("1","Juan",0);
		Vendedor v=new Vendedor("2","María",1);
		System.out.println(c.saluda());
		System.out.println(v.saluda());
	}
}
