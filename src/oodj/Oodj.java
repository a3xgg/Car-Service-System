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
    public static ArrayList<Staff> staffDetails;
    public static ArrayList<StaffAccount> staffAccounts;
    public static StaffAccount loginAccount;
    
    public static void main(String[] args) {
        staffDetails = new ArrayList<Staff>();
        staffAccounts = new ArrayList<StaffAccount>();
        loginGUI = new Login();
        registerGUI = new Register();
        techMenuGUI = new TechMenu();
        mgrMenuGUI = new MgrMenu();
        //takes all values from the text file and stores it in the array list
        try{
            Scanner s = new Scanner(new File("staff.txt"));
            while(s.hasNext()){
                String name = s.nextLine();
                String ic = s.nextLine();
                String email = s.nextLine();
                String phone = s.nextLine();
                String address = s.nextLine();
                String department = s.nextLine();
                s.nextLine();
                Staff staffsDetails = new Staff(name,ic,email,phone,address,department);
                staffDetails.add(staffsDetails);
            }
        } catch(Exception e){}
        try{
            Scanner s2 = new Scanner(new File("staffAccount.txt"));
            while(s2.hasNext()){
                String username = s2.nextLine();
                String password = s2.nextLine();
                String name = s2.nextLine();
                s2.nextLine();
                Staff accountOwner = null;
                for(int i = 0; i < staffDetails.size(); i++){
                    Staff temp = staffDetails.get(i);
                    if(name.equals(temp.getName())){
                        accountOwner = temp;
                        break;
                    }
                }
                StaffAccount staffAccount = new StaffAccount(username,password,accountOwner);
                accountOwner.getStaffAccount().add(staffAccount);
                staffAccounts.add(staffAccount);
            }
        } catch(Exception e2){}
    } 
}
