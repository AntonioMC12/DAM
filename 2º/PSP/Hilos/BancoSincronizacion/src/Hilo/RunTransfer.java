package Hilo;

import Modelo.Banco;
import Modelo.Cuenta;

public class RunTransfer implements Runnable {
	private Banco b;
	private Cuenta cOrigen; //cuenta de la que parte el dinero en la transferencia
	private double max; //cantidad maxima a transferir
	public RunTransfer(Banco b, Cuenta cOrigen, double max) {
		super();
		this.b = b;
		this.cOrigen = cOrigen;
		this.max = max;
	}
	
	public void run() {
		while(true) {
			//generamos el destino de forma aleatoria
			int nC = (int)(100*Math.random());
			String nCuenta="2828 - "+nC;
			Cuenta cDestino = b.getCuenta(nCuenta);
			
		}
	}
	
	
}
