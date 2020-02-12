package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oodj.Oodj;
import static oodj.Oodj.customer;
import user.Appointment;
import user.Customer;

public class CustomerMenu extends JFrame implements ActionListener{
    
    private JButton logout, viewAppointment;

    public CustomerMenu(){
        setSize(200,200);
        setLocation(300,300);
        
        viewAppointment = new JButton("View Appointments");
        viewAppointment.addActionListener(this);
        
        logout = new JButton("Logout");
        logout.addActionListener(this);
        
        add(viewAppointment);
        add(logout);
        setLayout(new FlowLayout());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == logout){
            this.setVisible(false);
            Oodj.loginGUI.setVisible(true);
        } else if(ae.getSource() == viewAppointment){
            ViewAppointment va = new ViewAppointment();
            va.setVisible(true);
        }
    }
}
