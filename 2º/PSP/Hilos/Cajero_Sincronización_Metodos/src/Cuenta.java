
public class Cuenta {
	private float saldo;

	public Cuenta(float saldo) {
		this.saldo = saldo;
	}
	public  float getSaldo() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saldo;
	}
	
	synchronized public void sumaSaldo(float cantidad,String nombre) {
		System.out.println("***********");
		System.out.println("SALDO INICIAL ->"+ this.saldo);
		this.saldo+=cantidad;
		System.out.println(nombre+ " ha ingresado "+cantidad+" Euros");
		System.out.println("SALDO ACTUAL -> "+this.saldo);
		System.out.println("***********");
	}
	
	synchronized public void restaSaldo(float cantidad, String nombre) {
		System.out.println();
		System.out.println("SALDO INICIAL -> "+this.saldo);
		System.out.println(nombre+" quiere retirar "+cantidad+" Euros");
		if (this.saldo<=0) {
			System.out.println("SALDO A CERO, no ha podido realizarse la operación");
		}else {
			if(this.saldo<cantidad) {
				System.out.println("SALDO INSUFICIENTE, no ha podido realizarse la operación");
			}else {
				this.saldo-=cantidad;
				System.out.println(nombre+ " ha retirado "+cantidad+" Euros");
			}
		}
	
	}

}
