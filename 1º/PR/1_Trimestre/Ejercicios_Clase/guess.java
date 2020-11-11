
import java.lang.Math;
import java.util.Scanner;

public class guess {
  public static void main(String[] args) {
    
    //  -Crea un juego que genere un numero aleatorio y el jugador tiene 3 intentos para adivinar el número
    
    Scanner scan = new Scanner(System.in);
    double numeroAleatorio = Math.floor(Math.random()*10+1); //número aleatorio entre 1 y 
    int guess;
    int count = 0;
    boolean valid = false;
    System.out.println("Se va a producir un número aleatorio entre 1 y 10, intente adivinarlo, suerte");

    do{

      System.out.print("Haga una suposición: ");
      guess = scan.nextInt();

      if(guess > numeroAleatorio){
        System.out.println("Uy, muy alto, pruebe otra vez...");
        count++;
      }else if(guess < numeroAleatorio){
        System.out.println("Uy, muy bajo, pruebe otra vez...");
        count++;
      }else{
        valid = true;
      }

      if(count == 3){
        valid = true;
      }
    }while(!valid);

    switch (count) {
      case 0:
        System.out.println("ENHORABUENA, HA ACERTADO."); 
        break;
      
      case 1:
      System.out.println("ENHORABUENA, HA ACERTADO.");
        break;

      case 2:
      System.out.println("ENHORABUENA, HA ACERTADO.");
        break;

        
      case 3:
      System.out.println("Lo siento, ha utilizado todos los intentos...");
        break;  

      default: 
      System.out.println("ERROR.");
        break;
    }
    scan.close();
  }
}
