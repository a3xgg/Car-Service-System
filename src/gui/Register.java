package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import oodj.*;
import user.Person;

public class Register extends JFrame implements ActionListener {
    
    private JButton registerBtn, backBtn;
    private JLabel nameLbl, icLbl, emailLbl, phoneNumberLbl, mailingAddressLbl, deptLbl;
    private JTextField nameTf, icTf, emailTf, phoneNumberTf, mailingAddressTf;
    private JRadioButton mgr, tech;
    private ButtonGroup bg;
    
    public Register(){
        setSize(210,500);
        setLocation(100, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        nameLbl = new JLabel("Full Name: ");
        nameTf = new JTextField(15);
        
        icLbl = new JLabel("IC/Passport: ");
        icTf = new JTextField(15);
        
        emailLbl = new JLabel("E-mail: ");
        emailTf = new JTextField(15);
        
        phoneNumberLbl = new JLabel("Phone No: ");
        phoneNumberTf = new JTextField(15);
        
        mailingAddressLbl = new JLabel("Address: ");
        mailingAddressTf = new JTextField(15);
        
        deptLbl = new JLabel();
        
        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        
        bg = new ButtonGroup();
        mgr = new JRadioButton("Manager");
        tech = new JRadioButton("Technician");
        
        registerBtn = new JButton("Register");
        registerBtn.addActionListener(this);
        
        add(nameLbl);add(nameTf);
        add(icLbl);add(icTf);
        add(emailLbl);add(emailTf);
        add(phoneNumberLbl);add(phoneNumberTf);
        add(mailingAddressLbl);add(mailingAddressTf);
        bg.add(mgr);bg.add(tech);
        add(deptLbl);add(mgr);add(tech);
        add(registerBtn);add(backBtn);
        
        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == backBtn){
            this.setVisible(false);
            Oodj.loginGUI.setVisible(true);
        } else if(ae.getSource() == registerBtn){
            
            String name = nameTf.getText();
            String ic = icTf.getText();
            String email = emailTf.getText();
            String phoneNumber = phoneNumberTf.getText();
            String address = mailingAddressTf.getText();
            String role = null;
            if(mgr.isSelected()){
                role = mgr.getText();
            } else if(tech.isSelected()){
                role = tech.getText();
            }
            Person p = new Person(name, ic, email, phoneNumber, address, role);
            Oodj.allUser.add(p);
        }
    }
    
}
