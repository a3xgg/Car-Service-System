package oodj;

import gui.*;
import java.util.ArrayList;
import user.Person;

public class Oodj {
    //All GUI
    public static Login loginGUI;
    public static Register registerGUI;
    public static TechMenu techMenuGUI;
    public static MgrMenu mgrMenuGUI;
    
    public static ArrayList<Person> allUser;
    
    public static void main(String[] args) {
        allUser = new ArrayList<Person>();
        loginGUI = new Login();
        registerGUI = new Register();
        techMenuGUI = new TechMenu();
        mgrMenuGUI = new MgrMenu();
    }
    
}
