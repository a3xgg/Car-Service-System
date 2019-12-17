package oodj;

import gui.*;
import java.util.ArrayList;
import user.Person;

public class Oodj {
    
    public static Login loginGUI;
    public static Register registerGUI;
    public static ArrayList<Person> allUser;
    
    public static void main(String[] args) {
        allUser = new ArrayList<Person>();
        loginGUI = new Login();
        registerGUI = new Register();
    }
    
}
