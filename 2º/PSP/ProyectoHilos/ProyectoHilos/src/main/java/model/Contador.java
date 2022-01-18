package model;

public class Contador {
	
	public static int cont = 0;

	public static int getCont() {
		return cont;
	}

	public static void setCont(int cont) {
		Contador.cont = cont;
	}
	
	public static void addCont() {
		cont++;
	}

}