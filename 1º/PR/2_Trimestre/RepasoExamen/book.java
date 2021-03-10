import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)

public class book implements Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String name;
  private String author;
  private int id;
  
  public book(String name, String author, int id) {
    super();
    this.name = name;
    this.author = author;
    this.id = id;
  }

  public book() {
    super();
    this.author = "anonimo";
    this.id = -1;
    this.name = "sample";
  }



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "book [name=" + name + ", author=" + author + ", id=" + id + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    book other = (book) obj;
    if (id != other.id)
      return false;
    return true;
  }
  
  /*
   * public boolean equals(Object obj) {
        boolean result=false;
        
        if(obj instanceof Persona) {
            Persona p=(Persona)obj;
            if(this.dni.equals(p.getDni())
                    &&
                    this.nombre.equals(p.getNombre())) {
                result=true;
            }
        }

        return result;
    }
   */
  
  
  
}
