package ua1.pkg1920;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua1.model.Car;
import ua1.model.Cliente;
import ua1.utils.FilesUtilities;
import ua1.utils.UIUtilities;

public class Ejemplo {

    public static void main(String[] args) {

        Car c1 = new Car("5263CCD", 200, 1.6f);
        c1.setPropietario(new Cliente("123", "Carlos"));

        Car c2 = new Car(UIUtilities.getString("Inserte matrícula"), UIUtilities.getInt("Inserte kms"), UIUtilities.getFloat("Inserte cc"));
        c2.setPropietario(new Cliente(UIUtilities.getString("Inserte dni del cliente:"), UIUtilities.getString("Inserte nombre del cliente")));
        UIUtilities.P("Nuevo coche introducido, no olvide guardar la base de datos");

        Car[] coches = new Car[2];
        coches[0] = c1;
        coches[1] = c2;

        //Ojo sobreescribe al antiguo archivo    
        try {
            FilesUtilities.write("Database.data", coches);
            UIUtilities.P("Base de datos guardada con éxito");
        } catch (IOException ex) {
            UIUtilities.P("Error al guardar la base de datos, compruebe acceso a disco");
            ex.printStackTrace();
        }

        try {
            UIUtilities.P("Cargando base de datos...");
            Car[] coches2 = FilesUtilities.read("Database.data");
            for (Car c : coches2) {   //equiparable a for(int i=0;i<coches2.lenght;i++){ UIUtilities.P(coches2[i].toString()); }
                UIUtilities.P(c.toString());
            }
        } catch (ClassNotFoundException ex) {
            UIUtilities.P("Error al cargar la base de datos, compruebe acceso a disco");
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Ejemplo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
