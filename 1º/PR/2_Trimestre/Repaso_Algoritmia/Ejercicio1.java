public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println(maskify("4556364607935616"));
        System.out.println(maskify("64607935616"));
        System.out.println(maskify("1"));
        System.out.println(maskify(""));
        System.out.println(maskify("Skippy"));
        System.out.println(maskify("Nananananananananananananananana Batman!"));
    }

    public static String maskify(String srt) {
        String maskify = "";
        if (srt != null && srt.length() > 0) {
            if (srt.length() < 4) {
                return srt;
            } else {
                String visible = srt.substring(srt.length() - 4, srt.length());
                String aux = "";
                for (int i = 0; i < srt.length() - 4; i++) {
                    aux += '#';
                }
                maskify = aux + visible;
            }
        }
        return maskify;
    }
}