package Ejercicio1;

public class Ejecutable {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Cuenta cuenta1 = new Cuenta("Antonio",-50);
    Cuenta cuenta2 = new Cuenta("Manuel",100);
    Cuenta cuenta3 = new Cuenta("Periquito",200);
    
    System.out.println(cuenta1);
    System.out.println(cuenta2);
    System.out.println(cuenta3);
    
    System.out.println("");
    
    cuenta1.ingresar(300);
    cuenta2.retirar(50);
    cuenta3.retirar(300);
    
    System.out.println("");
    
    System.out.println(cuenta1);
    System.out.println(cuenta2);
    System.out.println(cuenta3);
  }

}
