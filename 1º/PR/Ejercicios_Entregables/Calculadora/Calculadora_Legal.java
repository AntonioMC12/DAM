package Calculadora;

import java.util.Scanner;
public class Calculadora_Legal {
  public static void main(String[] args) {
    boolean valid_number = false; //para saber si el numero introducido es valido o no.
    Scanner scan = new Scanner(System.in);
    byte op_menu = 0; //para guardar la opcion del menu
    double num1 = 0;
    double num2 = 0;
    double total = 0;
    //cabezera grafica de la calculadora
    System.out.println(" -------------- CALCULADORA V.0 -------------- ");
    System.out.println(" | INTRODUZCA LA TECLA '1'  PARA SUMAR       | "); 
    System.out.println(" | INTRODUZCA LA TECLA '2' PARA RESTAR       | ");  
    System.out.println(" | INTRODUZCA LA TECLA '3' PARA MULTIPLICAR  | ");   
    System.out.println(" | INTRODUZCA LA TECLA '4' PARA DIVIDIR      | ");    
    System.out.println(" --------------------------------------------- ");
    while(!valid_number){
      System.out.print("INSERTE AQUÍ ----> ");
      op_menu = scan.nextByte();
      if(op_menu != 1 && op_menu != 2 && op_menu != 3 && op_menu != 4){
        System.out.println("POR FAVOR, INSERTE UN VALOR VÁLIDO...");
      }else{ valid_number = true; }
    }
    System.out.print("INSERTE SU PRIMER VALOR ---->");
    num1 = scan.nextDouble();
    System.out.print("INSERTE SU PRIMER VALOR ---->");
    num2 = scan.nextDouble();
    switch (op_menu) {
      case 1:
        total = num1 + num2;
        break;
      case 2:
        total = num1 - num2;
        break;
      case 3:
        total = num1 * num2;
        break;
      case 4:
        if(num2 == 0){
          System.out.println("No se puede dividir por cero...");
        }else{
          total = num1 / num2;
        }
        break;
      default:
        break;
    }
    System.out.println("El Resultado final es: "+total);
    scan.close();
  }
}
