public class piramide6 {
  public static void main(String[] args) {
    //piramide hueca

    /**
     *  1      *        espacios = 4 | Asteriscos = 1
     *  2     * *       espacios = 3 | Asteriscos = 3(2)
     *  3    *   *      espacios = 2 | Asteriscos = 5(2) 
     *  4   *     *     espacios = 1 | Asteriscos = 7(2)
     *  5  *********    espacios = 0 | Asteriscos = 9
     */
    int altura = 5;

    for(int h = 0; h < altura; h++){
      
      //calculamos los espacios y los asteriscos
      int nEspacios = altura - h - 1;
      int nAsteriscos = h*2+1;

      for(int x = 0; x < nEspacios ; x++){
        System.out.print(" ");
      }
      for (int x = 0; x < nAsteriscos; x++) {
        if (x == 0 || x == nAsteriscos -1 || h == altura -1) {
          System.out.print("*");
        }else{
          System.out.print(" ");
        }
      }
      System.out.println("");
    }
  }
}
