import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "repository")
@XmlAccessorType(XmlAccessType.FIELD)
public class repositorySingleton implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static repositorySingleton _pointer;
  @XmlElement(name = "book")
  private List<book> repositorio;

  private repositorySingleton() {
    this.repositorio = new ArrayList<>();
  }

  public static repositorySingleton getInstance() {
    if (_pointer == null) {
      _pointer = new repositorySingleton();
    }
    return _pointer;
  }

  public List<book> getRepositorio() {
    return repositorio;
  }

  public void setRepositorio(List<book> repositorio) {
    this.repositorio = repositorio;
  }

  public void addBook(book b) {
    this.repositorio.add(b);
  }

  @Override
  public String toString() {
    return "repositorySingleton [repositorio=" + repositorio + "]";
  }

}
