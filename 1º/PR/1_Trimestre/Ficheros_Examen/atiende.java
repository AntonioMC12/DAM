public class atiende {
  
  public boolean atiendePaciente(Perro paciente) {
    boolean resultado = false;

    for (int i = 0; i < this.pacientes.length && !resultado; i++) {
      if (this.pacientes[i] == null) {
        // La habitación está disponible, no hay nadie
        // i = this.paciente.length; no haria falta el booleano.
        this.pacientes[i] = paciente;
        resultado = true;
      }
    }

    return resultado;
  }
}
