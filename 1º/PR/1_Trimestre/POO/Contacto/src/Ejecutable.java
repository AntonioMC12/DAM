import Agenda.Contacto;
import Agenda.Medios.Email;

public class Ejecutable {
  public static void main(String[] args) {
    Contacto c1 = new Contacto();
    System.out.println(c1);

    Email e1 = new Email("a@gmail.com","google");

    Contacto c2 = new Contacto("Antonio",e1,21);
    //Contacto c2 = new Contacto("Antonio",new Email("a@gmail.com","google"),21);
    System.out.println(c2);

    Contacto c3 = new Contacto("carlos", e1, 40);
    System.out.println(c3);
  }
}
