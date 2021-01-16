public class Ejercicio4 {
    public static void main(String[] args) {
        dontGiveMeFive(1, 9);
    }
    public static void dontGiveMeFive(int start, int end) {
        if(start>end){
            int aux = start;
            start = end;
            end = aux;
        }
        for(int i = start ; i <= end ; i++){
            if(i!=5){
            System.out.print(i+", ");
            }
        }
        System.out.println(" -> Result: "+(end-start));

    }
}
