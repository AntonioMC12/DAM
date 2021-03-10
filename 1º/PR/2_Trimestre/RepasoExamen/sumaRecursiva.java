
public class sumaRecursiva {

  public static void main(String[] args) {
    //calcular recursivamente la suma de los elementos de un array de enteros.
    
    int[] array = new int[] {1,2,3,4,5,6,7,8,9}; //el total es 45
    
    System.out.println(sumaArray(0,array.length-1,array));
    
  }
  
  public static int sumaArray(int inicio, int fin, int[] array) {
    
    if(inicio == fin) {
      return array[inicio];
    }{
      
      
      int mitad = (inicio+fin)/2;
      int subProblema1 = sumaArray(inicio,mitad,array);
      int subProblema2 = sumaArray(mitad+1,fin,array);
      
      return subProblema1+subProblema2;
    }
  }

}
