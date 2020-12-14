public class guardar {
  
  public boolean guardarDatos(){
    boolean result=false;
    
    try {
        FilesUtilities.write(_nameofFile, plazas);
        result=true;
    } catch (IOException ex) {
        ex.printStackTrace();  //solo en modo DEV
        result=false;
    }
    return result;
}
}
