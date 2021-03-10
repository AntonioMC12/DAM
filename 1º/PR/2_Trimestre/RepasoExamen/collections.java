import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class collections {

	public static void main(String[] args) {
		Set<String> misfrases=new HashSet<>();
		List<String> misfrases2=new ArrayList<>();
		misfrases.add("HOLA");
		misfrases.add("MUNDO");
		misfrases.add("!");
		
		misfrases2.add("HOLA");
		misfrases2.add("MUNDO");

		
		Iterator<String> miiterador=misfrases2.iterator();
		while(miiterador.hasNext()) {
			String elementoIesimo=miiterador.next();
			//System.out.println(elementoIesimo);
			//if quiero borrar
			//miiterador.remove();
		}
		
		Iterator<String> miiterador2=misfrases.iterator();
		while(miiterador2.hasNext()) {
			String elementoIesimo=miiterador2.next();
			//System.out.println(elementoIesimo);
			//if quiero borrar
			//miiterador.remove();
		}
		
		
		//////////////////////////
		HashMap<String, String> dicES=new HashMap<>();
		HashMap<String, String> dicEN=new HashMap<>();
		
		dicES.put("hi", "HOLA");dicEN.put("hi", "HELLO");
		dicES.put("wo", "MUNDO");dicEN.put("wo", "WORLD");
		
		int language=1; //1 es   2 en
		HashMap<String , String> dic;
		if(language==1) {
			dic=dicES;
		}else {
			dic=dicEN;
		}
		
		System.out.println(dic.get("hi")+" "+dic.get("wo"));
		
		System.out.println("Presione una tecla");
		
		HashMap<book,Float> precios=new HashMap<>();
    book b1 = new book("El Imperio Final", "Brandom Sanderson", 1);
    book b2 = new book("El señor de los anillos", "JRR Tolkien", 2);
    book b3 = new book("El retorno de los dragones", "Margaret Weiss", 3);
		
		precios.put(b1, 1000f);
		precios.put(b2, 2500f);
		precios.put(b3, 5000f); 
		
		System.out.println(precios.get(b1));
		
		//sacar los valores
		Collection<Float> todoslospresios=precios.values();
		for(float p: todoslospresios) {
			System.out.println(p);
		}
		//sacar las claves
		Set<book> lasclaves=precios.keySet();
		for(book c: lasclaves) {
			System.out.println(c);
		}
		
		//sacar clave-valor
		Set<Entry<book,Float>> todo=precios.entrySet();
		for(Entry<book,Float> cadacoche : todo) {
			System.out.println(cadacoche.getKey()+"-"+
			cadacoche.getValue());
		}
		
		
	}

}
