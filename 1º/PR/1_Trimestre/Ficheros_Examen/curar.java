public class curar {
  
  public Perro curaPaciente(String nombre, String observaciones) {
    Perro curado = null;
    for (int i = 0; i < pacientes.length && curado == null; i++) {
      // si en la jaula está "nombre" hago la funcion
      if (this.pacientes[i] != null && (this.pacientes[i].getNombre()).equals(nombre)) {
        curado = this.pacientes[i];
        this.pacientes[i] = null;
        curado.setObservaciones(observaciones);
        // i = pacientes.length;
      }
    }
    return curado;
  }
}
