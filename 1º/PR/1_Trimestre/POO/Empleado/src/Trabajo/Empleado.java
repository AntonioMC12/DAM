package Trabajo;

public class Empleado {

  private String name;
  private String dpto;
  private int age;
  private double salary;

  public Empleado(String name, String dpto, int age, double salary){
    this.name = name;
    this.dpto = dpto;
    this.age = age;
    this.salary = salary;
  }

  public Empleado(String name, int age){
    this(name,"none",age,-1);
  }

  public Empleado(String name, int age, double salary){
    this(name,"none",age,salary);
  }

  public Empleado(){
    this("none","none",-1,-1);
  }

  public void setName(String name){
    this.name = name;
  }

  public void setDpto(String dpto){
    this.dpto = dpto;
  }

  public void setAge(int age){
    this.age = age;
  }

  public void setSalary(double salary){
    this.salary = salary;
  }

  public String getName(){
    return this.name;
  }

  public String getDpto(){
    return this.dpto;
  }

  public int getAge(){
    return this.age;
  }

  public double getSalary(){
    return this.salary;
  }
  
  public void increaseSalary(double increase){    
      this.salary = getSalary()+increase;
  }

  public void increaseSalary(int increase){
    //double aux = (increase/100)*getSalary();
    this.salary = getSalary() + ((float)increase/100)*getSalary();
  }

  public String toString(){
    return  '\n' + "------------------------------------"+ '\n'
            + "Empleado: "+this.name + '\n' 
            + "Departamento: " + this.dpto + '\n'
            + "Sueldo: " + this.salary + '\n'
            + "Edad: " + this.age + '\n'
            + "------------------------------------"+ '\n';
  }

}
