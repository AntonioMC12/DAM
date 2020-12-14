import java.util.Scanner;

public class piramide4 {
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Inserte la altura: ");
    int alt = (scan.nextInt()/2); //divido entre 2 para que cada piramide sea de la mitad de altura y la total sea el numero introducido
    int aux = alt; //auxiliar para el for de la primera piramide
    int aux2 = alt; //auxiliar para el for de la segunda piramide
    
    for (int fila = 1; fila <= alt; fila++) {
      for(int nEspacios = aux -1; nEspacios >= 0 ; nEspacios--){
        //Para los espacios
        System.out.print(" ");
      }
      for(int nAsteriscos = 1 ; nAsteriscos <= (fila*2)-1 ; nAsteriscos++){
        //Para los asteriscos
        System.out.print("*");   
      }
      aux--; //Decremento para calcular el numero de espacios bien
      System.out.println(""); 
    }

    //Ahora hago la piramide invertida con la misma altura que la anterior

    for (int fila = 1; fila <= alt; fila++) {
      for(int nEspacios = 0; nEspacios < fila ; nEspacios++){
        //Para los espacios
        System.out.print(" ");
      }
      for(int nAsteriscos = 1 ; nAsteriscos <= (aux2*2)-1 ; nAsteriscos++){
        //Para los asteriscos
        System.out.print("*");   
      }
      aux2--; //Decremento para calcular el numero de asteriscos bien
      System.out.println(""); 
    }
    scan.close();
  }
}
