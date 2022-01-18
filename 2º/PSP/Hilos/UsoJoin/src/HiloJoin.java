
public class HiloJoin extends Thread {
	private int n;

	public HiloJoin(int n, String name) {
		super(name);
		this.n = n;
	}
	
	public void run() {
		for(int i=1; i<=n;i++) {
			System.out.println(this.getName()+": "+i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
