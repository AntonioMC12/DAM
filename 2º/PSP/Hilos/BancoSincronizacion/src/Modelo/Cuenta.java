package Modelo;

public class Cuenta {
	private String nCuenta;
	private double saldo;
	public Cuenta(String nCuenta, double saldo) {
		this.nCuenta = nCuenta;
		this.saldo = saldo;
	}
	public String getnCuenta() {
		return nCuenta;
	}
	public void setnCuenta(String nCuenta) {
		this.nCuenta = nCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Cuenta [nCuenta=" + nCuenta + ", saldo=" + saldo + "]";
	}
	

}
