package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oodj.*;

public class MgrMenu extends JFrame implements ActionListener{
    
    private JButton registerBtn, logoutBtn, bookingBtn;
    private String[] option = {"New Customer","Returning Customer"};
    
    
    public MgrMenu(){
        setSize(500,150);
        setLocation(200,100);
        
        registerBtn = new JButton("Staff Registration");
        registerBtn.addActionListener(this);
        
        logoutBtn = new JButton("Logout");
        logoutBtn.addActionListener(this);
        
        bookingBtn = new JButton("Appointment Booking");
        bookingBtn.addActionListener(this);
        
        add(bookingBtn);
        add(registerBtn);
        add(logoutBtn);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(0,20,20));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == bookingBtn){
            //TODO put this in a variable
            JOptionPane.showOptionDialog(this, "Book appointment for who?", "Choose option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        } else if(ae.getSource() == registerBtn){
            this.setVisible(false);
            Oodj.registerGUI.setVisible(true);
        } else if(ae.getSource() == logoutBtn){
            this.setVisible(false);
            Oodj.loginGUI.loggedInUser.setText(null); //clear the logged in user text for mgrMenu, if not previous logged in text will still show.
            Oodj.loginGUI.setVisible(true);
        }
    }
}
