
public class Serie implements Entregable, Comparable<Object> {
	
	private String titulo;
	private int nTemporadas;
	private boolean entregado;
	private String genero;
	private String creador;
	
	public Serie(String titulo, int nTemporadas, String genero, String creador) {
		this.titulo = titulo;
		this.nTemporadas = nTemporadas;
		this.genero = genero;
		this.creador = creador;
		this.entregado=false;
	}
	public Serie(String titulo, String creador) {
		this(titulo,3,"",creador);
	}
	public Serie() {
		this("", "");
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getnTemporadas() {
		return nTemporadas;
	}
	public void setnTemporadas(int nTemporadas) {
		this.nTemporadas = nTemporadas;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCreador() {
		return creador;
	}
	public void setCreador(String creador) {
		this.creador = creador;
	}
	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", nTemporadas=" + nTemporadas + ", entregado=" + entregado + ", genero="
				+ genero + ", creador=" + creador + "]";
	}
	@Override
	public void entregar() {
		// TODO Auto-generated method stub
		this.entregado=false;
	}
	@Override
	public void devolver() {
		// TODO Auto-generated method stub
		this.entregado=true;
	}
	@Override
	public boolean isEntregado() {
		return this.entregado;
	}
	@Override
	public int compareTo(Object a) {
	  int resultado=0;
    if(a!=null && a instanceof Serie) {
      Serie otro=(Serie)a;
      resultado= this.nTemporadas-otro.nTemporadas;
    }
    return resultado;
  }  
}
