package ClaseEmpleado;
import java.util.Scanner;


public class Empleado
{
	private String name,dpto;
	private int age;
	private double salary;
	
	//Constructor por defecto
	public Empleado (){
		this.name="";
		this.dpto="";
		this.age=-1;
		this.salary=-1;
		}
	
	//Constructor para name y age del empleado
	public Empleado (String nameEmp, int ageEmp){
		this.name=nameEmp;
		this.age=ageEmp;
		this.dpto="";
		this.salary=-1;
		}
		
	//Constructor para name, age, salary	
    public Empleado (String nameEmp, int ageEmp, double salaryEmp){
		this.name=nameEmp;
		this.age=ageEmp;
		this.salary=salaryEmp;
		this.dpto="";
		}

	//Constructor para name, age, salary y dpto	
    public Empleado (String nameEmp, int ageEmp, double salaryEmp, String dptoEmp){
		this.name=nameEmp;
		this.age=ageEmp;
		this.salary=salaryEmp;
		this.dpto=dptoEmp;
		}	
	
	//métodos get
    public double getSalary(){
		return salary;
		}
	public int getAge(){
		return age;
		}
	public String getDpto(){
		return dpto;
		}
	public String getName(){
		return name;
		}
	
	//métodos set
	public void setSalary(double salaryEmp){
		this.salary=salaryEmp;
	}
	public void setAge (int ageEmp){
		this.age=ageEmp;
	}
	public void setName(String nameEmp){
		this.name=nameEmp;
	}
	public void setDpto(String dptoEmp){
		this.dpto=dptoEmp;
	}
	
	// metodo que aumenta el salario una cantidad indicada
    public void increaseSalary(double increase){
		this.salary+=increase;
		}
	
	//método que aumenta el salario en un porcentaje indicado
	public void increaseSalary(int percentage){
     this.salary=this.salary+this.salary*percentage/100;
	} 
	
	//método toString
	public String toString(){
		return "\nEmpleado: "+this.name +"\nDepartamento: "+this.dpto+"\nEdad: "+this.age+"\nSueldo: "+this.salary;
	}
}