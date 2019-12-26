package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TechMenu extends JFrame implements ActionListener{
    
    private JButton checkSchedule;
    
    public TechMenu(){
        checkSchedule = new JButton("Check Appointment");
        checkSchedule.addActionListener(this);
        setSize(200,200);
        setLocation(200,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    
}
