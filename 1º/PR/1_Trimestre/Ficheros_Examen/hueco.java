public class hueco {
  public int huecosLibres(){
    int n=0;
    for(int i=0;i<this.plazas.length;i++){
        if(this.plazas[i]==null){
            n++;
        }
    }
    return n;
}
}
