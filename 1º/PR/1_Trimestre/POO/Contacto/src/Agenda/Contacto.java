package Agenda;
import Agenda.Medios.Email;

public class Contacto {

  private String name;
  private Email email;
  private int age;

  public Contacto(String name, Email email, int age){
    this.name = name;
    this.email = email;
    this.age = age;
  }

  public Contacto(){
    this("Unkown",null,-1);
  }
  
  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name = name;
  }

  public Email getEmail(){
    return this.email;
  }

  public void setEmail(Email newEmail){
    this.email = newEmail;
  }

  public int getAge(){
    return this.age;
  }

  public void setAge(int age){
    this.age = age;
  }

  public String toString(){
    return this.name+" -> "+this.email+" : "+this.age;
  }
}
