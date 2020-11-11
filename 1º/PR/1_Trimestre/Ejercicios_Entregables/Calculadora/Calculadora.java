import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculadora {
  
  //la calculadora pero hecha con metodos.
  
  //Introduzco una seria de comando ANSI para tener colores en la consola de Linux (Compatible solo en Linux y Mac)
  //Reset
  public static final String ANSI_RESET = "\u001B[0m";
  //Colores de letra
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";
  //Colores de fondo
  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
  

  
  public static void main(String[] args) {    
    start();    
  }
  
  //--------------------------------------
  //   METODOS DE LA CLASE CALCULADORA
  //--------------------------------------
  
  static void p(String text) {
    System.out.print(text);
  }
  
  static void P(String text) {
    System.out.println(text);
  }
  
  static void start() {
    P(ANSI_CYAN_BACKGROUND + ANSI_BLACK + "Quiere iniciar la calculadora?");
    p("Inserte y(Si) / n(No):" + ANSI_RESET +" ");
    
    char value = getChar();
    
    if(value == 'y') {
      calculator();
    }else {
      showEnd();
    }  
  }

  static void calculator(){
    showMenu();
    showResults(calculate(getMenu()));
    start();
  }
  
  static char getChar() {
    //Inicio una variable global Scanner para introducir por teclado en todas las clases.
    Scanner scan = new Scanner(System.in);
    
    char value = scan.next().charAt(0);
    
    return value;
  }

  static int getInt(String text) {
    
    boolean validNum = true;
    Scanner scan = new Scanner(System.in);
    int num = 0;

    do {   
      try {
        p(text);
        num = scan.nextInt();
        validNum = false;

        
      }  catch (InputMismatchException ex) {
        
        scan.nextLine();
        validNum = true;
        P(ANSI_RED_BACKGROUND + ANSI_BLACK + "Debe ingresar obligatoriamente un numero valido." + ANSI_RESET);
        

      } catch (Exception e) {
        
        scan.nextLine();
        validNum = true;
        P(ANSI_RED_BACKGROUND + ANSI_BLACK + "Debe ingresar obligatoriamente un numero valido." + ANSI_RESET);

      }
    } while(validNum);
    
    return num;
  }

  static float getFloat(String text) {
    boolean validNum = true;
    Scanner scan = new Scanner(System.in);
    float num = -1;

    do {   
      try {
        p(text);
        num = scan.nextFloat();
        validNum = false;

        
      }  catch (InputMismatchException ex) {
        
        scan.nextLine();
        validNum = true;
        P(ANSI_RED_BACKGROUND + ANSI_BLACK + "Debe ingresar obligatoriamente un numero valido." + ANSI_RESET);
        

      } catch (Exception e) {
        
        scan.nextLine();
        validNum = true;
        P(ANSI_RED_BACKGROUND + ANSI_BLACK + "Debe ingresar obligatoriamente un numero valido." + ANSI_RESET);

      }
    } while(validNum);
    
    return num;
  }
 
  static void showMenu() {
    
    P(ANSI_WHITE_BACKGROUND + ANSI_BLUE + " -------------- CALCULADORA V.1 -------------- ");
    P(" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"1" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA SUMAR          | ");
    P(" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"2" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA RESTAR         | ");
    P(" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"3" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA MULTIPLICAR    | ");
    P(" | INTRODUZCA LA TECLA " + ANSI_YELLOW_BACKGROUND + ANSI_RED +"4" + ANSI_WHITE_BACKGROUND + ANSI_BLUE + " PARA DIVIDIR        | ");
    P(" --------------------------------------------- " + ANSI_RESET);
  }
  
  static int getMenu() {
    
    boolean valid = false;
    int op_menu = -1;
    
    do{ 
      
      valid = false;                
      op_menu = getInt(ANSI_WHITE_BACKGROUND + ANSI_RED + "INSERTA AQUI SU ELECCION ---->" + ANSI_RESET + " " + ANSI_GREEN);      
      
      if(op_menu != 1 && op_menu != 2 && op_menu != 3 && op_menu != 4){          
        
        P(ANSI_RED_BACKGROUND + ANSI_BLACK +"Debe insertar un valor valido..." + ANSI_RESET);          
        valid = true;
        
      }          
    }while(valid);
    
    return op_menu;
  }
  
  static void showEnd() {
    P(ANSI_GREEN_BACKGROUND + ANSI_BLACK +"Gracias por usar mi calculadora. Hasta la proxima!" + ANSI_RESET);
  }
  
  static double calculate(int option) {
    double result = 0;
    
    float num1 = getFloat(ANSI_WHITE_BACKGROUND + ANSI_RED + "INSERTA AQUI SU PRIMER VALOR ---->" + ANSI_RESET + " " + ANSI_GREEN);
    float num2 = getFloat(ANSI_WHITE_BACKGROUND + ANSI_RED + "INSERTA AQUI SU SEGUNDO VALOR ---->" + ANSI_RESET + " " + ANSI_GREEN);
    
    switch (option) {
    //1 suma, 2 resta, 3 multiplica, 4 divide      
    case 1:       
      result = num1 + num2;
      break;     
    case 2:       
      result = num1 - num2;
      break;
    case 3:       
      result = num1 * num2;
      break;       
    case 4:        
        
        try {
          result = num1 / num2;
        
        } catch(ArithmeticException ex){
          result = 0;
          P(ANSI_RED_BACKGROUND + ANSI_BLACK + "No se puede dividir por 0" + ANSI_RESET);
        } catch(Exception ex) {
          result = 0;
          P(ANSI_RED_BACKGROUND + ANSI_BLACK + "Ha ocurrido un error." + ANSI_RESET);
        }
      
       break;            
    default:
      p(ANSI_RED_BACKGROUND + ANSI_BLACK + "Syntax Error" + ANSI_RESET);
      break;
    }
    
    return result;
    
  }

  static void showResults(double result) {
    P(ANSI_GREEN_BACKGROUND + ANSI_BLUE + " -------------------------------------------------------------- ");
    P(ANSI_RESET + "                      EL RESULTADO ES: " + result + "                   " + ANSI_RESET);
    P(ANSI_GREEN_BACKGROUND + ANSI_BLUE + " -------------------------------------------------------------- ");   
    }
}
