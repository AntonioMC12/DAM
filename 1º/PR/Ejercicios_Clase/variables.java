class variables{
  static int globalVar = 5;
  public static void main(String[] args) {
    int mainVar = 10;
    for(int i = 1 ; i < 15 ; i++){
      //System.out.println(i);
    }
      //System.out.println(i);
      System.out.println("variable main = " + mainVar);
      System.out.println("variable global = " + globalVar);
      imprime();

  } 
  static void imprime(){
    System.out.println("funcion imprime variable global " + globalVar);
  }
}