package oodj;

import gui.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import user.*;

public class Oodj {
    //Format Date and Time
    private SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    //All GUI
    public static Login loginGUI;
    public static Register registerGUI;
    public static TechMenu techMenuGUI;
    public static MgrMenu mgrMenuGUI;
    public static Payment paymentGUI;
    //
    public static ArrayList<Manager> manager;
    public static ArrayList<Technician> technician;
    public static ArrayList<Staff> staff;
    public static ArrayList<Customer> customer;
    public static ArrayList<Appointment> appointmentDetails;

    public static Staff loginAccount;
    public static Staff toEditStaff;
    public static Customer toEditCustomer;
    public static Customer custLogin;
    public static Appointment aptPayment;
    
    public static void main(String[] args) {
        manager = new ArrayList<Manager>();
        technician = new ArrayList<Technician>();
        staff = new ArrayList<Staff>();
        customer = new ArrayList<Customer>();
        appointmentDetails = new ArrayList<Appointment>();
        loginGUI = new Login();
        registerGUI = new Register();
        techMenuGUI = new TechMenu();
        mgrMenuGUI = new MgrMenu();
        paymentGUI = new Payment();

        //takes all values from the text file and stores it in the array list
        readCustomer();
        readStaff();
        readAppointment();
    }
    
    public static void readStaff(){
        try{
            Scanner s = new Scanner(new File("staff.txt"));
            while(s.hasNext()){
                int id = Integer.parseInt(s.nextLine());
                String username = s.nextLine();
                String password = s.nextLine();
                String name = s.nextLine();
                String ic = s.nextLine();
                String email = s.nextLine();
                String phone = s.nextLine();
                String address = s.nextLine();
                String department = s.nextLine();
                s.nextLine();
                //Adds each specific role to each department
                if(department.equals("Manager")){
                    Manager managerDetails = new Manager(id,username,password,name,ic,email,phone,address,department);
                    manager.add(managerDetails);
                } else if(department.equals("Technician")){
                    Technician technicianDetails = new Technician(id,username,password,name,ic,email,phone,address,department);
                    technician.add(technicianDetails);
                }
                Staff staffAccountDetails = new Staff(id,username, password, name,ic,email,phone,address,department);
                staff.add(staffAccountDetails);
            }
        } catch(Exception e){}
    }
    
    public static void readCustomer(){
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
    
    public static void readAppointment(){
        try{
            Scanner sx = new Scanner(new File("appointment.txt"));
            while(sx.hasNext()){
                int id = Integer.parseInt(sx.nextLine());
                LocalDate date = LocalDate.parse(sx.nextLine());
                LocalTime time = LocalTime.parse(sx.nextLine());
                LocalTime endTime = LocalTime.parse(sx.nextLine());
                String serviceType = sx.nextLine();
                String customerName = sx.nextLine();
                String technicianName = sx.nextLine();
                String appointmentStatus = sx.nextLine();
                int charge = Integer.parseInt(sx.nextLine());
                int totalPaid = Integer.parseInt(sx.nextLine());
                sx.nextLine();
                Customer x = null;
                Technician y = null;
                for(int i = 0; i < customer.size(); i++){
                    if(customerName.equals(customer.get(i).getName())){
                        x = customer.get(i);
                        break;
                    }
                }
                for(int i = 0; i < technician.size(); i++){
                    if(technicianName.equals(technician.get(i).getName())){
                        y = technician.get(i);
                        break;
                    }
                }
                Appointment appointment = new Appointment(id,date,time,endTime,serviceType,x,y,appointmentStatus,charge,totalPaid);
                y.addAppointment(appointment);
                appointmentDetails.add(appointment);
            }
        } catch(Exception e){}
    }
}
