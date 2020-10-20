import java.util.Scanner;
public class pow {
  public static void main(String[] args) {
    //introduce numero y eleva a la potencia introducida
    Scanner scan = new Scanner(System.in);
    boolean negative = false;
    int num = 0, epow = 0;
    double total = 1;
    System.out.print("Introduzca la base: ");
    num = scan.nextInt();
    System.out.print("Introduzca el exponente al que elevar: ");
    epow = scan.nextInt();

    if(epow>0){
      while(epow>0){
        total = total * num;
        epow--;
      }
    }else if(epow == 0){
      System.out.println("El resultado es: 1");  
    }else{
      negative = true;
      while(epow<0){
        total = total * num;
        epow++;
      }
    }

    if(negative){
      total = 1/total;
    }
    
    System.out.println("El resultado es: "+total);
    scan.close();
  }
}
