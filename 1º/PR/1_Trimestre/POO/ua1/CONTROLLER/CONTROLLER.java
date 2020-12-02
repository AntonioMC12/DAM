package ua1.CONTROLLER;

import ua1.model.Car;
import ua1.model.Taller;
import ua1.utils.UIUtilities;


public class CONTROLLER {
    
    static Taller tallerControlado=null;
    
    public static void setTaller(Taller t){
        tallerControlado=t;
    }
    
    public static boolean crearCoche(Car nuevo){
        boolean result=false;
        if(tallerControlado!=null){
            result=tallerControlado.crearCoche(nuevo);
        }
        return result;
    }
    
    public static String listaCoches(){
        String result="";
        if(tallerControlado!=null){
            Car[] coches=tallerControlado.listaCoches();
            int libres=tallerControlado.huecosLibres();
            if(coches!=null){
                result=result+"De una capacidad total de "+coches.length+
                        " hay disponibles "+libres+" plazas\n";
                for(int i=0;i<coches.length;i++){
                    if(coches[i]!=null){
                        result=result+coches[i].toString()+" > "+coches[i].observaciones+"\n";
                    }
                }
            }else{
                result="No existe un taller bien estructurado\n";
            }     
        }else{
            result="No se ha definido un taller para Controlar > CONTROLLER.setTaller(taller)\n";
        }
        return result;
    }
    
    public static int huecos(){
        int result=0;
        if(tallerControlado!=null){
            result=tallerControlado.huecosLibres();
        }
        return result;
    }

    public static Car buscaPorMatricula(String criteria) {
        Car c=null;
        if(tallerControlado!=null){
            c=tallerControlado.buscaCoche(criteria);
        }
        return c;
    }

    public static Car[] buscaPorDNI(String criteria) {
        Car[] c=null;
        if(tallerControlado!=null){
            c=tallerControlado.buscaCochesPorCliente(criteria);
        }
        return c;
    }
    
    public static boolean borrarCoche(String code){
        boolean result=false;
        if(tallerControlado!=null){
            result=tallerControlado.borrarCoche(code);
        }
        return result;
    }

    public static boolean guardarDatos() {
        boolean result=false;
        if(tallerControlado!=null){
            result=tallerControlado.guardarDatos();
        }
        return result;
    }
}
