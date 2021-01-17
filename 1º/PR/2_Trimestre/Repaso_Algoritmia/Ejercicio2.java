public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println(getMiddle("1234567890"));
        System.out.println(getMiddle("123456789"));
    }
    public static String getMiddle(String word) {
        String getMiddle = "";
        if(word != null && word.length()>0){
            if(word.length() <  3){
                return word;
            }else{
                if(word.length()%2==0){
                    getMiddle = word.substring((word.length()/2)-1, (word.length()/2)+1);
                }else{
                    getMiddle = word.substring((word.length()-1)/2, (word.length()+1)/2);
                }
            }
        }
        return getMiddle;
    }
}
