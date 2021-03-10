import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class repasoMarshall {

  public static void main(String[] args) {
    
    book b1 = new book("El Imperio Final", "Brandom Sanderson", 1);
    book b2 = new book("El señor de los anillos", "JRR Tolkien", 2);
    book b3 = new book("El retorno de los dragones", "Margaret Weiss", 3);

    List<book> lista = new ArrayList<>();
    lista.add(b1);
    lista.add(b2);
    lista.add(b3);

    repositorySingleton repositorio = repositorySingleton.getInstance();
    repositorio.setRepositorio(lista);
    
    
    try {
      guardar(repositorio);
    } catch (JAXBException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    //repositorySingleton repositorio = repositorySingleton.getInstance();
    carga("prueba.xml");
    System.out.println(repositorio.getRepositorio());
  }

  public static void guardar(repositorySingleton lista) throws JAXBException {
    JAXBContext jc = JAXBContext.newInstance(repositorySingleton.class);
    Marshaller m = jc.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    m.marshal(lista, new File("prueba.xml"));
  }

  public static void carga(String url) {
    JAXBContext jaxbC;
    try {
      jaxbC = JAXBContext.newInstance(repositorySingleton.class);
      Unmarshaller um = jaxbC.createUnmarshaller();
      repositorySingleton newr = (repositorySingleton) um.unmarshal(new File(url));
      List<book> repositorySingleton = newr.getRepositorio();
    } catch (JAXBException e) {
      e.printStackTrace();
    }

  }

}
