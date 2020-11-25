public class Saluda{
  public static void main(String[] args) {
    if(args.length != 3){
      System.out.println("Error");
    }else{
   
      switch (args[0]) {
        case "-h":

          System.out.println("Hola "+args[1]+" "+args[2]);
          
          break;

        case "-a":

          System.out.println("Adios "+args[1]+" "+args[2]);
          
          break;
      
        default:

          System.out.println("Error");
          break;
      }
    }
  }
}