public class piramide5 {
  public static void main(String[] args) {
    int h = 6;
    // Me permite generar las plantas
    for (int i = 0; i < h; i++) {
      int espacios = h - i - 1; // igual igual que la j
      // int asteriscos = 2 * i + 1;
      for (int x = 0; x < espacios; x++) {
        System.out.print("  ");
      }
      /**
       * Dado el numero de asteriscos imprimir 1 121 12321
       * 
       * concuerda con el i+1;
       */
      for (int x = 1; x <= i+1; x++) {
        System.out.print(x+" ");
      }
      if (i == 0) {
      } else {
        for (int x = i; x > 0; x--) {
          System.out.print(x+" ");
        }
      }
      System.out.println("");
      // System.out.print("\n");
    }
  }
}
