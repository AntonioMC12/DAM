package p1;

import java.util.UUID;


public abstract class Persona {
  
	protected String id;
	protected String name;
	private int languaje;
	
  public Persona(String id, String name, int languaje) {
    super();
    this.id = id;
    this.name = name;
    this.languaje = languaje;
  }
  
  public Persona() {
    this("0","sample",1);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLanguaje() {
    return languaje;
  }

  public void setLanguaje(int languaje) {
    this.languaje = languaje;
  }

  @Override
  public String toString() {
    return "Persona [id=" + id + ", name=" + name + ", languaje=" + languaje + "]";
  }
  
  
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Persona other = (Persona) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  public abstract String saluda();
	
	
}
