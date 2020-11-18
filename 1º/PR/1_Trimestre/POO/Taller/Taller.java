import vehiculo.Coche;
import vehiculo.Motor;

public class Taller {

  public static void main(String[] args) {
    Motor m1 = new Motor(3, 2500, 200, 20000);
    System.out.println(m1);
    
    Coche c1 = new Coche("1234csv", "Ford", "rojo" , "nada", "268242", "Antonio", m1);
    //System.out.println(c1);

    Coche c2 = new Coche();
    System.out.println(c2);

    System.out.println("Los kilometrod el toyota son: " + c2.motor.kilometros);

  }
}
