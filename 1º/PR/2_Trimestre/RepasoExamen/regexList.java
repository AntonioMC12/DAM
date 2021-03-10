import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class regexList {

  public static void main(String[] args) {

    List<String> lista = new ArrayList<>();

    lista.add("Pera");
    lista.add("Magdalena");
    lista.add("Pepsi");

    Iterator<String> i = lista.iterator();
    while (i.hasNext()) {
      String string = (String) i.next();
      if (string.matches(".*era.*")) {
        System.out.println(string);
      }
    }
    
    List<String> frutas=new ArrayList<>();
    frutas.add("Melón");
    frutas.add("Fresa");
    frutas.add("Manzana");
    frutas.add("F");
    
    Iterator<String> it=frutas.iterator();
    while(it.hasNext()) {
        String f=it.next();
        if(f.matches("^F.*")) {
            it.remove();
        }
    }
    System.out.println(frutas);
    
    
  }
}
