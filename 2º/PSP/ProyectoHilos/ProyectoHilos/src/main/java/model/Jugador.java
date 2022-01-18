package model;

import java.util.Objects;
import java.util.Random;

public class Jugador{
	
	private int dinero;
	private String nombre;
	private int apuesta;
	private Random aleatorio = new Random();
	
	public Jugador(int dinero, String nombre) {
		this.dinero = dinero;
		this.nombre = nombre;
	}
	
	public Jugador() {
		this(50,"Default");
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getApuesta() {
		return apuesta;
	}

	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}

	public void makeApuesta() {
		this.apuesta = aleatorio.nextInt(35)+1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
}
