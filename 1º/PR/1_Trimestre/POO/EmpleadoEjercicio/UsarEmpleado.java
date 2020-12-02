import java.util.Scanner;
import ClaseEmpleado.Empleado;
import Utils.Validaciones;

class UsarEmpleado
{
	public static void main(String[] args) 
	{
      int select=-1;
	  Scanner teclado = new Scanner(System.in);
	  //probando constructores
	  Empleado Emp1=new Empleado();
	  Validaciones v = new Validaciones();
      System.out.println(Emp1);
	  
	  Emp1=new Empleado("Pedro",30);
	  System.out.println(Emp1);

	  Emp1=new Empleado("Juan",25,1500);
  	  System.out.println(Emp1);
	  
	  Emp1=new Empleado("Maria",23,1100,"Programacion");
  	  System.out.println(Emp1);
	  
	  while(select != 0){
			menu1();
			//Recoger una variable por consola
			select = v.readNumber(); 
	
			//Ejemplo de switch case en Java
			switch(select){
				case 1: 
					dateModify(Emp1,v);
					break;
				case 2: 
					System.out.println("\nESTAS AUMENTANDO EL SALARIO CON UN IMPORTE FIJO");
					Emp1.increaseSalary(v.readNumberD());
					System.out.println(Emp1);
					break;
				case 3: 
					System.out.println("\nESTAS AUMENTANDO EL SALARIO CON UN PORCENTAJE");
					Emp1.increaseSalary(v.readNumber());
					System.out.println(Emp1);
					break;
				case 0: 
					System.out.println("Adios!");
					break;
				default:
					System.out.println("numero no reconocido");
					break;
				}
				
				System.out.println("\n"); 
				
			
		}
	  
     
	}

//metodos de la clase principal
	
	
	
	static void menu1(){
		System.out.println("\nMENU PRINCIPAL\n");
		System.out.println("Elige opcion:\n1.- Modificar parametros.\n" +
											"2.- Aumentar sueldo con importe fijo.\n" +
											"3.- Aumentar sueldo con porcentaje.\n" +
											"0.- Salir");
	}
	
	static void dateModify(Empleado e, Validaciones v){
		String nom, dep;
		int ed;
		double suel;
		int select=-1;
		Scanner teclado = new Scanner(System.in);
		System.out.println("\n\nMODIFICACION DE DATOS");
		System.out.println("\nElige opcion:\n1.- Modifica Nombre.\n" +
											"2.- Modifica Departamento.\n" +
											"3.- Modifica Salario\n" +
											"4.- Modifica Edad\n" +
											"0.- Error, no quiero modificar nada");
		select = v.readNumber();	
			//Ejemplo de switch case en Java
		switch(select){
				case 1: 
					System.out.println("Introduce nuevo Nombre: ");
					nom=teclado.nextLine();
					e.setName(nom);
					System.out.println(e);
					break;
				case 2: 
					System.out.println("Introduce nuevo Departamento: ");
					dep=teclado.nextLine();
					e.setDpto(dep);
					System.out.println(e);
					break;
				case 3: 
					System.out.println("Modificar salario");
					suel=v.readNumberD();
					e.setSalary(suel);
					System.out.println(e);
					break;
				case 4: 
					System.out.println("Modificar edad");
					ed=v.readNumber();
					e.setAge(ed);
					System.out.println(e);
					break;	
				case 0: 
					break;
				default:
					System.out.println("numero no reconocido");
					break;
				}									
		
	}

}

