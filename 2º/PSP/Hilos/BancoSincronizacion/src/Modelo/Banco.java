package Modelo;

public class Banco {
	private final Cuenta [] cuentas=new Cuenta[100];
	
	public Cuenta[] getCuentas() {
		return cuentas;
	}

	public Banco() {
		for (int i = 0; i < cuentas.length; i++) {
			cuentas[i]=new Cuenta("2828 - "+i,2000);
		}
	}
	
	public void doTransfer(int o, int d, double cant) {
		if (cuentas[o].getSaldo()<cant) {
			System.out.println("No hay saldo suficiente en la cuenta de origen");
		}else {
			System.out.println(Thread.currentThread());
			cuentas[o].setSaldo(cuentas[o].getSaldo()-cant);
			System.out.println("Realizando transferencia de la cuenta "+cuentas[o].getnCuenta()+
					" a la cuenta "+cuentas[o].getnCuenta());
			cuentas[d].setSaldo(cuentas[d].getSaldo()+cant);
			System.out.println("Saldo total: "+getSaldoTotal());
			
		}
	}
	public double getSaldoTotal() {
		double sumaSaldo=0;
		for (Cuenta e:this.cuentas) {
			sumaSaldo+=e.getSaldo();
		}
		return sumaSaldo;
	}
	
	public Cuenta getCuenta(String nCuenta) {
		Cuenta c=null;
		for(Cuenta a:cuentas) {
			if(a.getnCuenta().equals(nCuenta)) {
				return a;
			}
		}
		return c;
	}

}
