package ua1.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ua1.model.Car;

public class FilesUtilities {
/**
 * Escribe un objeto (en este caso un array de Car) en un archivo de forma persistente
 * Sobre escribe el contenido que hubiera antes.
 * @param filename nombre del archivo a escribir
 * @param x objeto (array de Car) a guardar
 * @throws IOException en caso de errores en el acceso a disco
 */
    public static void write(String filename, Car[] x) throws IOException {
        BufferedOutputStream output = null;
        output = new BufferedOutputStream(new FileOutputStream(filename));
        ObjectOutputStream oos = new ObjectOutputStream(output);
        oos.writeObject(x);
        oos.flush();
        output.flush();
        oos.close();
        output.close();
    }
/**
 * Lee un array de coches de un archivo dado.
 * @param filename nombre del archivo del que se quiere leer.
 * @return devuelve el array de Coches o null en caso de que no existan.
 * @throws IOException si hay problemas en el acceso a disco
 * @throws ClassNotFoundException en caso de que no exista la clase Car en el proyecto
 */
    public static Car[] read(String filename) throws IOException, ClassNotFoundException {
        Car[] result;
        BufferedInputStream input = null;
        input = new BufferedInputStream(new FileInputStream(filename));
        ObjectInputStream ois = new ObjectInputStream(input);
        result= (Car[])ois.readObject();
        ois.close();
        input.close();
        return result;
    }
}
