package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oodj.*;

public class MgrMenu extends JFrame implements ActionListener{
    
    private UserList userGUI;
    private RegisterCustomer regCustGUI;

    private JButton registerBtn, logoutBtn, bookingBtn, registeredUser, editProfile, viewAppointment;
    private Object[] option = {"New Customer","Returning Customer"};
    
    public AppointmentBooking bookingGUI;
    
    public MgrMenu(){
        setSize(500,200);
        setLocation(200,100);
        
        viewAppointment = new JButton("View All Appointments");
        viewAppointment.addActionListener(this);
        
        registerBtn = new JButton("Staff Registration");
        registerBtn.addActionListener(this);
        
        logoutBtn = new JButton("Logout");
        logoutBtn.addActionListener(this);
        
        bookingBtn = new JButton("Appointment Booking");
        bookingBtn.addActionListener(this);
        
        registeredUser = new JButton("Registered Customer/Staff");
        registeredUser.addActionListener(this);
        
        editProfile = new JButton("Edit Profile");
        editProfile.addActionListener(this);
        
        add(bookingBtn);
        add(registerBtn);
        add(registeredUser);
        add(viewAppointment);
        add(logoutBtn);
        add(editProfile);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(0,20,20));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == bookingBtn){
            //TODO put this in a variable
            int choice = JOptionPane.showOptionDialog(this, "Book appointment for who?", "Choose option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option,option[0]);
            if(choice == JOptionPane.YES_OPTION){
                regCustGUI = new RegisterCustomer();
                regCustGUI.setVisible(true);
            } else if(choice == JOptionPane.NO_OPTION){
                this.setVisible(false);
                bookingGUI = new AppointmentBooking();
                bookingGUI.setVisible(true);
            }
        } else if(ae.getSource() == registeredUser){
            userGUI = new UserList();
            userGUI.setVisible(true);
        } else if(ae.getSource() == registerBtn){
            this.setVisible(false);
            Oodj.registerGUI.setVisible(true);
        } else if(ae.getSource() == logoutBtn){
            this.setVisible(false);
            Oodj.loginGUI.loggedInUser.setText(null); //clear the logged in user text for mgrMenu, if not previous logged in text will still show.
            Oodj.loginGUI.setVisible(true);
        } else if(ae.getSource() == editProfile){
            Profile profilePage = new Profile();
            profilePage.setVisible(true);
        } else if(ae.getSource() == viewAppointment){
            ViewAppointment va = new ViewAppointment();
            va.setVisible(true);
        }
    }
    
}
