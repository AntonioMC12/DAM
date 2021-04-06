package p1;

public class Comprador extends Persona{
  public Comprador(String id, String name, int languaje) {
    super(id,name,languaje);
  }
  public Comprador() {
    super("0","sampleBuyer",1);
  }
  
  @Override
  public String saluda() {   
    return Traductor.traduce(getLanguaje(), "compra");
  }


}
