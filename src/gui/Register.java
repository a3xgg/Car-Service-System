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
import user.Staff;

public class Register extends JFrame implements ActionListener {
    
    private Staff staffAccount;
    private JButton registerBtn, backBtn;
    private JLabel nameLbl, icLbl, emailLbl, phoneNumberLbl, mailingAddressLbl, usernameLbl, passwordLbl;
    private JTextField nameTf, icTf, emailTf, phoneNumberTf, mailingAddressTf, usernameTf, passwordTf;
    private JRadioButton mgr, tech;
    private ButtonGroup bg;
    
    public Register(){
        setSize(210,510);
        setLocation(100, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        usernameLbl = new JLabel("Username: ");
        usernameTf = new JTextField(15);
        
        passwordLbl = new JLabel("Password: ");
        passwordTf = new JTextField(15);
        
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
        mgr = new JRadioButton("Manager");
        tech = new JRadioButton("Technician");
        
        registerBtn = new JButton("Register");
        registerBtn.addActionListener(this);
        
        add(usernameLbl);add(usernameTf);
        add(passwordLbl);add(passwordTf);
        add(nameLbl);add(nameTf);
        add(icLbl);add(icTf);
        add(emailLbl);add(emailTf);
        add(phoneNumberLbl);add(phoneNumberTf);
        add(mailingAddressLbl);add(mailingAddressTf);
        bg.add(mgr);bg.add(tech);
        add(mgr);add(tech);
        add(registerBtn);add(backBtn);
        
        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //Back button cancels all inputted information and goes back to manager menu
        if(ae.getSource() == backBtn){
            this.setVisible(false);
            Oodj.mgrMenuGUI.setVisible(true);
            nameTf.setText(null);
            icTf.setText(null);
            emailTf.setText(null);
            phoneNumberTf.setText(null);
            mailingAddressTf.setText(null);
        } else if(ae.getSource() == registerBtn){
            String username = usernameTf.getText();
            String password = passwordTf.getText();
            String name = nameTf.getText();
            String ic = icTf.getText();
            String email = emailTf.getText();
            String phoneNumber = phoneNumberTf.getText();
            String address = mailingAddressTf.getText();
            String role = null;
            if(username.isEmpty() || password.isEmpty() || name.isEmpty() || ic.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()){
                System.out.println("Some fields are empty!");
            } else{
                if(mgr.isSelected()){
                    role = mgr.getText();
                } else if(tech.isSelected()){
                    role = tech.getText();
                }
                staffAccount = new Staff(username,password,name,ic,email,phoneNumber,address,role);
                Oodj.allUser.add(staffAccount);
            }
        }
    }
    
}
