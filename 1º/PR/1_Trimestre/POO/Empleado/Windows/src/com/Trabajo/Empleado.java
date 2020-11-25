package com.Trabajo;

/**
 * Clase Empleado, es la clase sobre la que tenemos que trabajar en esta
 * practica.
 * 
 * @author Antonio Muñoz Cubero
 */

public class Empleado {

  private String name;
  private String dpto;
  private int age;
  private double salary;

  /**
   * Este es el constructor con todos los parámetros pasados como argumento
   * 
   * @param name
   * @param dpto
   * @param age
   * @param salary
   */
  public Empleado(String name, String dpto, int age, double salary){
    this.name = name;
    this.dpto = dpto;
    this.age = age;
    this.salary = salary;
  }

  /**
   * Este es el constructor con solo nombre y edad como argumento
   * 
   * @param name
   * @param age
   */
  public Empleado(String name, int age){
    this(name,"none",age,-1);
  }

  /**
   * Este es el constructor con nombre, edad y salario como argumento.
   * 
   * @param name
   * @param age
   * @param salary
   */
  public Empleado(String name, int age, double salary){
    this(name,"none",age,salary);
  }

  /**
   * Este es el constructor por defecto
   */
  public Empleado(){
    this("none","none",-1,-1);
  }

  /**
   * Setter de nombre
   * 
   * @param name
   */
  public void setName(String name){
    this.name = name;
  }

  /**
   * Setter de departamento
   * 
   * @param dpto
   */
  public void setDpto(String dpto){
    this.dpto = dpto;
  }

  /**
   * Setter de edad
   * 
   * @param age
   */
  public void setAge(int age){
    this.age = age;
  }

  /**
   * Setter de salario
   * 
   * @param salary
   */
  public void setSalary(double salary){
    this.salary = salary;
  }

  /**
   * Getter de nombre
   * 
   * @return name
   */
  public String getName(){
    return this.name;
  }

  /**
   * Getter de departamento
   * 
   * @return dpto
   */
  public String getDpto(){
    return this.dpto;
  }

  /**
   * Getter de edad
   * 
   * @return edad
   */
  public int getAge(){
    return this.age;
  }

  /**
   * Getter de salario
   * 
   * @return salario
   */
  public double getSalary(){
    return this.salary;
  }
  
  /**
   * Metodo para incrementar el salario con un valor pasado como argumento, el 
   * argumento es un double y se le suma al salario la cantidad que le pasamos.
   * 
   * @param increase
   */
  public void increaseSalary(double increase){    
      this.salary = getSalary()+increase;
  }

  /**
   * Metodo para incrementar el salario con un porcentaje pasado como argumento,
   * el argumento es un int y le suma el porcentaje al salario ya establecido.
   * 
   * @param increase
   */
  public void increaseSalary(int increase){
    this.salary = getSalary() + ((float)increase/100)*getSalary();
  }

  /**
   * Metodo toString sobreescrito
   */
  public String toString(){
    return  '\n' + "------------------------------------"+ '\n'
            + "Empleado: "+this.name + '\n' 
            + "Departamento: " + this.dpto + '\n'
            + "Sueldo: " + this.salary + '\n'
            + "Edad: " + this.age + '\n'
            + "------------------------------------"+ '\n';
  }

}
