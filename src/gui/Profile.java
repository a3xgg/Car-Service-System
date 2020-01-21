package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import oodj.Oodj;

public class Profile extends JFrame implements ActionListener{
    
    private JButton saveChanges, discardChanges;
    private JLabel username,password,name,ic,email,phone,address,department;
    private JTextField nameTf;

    public Profile(){
        setSize(500,150);
        setLocation(200,100);
        
        saveChanges = new JButton("Save changes");
        saveChanges.addActionListener(this);
        
        discardChanges = new JButton("Discard changes");
        discardChanges.addActionListener(this);
        
        name = new JLabel("Name: ");
        nameTf = new JTextField(Oodj.loginAccount.getName());
        
        username = new JLabel("Username: " + Oodj.loginAccount.getUsername());
        password = new JLabel("Password: " + Oodj.loginAccount.getPassword());
        ic = new JLabel("IC number: " + Oodj.loginAccount.getIcNumber());
        email = new JLabel("E-mail: ");
        phone = new JLabel("Phone: ");
        address = new JLabel("Address: ");
        department = new JLabel("Department: " + Oodj.loginAccount.getDepartment());
        add(username);
        add(password);
        add(name);
        add(nameTf);
        add(ic);
        add(email);
        add(phone);
        add(address);
        add(department);
        
        
        add(saveChanges);
        add(discardChanges);
        
        setLayout(new FlowLayout());
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == saveChanges){
            
        } else if(ae.getSource() == discardChanges){
            this.setVisible(false);
        }
    }
    
}
