public class Ejercicio10 {
    public static void main(String[] args) {
        System.out.println(digital_root(16));
        System.out.println(digital_root(493193));
    }

    public static int digital_root(int n) {
        int cifra = 0;
        int suma = 0;
        boolean entra = true;

        while (entra) {
            while (n != 0) {
                cifra = n % 10;
                suma = suma + cifra;
                n = n / 10;
            }
            if (suma > 9) {
                n = suma;
                suma = 0;
                cifra = 0;
            } else
                entra = false;
        }
        return suma;
    }
}
