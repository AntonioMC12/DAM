public class Ejercicio7 {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {1,2,3,4,6};
        if(isAscOrder(array1)){
            System.out.println("true");
        }else System.out.println("false");
        if(isAscOrder(array2)){
            System.out.println("true");
        }else System.out.println("false");
    }
    public static boolean isAscOrder(int[] arr) {
        boolean isAscOrder = false;
        if(arr != null && arr.length > 1){
            for(int i = 0;  i < arr.length -1 ; i++){
                if(arr[i]+1 == arr[i+1]){
                    isAscOrder = true;
                }else isAscOrder = false;
            }
        }
        return isAscOrder;
      }
}
