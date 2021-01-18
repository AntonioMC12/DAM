import java.util.Arrays;

/*
deleteNth(new int[] {20,37,20,21}, 1)           // return [20,37,21]
deleteNth(new int[] {1,1,3,3,7,2,2,2,2}, 3)     // return [1, 1, 3, 3, 7, 2, 2, 2]
*/

public class Ejercicio9 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteNth(new int[] {20,37,20,21}, 1)));
        System.out.println(Arrays.toString(deleteNth(new int[] {1,1,3,3,7,2,2,2,2}, 3)));
    }
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        int[] deleteNth = null;
        int newTam = 0;
        int j= 0;
        if(elements != null && elements.length > 0 && maxOccurrences > 0){
            for(int i = 0; i < elements.length ; i++){
                j= 0;
                for(int x = 0 ; x < elements.length; x++){
                    if(elements[i]==elements[x] && j < maxOccurrences){
                        newTam++;
                        j++;
                    }
                }
            }
            System.out.println("Tamaño: "+newTam);
            deleteNth = new int[newTam];
            int contador = 0;
            for(int i = 0; i < elements.length ; i++){
                j = 0;
                for(int x = 0 ; x < elements.length; x++){
                    if(elements[i]==elements[x] && j < maxOccurrences){
                        deleteNth[contador] = elements[i];
                        contador++;
                        j++;
                    }
                }
            }
        }
		return deleteNth;
	}
}
