package p1;

public class Vendedor extends Persona{
  
  public Vendedor(String id, String name, int languaje) {
    super(id,name,languaje);
  }
  
  public Vendedor() {
    super("0","sampleSeller",1);
  }
  @Override
  public String saluda() {   
    return Traductor.traduce(getLanguaje(), "vende");
  }
}
