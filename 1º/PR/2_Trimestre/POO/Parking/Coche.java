public class Coche {
	private String matricula;
	private String bastidor;
	
	public Coche(String matricula,String bastidor) {
		this.matricula = matricula;
		this.bastidor=bastidor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getBastidor() {
		return bastidor;
	}

	public void setBastidor(String bastidor) {
		this.bastidor = bastidor;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", bastidor=" + bastidor + "]";
	}

	
	


}
