package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oodj.*;
import user.Appointment;
import user.Technician;

public class TechMenu extends JFrame implements ActionListener{
    
    private final JButton checkSchedule, logout, editProfile, collectPayment;
    private ViewAppointment va;
    private Technician t;
    
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
        } else if(ae.getSource() == collectPayment){
            try{
                String appointmentID = JOptionPane.showInputDialog(this, "Appointment ID");
                int appID = Integer.parseInt(appointmentID);
                boolean found = false;
                for(int i = 0; i < Oodj.technician.size(); i++){
                    if(Oodj.loginAccount.getUsername().equals(Oodj.technician.get(i).getUsername())){
                        t = Oodj.technician.get(i);
                        break;
                    }
                }
                for(int i = 0; i < t.getAppointment().size(); i++){
                    Appointment app = t.getAppointment().get(i);
                    if(appID == app.getAppointmentID()){
                        Oodj.aptPayment = app;
                        found = true;
                        break;
                    }
                }
                if(found){
                    if(validateIfCompleted(Oodj.aptPayment)){
                        JOptionPane.showMessageDialog(this, "Sorry that appointment is completed.");
                    }else {
                        String charge = JOptionPane.showInputDialog(this, "Enter Charges");
                        int charges = Integer.parseInt(charge);
                        Oodj.paymentGUI.setRemainder(charges);
                        Oodj.paymentGUI.getLabel().setText(Oodj.aptPayment.getCustomer().getName() + ", your charge is RM" + charges);
                        Oodj.aptPayment.setCharge(charges);
                        this.setVisible(false);
                        Oodj.paymentGUI.setVisible(true);
                    }
                } else{
                   JOptionPane.showMessageDialog(this, "Wrong AppointmentID!");
                }
            } catch(Exception e){
                System.out.println("Operation cancelled");
            }
        }  
    }
    
    public boolean validateIfCompleted(Appointment appointment){
        if(Oodj.aptPayment.getAppointmentStatus().equals("Completed")){
            return true;
        }
        return false;
    }
}
