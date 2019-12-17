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

public class Register extends JFrame implements ActionListener {
    
    private JButton registerBtn, backBtn;
    private JLabel nameLbl, icLbl, emailLbl, phoneNumberLbl, mailingAddressLbl;
    private JTextField nameTf, icTf, emailTf, phoneNumberTf, mailingAddressTf;
    private JRadioButton cust, mgr, tech;
    private ButtonGroup bg;
    
    public Register(){
        setSize(200,500);
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
        
        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        
        bg = new ButtonGroup();
        cust = new JRadioButton("Customer");
        mgr = new JRadioButton("Manager");
        tech = new JRadioButton("Technician");
        
        registerBtn = new JButton("Register");
        registerBtn.addActionListener(this);
        
        add(nameLbl);add(nameTf);
        add(icLbl);add(icTf);
        add(emailLbl);add(emailTf);
        add(phoneNumberLbl);add(phoneNumberTf);
        add(mailingAddressLbl);add(mailingAddressTf);
        bg.add(cust);bg.add(mgr);bg.add(tech);
        add(cust);add(mgr);add(tech);
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
            String role;
            String name = nameTf.getText();
            String ic = icTf.getText();
            
            if(cust.isSelected()){
                role = cust.getText();
            } else if(mgr.isSelected()){
                role = mgr.getText();
            } else if(tech.isSelected()){
                role = tech.getText();
            }
            //Person p = new Person(name,email,phoneNumber);
            //Oodj.allUser.add(p);
        }
    }
    
}
