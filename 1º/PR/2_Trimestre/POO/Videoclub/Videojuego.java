

public class Videojuego implements Entregable, Comparable<Object>{
   private String titulo;
   private int horasEstimadas;
   private String genero;
   private String compania;
   private boolean entregado;

   public Videojuego(String titulo, int horasEstimadas, 
		   String genero, String compania) {
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.genero = genero;
		this.compania = compania;
		this.entregado=false;
	}
   public Videojuego(String titulo,int horasEstimadas) {
	   this(titulo,horasEstimadas,"","");
   }
   public Videojuego() {
	   this("", 10);
   }
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getHorasEstimadas() {
		return horasEstimadas;
	}
	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", horasEstimadas=" + horasEstimadas + ", genero=" + genero
				+ ", compania=" + compania + ", entregado=" + entregado + "]";
	}
	@Override
	public void entregar() {
		this.entregado=false;
		
	}
	@Override
	public void devolver() {
		this.entregado=true;
		
	}
	@Override
	public boolean isEntregado() {
		return this.entregado;
	}
	@Override
	public int compareTo(Object a) {
		// TODO Auto-generated method stub
		int resultado=0;
		if(a!=null && a instanceof Videojuego) {
			Videojuego otro=(Videojuego)a;
			resultado= this.horasEstimadas-otro.horasEstimadas;
		}
		return resultado;
	}
}
