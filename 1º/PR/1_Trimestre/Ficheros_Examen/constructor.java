public class constructor {

  final static int PLAZAS_DEFAULT=10;
    
  private String name;
  private String _nameofFile;
  private Car[] plazas;

  
  public Taller(String name, int capacidamaxima){
      if(capacidamaxima<0)
          capacidamaxima=PLAZAS_DEFAULT;
      this.name=name;
      _nameofFile=name.replace(" ", "_");
      _nameofFile=_nameofFile.toLowerCase()+".data";
      this.plazas=this.cargaBaseDatos(_nameofFile,capacidamaxima);
      
  }
  
  public Taller() {
      //this("anonimo",PLAZAS_DEFAULT);
  }  
}
