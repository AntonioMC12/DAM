public class Ejercicio5 {
    public static void main(String[] args) {
        int[] array1 = {1,2,3};
        int[] array2 = {2,2,3};
        System.out.println(oddOrEven(array1));
        System.out.println(oddOrEven(array2));
    }
    public static String oddOrEven (int[] array) {
        String oddOrEven = "error";
        if(array != null && array.length > 0){
            int sum = 0;
            for(int num:array){
                sum+=num;
            }
            if(sum%2==0){
                oddOrEven = "even";
            }else{
                oddOrEven = "odd";
            }
        }
        return oddOrEven;
        }
}
