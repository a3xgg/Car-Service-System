package oodj;

import gui.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import user.*;

public class Oodj {
    //All GUI
    public static Login loginGUI;
    public static Register registerGUI;
    public static TechMenu techMenuGUI;
    public static MgrMenu mgrMenuGUI;
    public static ArrayList<Staff> allUser;
    
    public static void main(String[] args) {
        allUser = new ArrayList<Staff>();
        loginGUI = new Login();
        registerGUI = new Register();
        techMenuGUI = new TechMenu();
        mgrMenuGUI = new MgrMenu();
        //takes all values from the text file and stores it in the array list
        try{
            Scanner s = new Scanner(new File("staff.txt"));
            while(s.hasNext()){
                String username = s.nextLine();
                String password = s.nextLine();
                String name = s.nextLine();
                String ic = s.nextLine();
                String email = s.nextLine();
                String phone = s.nextLine();
                String address = s.nextLine();
                String department = s.nextLine();
                s.nextLine();
                Staff staffs = new Staff(username,password,name,ic,email,phone,address,department);
                allUser.add(staffs);
            }
        } catch(Exception e){
            
        }
        for(int i =0; i < allUser.size(); i++){
            System.out.println(allUser.get(i).getName());
        }
        
    }
    
}
