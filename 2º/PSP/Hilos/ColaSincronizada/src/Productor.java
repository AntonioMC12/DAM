
public class Productor extends Thread{
		private Cola cola;

		public Productor (Cola cola) {
			this.cola = cola;
		}
		
		public void run() {
		
			for(int i=0;i<5;i++) {
				cola.put(i);//recoge un numero
				System.out.println("Produce: "+ i);
				
				try{
					Thread.sleep(100);
				}catch(InterruptedException e) {}
				
			}
		}
		
	


}
