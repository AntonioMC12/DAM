
public class HiloDecrementa extends Thread{
	private Contador cont;
	public HiloDecrementa(String name,Contador c) {
		this.setName(name);
		this.cont=c;
	}
	public void run() {
		synchronized (cont) {
			for(int i=0;i<500;i++) {
				cont.decrementa();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		System.out.println(getName()+" contado con valor "+cont.getC());
	}


}
