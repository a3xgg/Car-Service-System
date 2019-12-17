package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import oodj.*;

public class MgrMenu extends JFrame implements ActionListener{
    
    private JButton registerBtn, logoutBtn, customerBtn;
    
    
    public MgrMenu(){
        setSize(300,100);
        setLocation(200,100);
        
        registerBtn = new JButton("Staff Registration");
        registerBtn.addActionListener(this);
        
        logoutBtn = new JButton("Logout");
        logoutBtn.addActionListener(this);
        
        customerBtn = new JButton("Customer Registration");
        customerBtn.addActionListener(this);
        
        add(customerBtn);
        add(registerBtn);
        add(logoutBtn);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(0,20,20));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == registerBtn){
            this.setVisible(false);
            Oodj.registerGUI.setVisible(true);
        } else if(ae.getSource() == logoutBtn){
            this.setVisible(false);
            Oodj.loginGUI.setVisible(true);
        }
    }
}
