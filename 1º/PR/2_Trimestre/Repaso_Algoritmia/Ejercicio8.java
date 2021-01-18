import java.util.Arrays;

public class Ejercicio8 {
    public static void main(String[] args) {
        String[] array1 = {"arp", "live", "strong"};
        String[] array2 = {"lively", "alive", "harp", "sharp", "armstrong"};
        System.out.println(Arrays.toString(inArray(array1, array2)));
    }
    public static String[] inArray(String[] array1, String[] array2) {
        String[] inArray = {""};
        int nCoincidencias = 0;
        if(array1 != null && array2 != null && array1.length > 0 && array2.length > 0){
            for(int i = 0 ; i < array1.length ; i++){
                for(int j = 0; j < array2.length ; j++){
                   if(array2[j].contains(array1[i])){
                       nCoincidencias++;
                       j=array2.length;
                   } 
                }
            }
            if(nCoincidencias != 0) inArray = new String[nCoincidencias];
            for(int i = 0, x = 0 ; i < array1.length ; i++){
                for(int j = 0; j < array2.length ; j++){
                   if(array2[j].contains(array1[i])){
                       inArray[x] = array1[i];
                       x++;
                       j=array2.length;
                   }
                }
            }
        }
        return inArray;
   }
}
