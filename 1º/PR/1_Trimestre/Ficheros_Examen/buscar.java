public class buscar {


    public Car buscaCoche(String codigo){
      Car result=null;
      for(int i=0;i<plazas.length&&result==null;i++){
              if(plazas[i]!=null && plazas[i].getCode().equals(codigo)){
                  result=plazas[i];
              }
      }
      return result;
  }

  public Car[] buscaCochesPorCliente(String dni){
    Car[] result=null;
    int n=0;
    for(int i=0;i<plazas.length;i++){
            if(plazas[i]!=null && plazas[i].getPropietario().getDni().equals(dni)){
                n++;
            }
    }
    result=new Car[n];  //Si conociéramos, por ejemplo, Arraylist no lo necesitaríamos hacer.
    n=0;
    for(int i=0;i<plazas.length;i++){
            if(plazas[i]!=null &&  plazas[i].getPropietario().getDni().equals(dni)){
                result[n]=plazas[i];
                n++;
            }
    }
    
    return result;
  }
} 

