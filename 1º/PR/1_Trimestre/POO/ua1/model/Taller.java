package ua1.model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua1.utils.FilesUtilities;

public class Taller {
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
        this("anonimo",PLAZAS_DEFAULT);
    }
    
    public boolean crearCoche(Car nuevo){
        boolean result=false;
        
        if(buscaCoche(nuevo.getCode())==null){
            for(int i=0;i<plazas.length&&!result;i++){
                if(plazas[i]==null){
                    plazas[i]=nuevo;
                    result=true;
                }
            }
        }
        
        return result;
    }
    
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
    public int huecosLibres(){
        int n=0;
        for(int i=0;i<this.plazas.length;i++){
            if(this.plazas[i]==null){
                n++;
            }
        }
        return n;
    }
    
    public Car[] listaCoches(){
        return this.plazas;
    }
    
    /**
     * Carga la base de datos de un archivo dado. Si no existe el archivo
     * o el contenido no es compatible, crea un array vacío de n elementos de
     * capacidad, dado por el otro parámetro de entrada.
     * @param filename Archivo a cargar la base de datos
     * @param capacidadpordefecto Si no existe la base de datos o está vacía 
     * crea un array del número de elementos dado por este parámetro.
     * @return Devuelve un array con los elementos cargados de la base de 
     * datos o vacío en caso de que la base de datos no contenga información.
     */
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
