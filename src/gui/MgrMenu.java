package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import oodj.*;

public class MgrMenu extends JFrame implements ActionListener{
    
    private JButton registerBtn, logoutBtn;
    
    
    public MgrMenu(){
        setSize(100,100);
        setLocation(200,100);
        
        registerBtn = new JButton("Register");
        registerBtn.addActionListener(this);
        
        logoutBtn = new JButton("Logout");
        logoutBtn.addActionListener(this);
        
        add(registerBtn);
        add(logoutBtn);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
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
