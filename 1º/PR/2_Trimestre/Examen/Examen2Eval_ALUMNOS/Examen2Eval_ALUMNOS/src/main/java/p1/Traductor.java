package p1;

import java.util.HashMap;

public class Traductor {
	private static HashMap<String, String> dicEN=new HashMap<String, String>();
	private static HashMap<String, String> dicES=new HashMap<String, String>();
	static {
		//cargo estáticamente los datos
		dicEN.put("compra","I'd like to buy");
		dicEN.put("vende","I'd like to sell");	
		dicES.put("compra","Quiero comprar");
		dicES.put("vende","Quiero vender");
	}
	/**
	 * 
	 * @param idioma 0 inglés, 1 español
	 * @param frase  a traducir
	 */
	public static String traduce(int idioma, String frase) {
		HashMap<String, String> d;
		if(idioma==0) {
			d=dicEN;
		}else {
			d=dicES;
		}
		return d.get(frase);
	}
}
