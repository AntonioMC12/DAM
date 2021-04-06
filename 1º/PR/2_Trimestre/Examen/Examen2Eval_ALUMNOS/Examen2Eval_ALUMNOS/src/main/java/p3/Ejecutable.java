package p3;

public class Ejecutable {
	public static void main(String[] args) {
		
		//patrón singleton, Apartado 1
		ELista obj1= ELista.getEListaInstance();
		
		// se añaden 4 elementos a la lista, Apartado 2
		obj1.addLista(5);
		obj1.addLista(3);
		obj1.addLista(8);
		obj1.addLista(2);
		
				
		//llama al método recursivo que suma los elementos, Apartado 3
		System.out.println("\nSUMA DE LOS ELEMENTOS DE LA LISTA:"+ ELista.sumaLista(0));
	

	}
}
