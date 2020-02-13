package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import oodj.Oodj;

public class CustomerMenu extends JFrame implements ActionListener{
    
    private final JButton logout, viewAppointment;
    public final JLabel text;

    public CustomerMenu(){
        setSize(200,200);
        setLocation(300,300);
        
        viewAppointment = new JButton("View Appointments");
        viewAppointment.addActionListener(this);
        
        text = new JLabel("Welcome: User");
        
        logout = new JButton("Logout");
        logout.addActionListener(this);
        
        add(viewAppointment);
        add(logout);
        add(text);
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

    public JLabel getText() {
        return text;
    }
}
