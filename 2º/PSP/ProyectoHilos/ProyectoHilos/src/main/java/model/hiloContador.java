package model;

public class hiloContador extends Thread{
	
	public Jugador player;
		
	public hiloContador(Jugador player) {
		this.player = player;
	}

	public void run() {
		for(int i = 0; i < this.player.getDinero(); i++) {
			Contador.addCont();
		}
	}
}
