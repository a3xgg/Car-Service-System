package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oodj.*;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener{
    
    private final JButton loginBtn, quitBtn;
    private final JTextField username;
    private final JPasswordField password;
    private final JLabel usrlbl, passlbl, message;
    public JLabel loggedInUser;

    public Login(){

        setSize(266,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100,200);
        
        message = new JLabel("APU Automotive Service Center\n");

        usrlbl = new JLabel("Username: ");
        username = new JTextField(15);
        username.addActionListener(this);

        passlbl = new JLabel("Password: ");
        password = new JPasswordField(15);
        password.addActionListener(this);
        
        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener(this);

        add(message);
        add(usrlbl);add(username);add(passlbl);add(password);
        add(loginBtn);add(quitBtn);
        
        setVisible(true);
        setLayout(new FlowLayout());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        /*
        Login button and pressing the ENTER button will invoke the action to login.
        if no username and password is entered, program will show 'Wrong Credentials'
        if wrong username and password is entered, program will show 'Wrong Credentials'
        */
        if(ae.getSource() == loginBtn || ae.getSource() == username || ae.getSource() == password){
            //Oodj.mgrMenuGUI.setVisible(true); //for debugging purpose
            String uname = username.getText();
            String pwd = new String(password.getPassword());
            
            verifyAccount(uname, pwd);
            
            //Sets all text and password field to null if either credentials is incorrect or correct
            username.setText(null);
            password.setText(null);
        } else if(ae.getSource() == quitBtn){
            /*
            The following code will execute once the technician or manager presses the quit button
            Staff details will be stored in separate folders from the Staff Account
            Staff Details will be stored in the staff.txt file
            Staff Account Details will be stored in the staffAccount.txt file
            */
            try{
                PrintWriter p = new PrintWriter("staff.txt");
                for(int i = 0; i < Oodj.staff.size(); i++){
                    p.println(Oodj.staff.get(i).getUsername());
                    p.println(Oodj.staff.get(i).getPassword());
                    p.println(Oodj.staff.get(i).getName());
                    p.println(Oodj.staff.get(i).getIcNumber());
                    p.println(Oodj.staff.get(i).getEmail());
                    p.println(Oodj.staff.get(i).getPhoneNumber());
                    p.println(Oodj.staff.get(i).getMailingAddress());
                    p.println(Oodj.staff.get(i).getDepartment());
                    p.println();
                    
                }
                p.close();
            } catch(Exception e){}
            try{
                PrintWriter p = new PrintWriter("customer.txt");
                for(int i = 0; i < Oodj.customer.size(); i++){
                    p.println(Oodj.customer.get(i).getCustID());
                    p.println(Oodj.customer.get(i).getName());
                    p.println(Oodj.customer.get(i).getIcNumber());
                    p.println(Oodj.customer.get(i).getEmail());
                    p.println(Oodj.customer.get(i).getPhoneNumber());
                    p.println(Oodj.customer.get(i).getMailingAddress());
                    p.println();
                }
                p.close();
            } catch (Exception e){}
            try{
                PrintWriter p = new PrintWriter("appointment.txt");
                for(int i = 0; i < Oodj.appointmentDetails.size(); i++){
                    p.println(Oodj.appointmentDetails.get(i).getAppointmentID());
                    p.println(Oodj.appointmentDetails.get(i).getAppointmentDate());
                    p.println(Oodj.appointmentDetails.get(i).getAppointmentStartTime());
                    p.println(Oodj.appointmentDetails.get(i).getAppointmentEndTime());
                    p.println(Oodj.appointmentDetails.get(i).getServiceType());
                    p.println(Oodj.appointmentDetails.get(i).getCustomer().getName());
                    p.println(Oodj.appointmentDetails.get(i).getStaff().getName());
                    p.println(Oodj.appointmentDetails.get(i).getAppointmentStatus());
                    p.println(Oodj.appointmentDetails.get(i).getCharge());
                    p.println(Oodj.appointmentDetails.get(i).getTotalPaid());
                    p.println();
                }
                p.close();
            } catch (Exception e){}
            System.exit(0);
        }
    }

    public void verifyAccount(String uname, String pwd){
        boolean flag = false;
        for(int i = 0; i < Oodj.staff.size(); i++){ // searches through the file for the username
            if(uname.equals(Oodj.staff.get(i).getUsername())){
                Oodj.loginAccount = Oodj.staff.get(i); // if it gets the username, it will store the logged in user's 'object' into the loginAccount variable, else 'Wrong Credentials'
                flag = true;
                break;
            } 
        }
        if(flag){ // if it got the result, next is to check the password
            if(pwd.equals(Oodj.loginAccount.getPassword())){
                accessRights();
            } else{
                if(pwd.isEmpty()){
                    JOptionPane.showMessageDialog(this, "Please enter your password!");
                } else{
                    JOptionPane.showMessageDialog(this, "Wrong password!");
                }
            }
        } else{
            JOptionPane.showMessageDialog(this, "Wrong Credentials!");
        }
    }
    
    public void accessRights(){
        loggedInUser = new JLabel("Logged in as: " + Oodj.loginAccount.getName());
        if(Oodj.loginAccount.getDepartment().equals("Manager")){
            this.setVisible(false);
            Oodj.mgrMenuGUI.add(loggedInUser);
            Oodj.mgrMenuGUI.setVisible(true);
        } else if(Oodj.loginAccount.getDepartment().equals("Technician")){
            this.setVisible(false);
            Oodj.techMenuGUI.add(loggedInUser);
            Oodj.techMenuGUI.setVisible(true);
        }
    }
}
