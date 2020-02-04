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
    public static RegisterCustomer registerCustomerGUI;
    //
    public static ArrayList<Staff> staff;
    public static ArrayList<Customer> customer;
    public static ArrayList<Appointment> appointmentDetails;
    public static Staff loginAccount;
    
    public static void main(String[] args) {
        staff = new ArrayList<Staff>();
        customer = new ArrayList<Customer>();
        loginGUI = new Login();
        registerGUI = new Register();
        techMenuGUI = new TechMenu();
        mgrMenuGUI = new MgrMenu();
        registerCustomerGUI = new RegisterCustomer();

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
                Staff staffAccountDetails = new Staff(username, password, name,ic,email,phone,address,department);
                staff.add(staffAccountDetails);
            }
        } catch(Exception e){}
        try{
            Scanner sx = new Scanner(new File("customer.txt"));
            while(sx.hasNext()){
                int id = Integer.parseInt(sx.nextLine());
                String name = sx.nextLine();
                String ic = sx.nextLine();
                String email = sx.nextLine();
                String phone = sx.nextLine();
                String address = sx.nextLine();
                sx.nextLine();
                Customer customerDetails = new Customer(id,name,ic,email,phone,address);
                customer.add(customerDetails);
            }
        } catch(Exception e){}
    }
}
