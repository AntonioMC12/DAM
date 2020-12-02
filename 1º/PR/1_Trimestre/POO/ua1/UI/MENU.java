package ua1.UI;

import ua1.CONTROLLER.CONTROLLER;
import ua1.model.Car;
import ua1.model.Cliente;
import ua1.utils.UIUtilities;


public class MENU {
    
    
    static final int C=1;
    static final int R=2;
    static final int U=3;
    static final int D=4;
    
    static final int SAVE=5;
    static final int EXIT=6;
    
    
    public static void menuprincipal(){
        int opcion=-1;
        do{
            opcionesPrincipal();
            opcion=UIUtilities.getInt("Inserte una opción válida");
            switch(opcion){
                case C:
                    crearCoche();
                    break;
                case R:
                    listaCoches();
                    break;
                case U:
                    menuEditar();
                    break;
                case D:
                    menuBorrar();
                    break;
                
                case EXIT:
                  UIUtilities.p("Antes de salir: ");
                case SAVE:
                    menuGuardar();
                    break;
                default:
                    opcion=-1;
                    UIUtilities.P("Opción Incorrecta. Pulsa Enter para continuar");
                    UIUtilities.getString();
            }
        }while(opcion!=EXIT);
    }
    
    private static void opcionesPrincipal(){
        UIUtilities.P("Pulse 1 para Insertar un coche");
        UIUtilities.P("Pulse 2 para Listar los coches");
        UIUtilities.P("Pulse 3 para Editar un coche (observaciones)");
        UIUtilities.P("Pulse 4 para Borrar un coche");
        UIUtilities.P("Pulse 5 para Guardar la base de datos");
        UIUtilities.P("Pulse 6 para Salir");
    }
    private static void crearCoche(){
        Car nuevoCoche=new Car(UIUtilities.getString("Matricula"),
                UIUtilities.getInt("Kms"),UIUtilities.getFloat("CC"));
        nuevoCoche.setPropietario(new Cliente(UIUtilities.getString("DNI"),
                                UIUtilities.getString("Nombre")));
        nuevoCoche.observaciones=UIUtilities.getString("Observaciones");
        
        if(CONTROLLER.crearCoche(nuevoCoche)){
            UIUtilities.P("Coche insertado correctamente");
        }else{
            UIUtilities.P("No hay espacio suficiente o el coche ya existe");
        }
    }
    
    private static void listaCoches(){

        String result=CONTROLLER.listaCoches();
        UIUtilities.P(result);
        UIUtilities.getString("Pulse una ENTER para continuar");
           
    }
    private static void menuEditar(){
        UIUtilities.P("Editando vehículo");
        Car elegido=menuBusquedaCoches();
        if(elegido!=null){
            UIUtilities.P("Solo puede editar su observación, actualmente su valor:");
            UIUtilities.P(elegido.observaciones);
            elegido.observaciones=UIUtilities.getString("Inserte nueva observación");
            UIUtilities.P("La observación se ha modificado, no olvide guardar la base de datos");
            UIUtilities.getString("Pulse ENTER para continuar");
        }else{
            UIUtilities.getString("Pulse ENTER para continuar");
        }
        
    }
    private static void menuBorrar(){
        UIUtilities.P("Borrando vehículo");
        Car elegido=menuBusquedaCoches();
        if(elegido!=null){
            CONTROLLER.borrarCoche(elegido.getCode());
            UIUtilities.P("Coche eliminado");
            UIUtilities.getString("Pulse ENTER para continuar");
        }else{
            UIUtilities.getString("Pulse ENTER para continuar");
        }
    }
    private static Car menuBusquedaCoches(){
        int opcion=-1;
        Car encontrado=null;
        do{
        UIUtilities.P("Búsqueda de vehículo");
        UIUtilities.P("1. Por matrícula");
        UIUtilities.P("2. Por cliente");
        UIUtilities.P("3. Para volver al menú principal");
       
        String criteria;
        opcion=UIUtilities.getInt("Elija una opción");
        
            switch(opcion){
                case 1:
                    criteria=UIUtilities.getString("Introduzca la matrícula");
                    encontrado=CONTROLLER.buscaPorMatricula(criteria);
                    if(encontrado==null){
                         UIUtilities.P("No existen coches con esa matrícula");
                    }
                    opcion=3;
                    break;
                case 2:
                    criteria=UIUtilities.getString("Introduzca el dni");
                    Car[] encontrados=CONTROLLER.buscaPorDNI(criteria);
                    if(encontrados==null || encontrados.length==0){
                        UIUtilities.P("No existen coches para ese cliente");
                        UIUtilities.getString("Pulse ENTER para continuar");
                    }else if(encontrados.length==1){
                        encontrado=encontrados[0];
                    }else{
                        boolean valid=false;
                        do{
                            UIUtilities.P("El usuario tiene los siguientes coches, elija uno:");
                            for(int i=0;i<encontrados.length;i++){
                                UIUtilities.P((i+1)+". "+encontrados[i]);
                            }
                            int eleccion=UIUtilities.getInt("Inserta opción");
                            if(eleccion<1 || eleccion > encontrados.length){
                                UIUtilities.P("Elija un coche correcto");
                                valid=false;
                            }else{
                                valid=true;
                            }
                            encontrado=encontrados[eleccion-1];
                        }while(!valid);
                    }
                    opcion=3;
                    break;
                case 3:
                    break;
                default:
                    UIUtilities.P("Elija una opción correcta");
            }
        }while(opcion!=3);
        return encontrado;
    }
    private static void menuGuardar(){
        String opcion="s";
        opcion=UIUtilities.getString("Desea guardar la base de datos (s o n)");
        if(opcion.toLowerCase().equals("s")){
           if(CONTROLLER.guardarDatos()){
               UIUtilities.P("Base de datos guardada correctamente");
               UIUtilities.getString("Pulse ENTER para continuar");
           }else{
               UIUtilities.P("Error al guardar la base de datos");
               UIUtilities.getString("Pulse ENTER para continuar");
           }
        }
        
    }
    
}
