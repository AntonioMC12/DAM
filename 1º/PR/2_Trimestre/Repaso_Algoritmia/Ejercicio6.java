public class Ejercicio6 {
    public static void main(String[] args) {
        System.out.println(highAndLow("-1 -2 -3 -4 -5"));
    }
    public static String highAndLow(String numbers) {
        String highAndLow = "error";
            if(numbers != null && numbers.length()!=5){
                String[] parts = numbers.split(" ");
                int[] num = new int[5];
                for(int i = 0 ; i < num.length ; i++){
                    num[i] = Integer.parseInt(parts[i]);
                }
                int high = num[0];
                int low = num[0];
                for(int aux:num){
                    if(aux>high)high=aux;
                    if(aux<low)low=aux;
                }
            highAndLow = high+" "+low;
            }
        return highAndLow;
    }
}
