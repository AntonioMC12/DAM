package Agenda.Medios;

  public class Email {
    
    private String address;
    private String provider;

    public Email(String address, String provider){
      this.address = address;
      this.provider = provider;
    }

    public Email(){
      this("unknown","unknown");
    }

    public void setAddress(String address){
      this.address = address;
    }

    public String getAddress(){
      return this.address;
    }

    public void setProvider(String provider){
      this.provider = provider;
    }

    public String getProvider(){
      return this.provider;
    }

    public String toString(){
      return this.address + " -> " + this.provider;
    }
  }
