
public class Ejecutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Imprime i = new Imprime();
		HiloTicToc a = new HiloTicToc(i, "TIC ");
		HiloTicToc b = new HiloTicToc(i, "TOC ");
		
		a.start();
		b.start();

	}

}
