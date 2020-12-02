package ua1.utils;

import java.util.Scanner;

public class UIUtilities {

    private static Scanner keyboard = new Scanner(System.in);

    /**
     * Escribe un texto en consola sin retorno de carro
     * @param f texto a imprimir
     */
    public static void p(String f) {
        System.out.print(f);
    }
    /**
     * Escribe un texto en consola con retorno de carro
     * @param f texto a imprimir
     */
    public static void P(String f) {
        UIUtilities.p(f + "\n");
    }
    /**
     * Lee un entero de teclado
     * @return devuelve el entero leído
     */
    public static int getInt() {
        int result = 0;
        boolean valid = false;
        do {
            try {
                result = Integer.parseInt(keyboard.nextLine());
                valid = true;

            } catch (IllegalStateException ex) {
                keyboard = new Scanner(System.in);
                UIUtilities.P("Error in keyboard. Please, try it again: ");
            } catch (NumberFormatException ex) {
                UIUtilities.P("Error reading integer type. Please, try it again: ");
            }catch (Exception ex) {
                ex.printStackTrace();
                UIUtilities.P("Error unknown. Please, try it again: ");
            }
        } while (!valid);
        return result;
    }
    /**
     * Lee un entero de teclado
     * @param f Mensaje a imprimir al usuario antes de solicitar el entero
     * @return devuelve el entero leído
     */
    public static int getInt(String f) {
        UIUtilities.p(f + " : ");
        return UIUtilities.getInt();
    }
    /**
     * Lee un float de teclado
     * @return devuelve el float leído
     */
    public static float getFloat() {
        float result = 0;
        boolean valid = false;
        do {
            try {
                result = Float.parseFloat(keyboard.nextLine());
                valid = true;

            } catch (IllegalStateException ex) {
                keyboard = new Scanner(System.in);
                UIUtilities.P("Error in keyboard. Please, try it again: ");
            } catch (NumberFormatException ex) {
                UIUtilities.P("Error reading decimal number. Please, try it again: ");
            } catch (Exception ex) {
                UIUtilities.P("Error unknown. Please, try it again: ");
            } 
        } while (!valid);
        return result;
    }
    /**
     * Lee un float del teclado, imprimiendo previamente un mensaje al usuario
     * @param f mensaje a imprimir antes de solicitar el float
     * @return float insertado por el usuario
     */
    public static float getFloat(String f) {
        UIUtilities.p(f + " : ");
        return UIUtilities.getFloat();
    }
    /**
     * Lee un string de teclado
     * @return strint insertado por el usuario
     */
    public static String getString() {
        String result = "";
        boolean valid = false;
        do {
            try {
                result = keyboard.nextLine();
                valid = true;

            } catch (Exception ex) {
                UIUtilities.P("Error unknown. Please, try it again: ");
            }
        } while (!valid);
        return result;
    }
    /**
     * Lee un string de teclado, imprimiendo previamente un mensaje
     * @param f mensaje a mostrar antes de solicitar el string
     * @return string insertado por el usuario
     */
    public static String getString(String f) {
        UIUtilities.p(f + " : ");
        return UIUtilities.getString();
    }
}
