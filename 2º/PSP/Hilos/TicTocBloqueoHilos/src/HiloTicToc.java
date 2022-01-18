
public class HiloTicToc extends Thread {
	private Imprime imp;
	String cad;
	
	public HiloTicToc(Imprime imp, String cad) {
		this.imp = imp;
		this.cad = cad;
	}
	
	public void run() {
		synchronized (imp) {
			for(int i=0;i<20;i++) {
				imp.PrintCadena(cad);
				imp.notify();
				try {
					imp.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	

}
