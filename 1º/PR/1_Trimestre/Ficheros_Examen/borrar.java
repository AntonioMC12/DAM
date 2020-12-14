public class borrar {
  
  public boolean borrarCoche(String code){
    boolean result=false;
    for(int i=0;i<this.plazas.length && !result; i++){
        if(plazas[i]!=null && plazas[i].getCode().equals(code)){
            plazas[i]=null;
            result=true;
        }
    }
    return result;
  }
}