package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import oodj.Oodj;

public class AppointmentBooking extends JFrame implements ActionListener{
    
    private String[] service = {"Normal Service", "Major Service"};
    private Object[] serviceHour = {1,3};
    
    private JLabel customerLbl, serviceTypeLbl, date, time, serviceHourLbl;
    private JComboBox allCustomer, serviceType, serviceHours;
    private JButton backBtn;
    
    public AppointmentBooking(){
        setSize(620,150);
        setLocation(200,100);
        
        customerLbl = new JLabel("Customer");
        allCustomer = new JComboBox();
        
        serviceTypeLbl = new JLabel("Service Type");
        serviceType = new JComboBox(service);
        
        serviceHourLbl = new JLabel("Service Hours");
        serviceHours = new JComboBox(serviceHour);
        
        date = new JLabel("Select Date");
        time = new JLabel("Select Time");
        
        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        
        add(customerLbl);
        add(allCustomer);
        
        add(serviceTypeLbl);
        add(serviceType);
        
        add(serviceHourLbl);
        add(serviceHours);
        
        add(date);
        add(time);
        
        add(backBtn);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(0,20,20));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == backBtn){
            this.setVisible(false);
            Oodj.mgrMenuGUI.setVisible(true);
        }   
    }
}
