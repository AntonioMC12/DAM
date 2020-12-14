public class cargar {
  private Car[] cargaBaseDatos(String filename,int capacidadpordefecto){
    Car[] lista;
    
    try {
        lista=FilesUtilities.read(filename);
        if(lista==null){
            lista=new Car[capacidadpordefecto];
        }
    } catch (IOException ex) {
        ex.printStackTrace();
        lista=new Car[capacidadpordefecto];
    } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
        lista=new Car[capacidadpordefecto];
    } catch (Exception ex){
        ex.printStackTrace();
        lista=new Car[capacidadpordefecto];
    }
    
    return lista;
  }
}
