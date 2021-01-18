import java.util.Arrays;

/*
deleteNth(new int[] {20,37,20,21}, 1)           // return [20,37,21]
deleteNth(new int[] {1,1,3,3,7,2,2,2,2}, 3)     // return [1, 1, 3, 3, 7, 2, 2, 2]
*/

public class Ejercicio9 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteNth(new int[] { 20, 37, 20, 21 }, 1)));
        System.out.println(Arrays.toString(deleteNth(new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3)));
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        // Está feisimo y sin comentar, me vas a matar, pero ahora mismo no me da la
        // cabeza ni para hablar bien :'(
        int[] deleteNth = null;
        int newTam = 0;
        int j = 0;
        int aux = -999999999;

        if (elements != null && elements.length > 0 && maxOccurrences > 0) {
            for (int i = 0; i < elements.length; i++) {
                j = 0;
                for (int x = 0; x < elements.length; x++) {
                    if (elements[i] == elements[x]) {
                        j++;
                    }
                }
                if (j <= maxOccurrences) {
                    newTam++;
                } else if (elements[i] != aux) {
                    newTam += maxOccurrences;
                    aux = elements[i];
                }
            }
            aux = -999999999;
            int contador = 0;
            deleteNth = new int[newTam];
            for (int i = 0; i < elements.length; i++) {
                j = 0;
                for (int x = 0; x < elements.length; x++) {
                    if (elements[i] == elements[x]) {
                        j++;
                    }
                }
                if (j <= maxOccurrences) {
                    deleteNth[contador] = elements[i];
                    contador++;
                } else if (elements[i] != aux) {
                    for (int q = 0; q < maxOccurrences; q++, contador++) {
                        deleteNth[contador] = elements[i];
                    }
                    aux = elements[i];
                }
            }
        }
        return deleteNth;
    }
}
