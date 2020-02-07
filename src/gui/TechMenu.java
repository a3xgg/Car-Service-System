package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import oodj.*;

public class TechMenu extends JFrame implements ActionListener{
    
    private JButton checkSchedule, logout, editProfile, collectPayment;
    private ViewAppointment va;
    
    public TechMenu(){
        
        checkSchedule = new JButton("Check Appointment");
        checkSchedule.addActionListener(this);
        
        logout = new JButton("Logout");
        logout.addActionListener(this);
        
        editProfile = new JButton("Edit Profile");
        editProfile.addActionListener(this);
        
        collectPayment = new JButton("Collect Payment");
        collectPayment.addActionListener(this);

        add(checkSchedule);
        add(collectPayment);
        add(logout);
        add(editProfile);
        
        setSize(200,200);
        setLocation(200,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == checkSchedule){
            va = new ViewAppointment();
            va.setVisible(true);
        } else if(ae.getSource() == logout){
            this.setVisible(false);
            Oodj.loginGUI.loggedInUser.setText(null); //clear the logged in user text for techmenu, if not previous logged in text will still show.
            Oodj.loginGUI.setVisible(true);
        } else if(ae.getSource() == editProfile){
            Profile profilePage = new Profile();
            profilePage.setVisible(true);
        }
    }  
}
