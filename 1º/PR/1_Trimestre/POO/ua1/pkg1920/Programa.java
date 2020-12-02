package ua1.pkg1920;


import ua1.CONTROLLER.CONTROLLER;
import ua1.UI.MENU;
import ua1.model.Taller;


public class Programa {
    public static void main(String[] args) {
        //CRUD CAR
        Taller t=new Taller();
        CONTROLLER.setTaller(t);
        MENU.menuprincipal();
        
    }
}
