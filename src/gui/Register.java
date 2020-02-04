package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import oodj.*;
import user.*;

public class Register extends JFrame implements ActionListener {
    
    private Staff staffAccountDetails;
    private JButton registerBtn, backBtn;
    private JPasswordField pwdField,retypePwdField;
    private JLabel nameLbl, icLbl, emailLbl, phoneNumberLbl, mailingAddressLbl, usernameLbl, passwordLbl, retypePwdLbl;
    private JTextField nameTf, icTf, emailTf, phoneNumberTf, mailingAddressTf, usernameTf;
    private JRadioButton mgr, tech;
    private ButtonGroup bg;
    private String password,retypepw, username;
    private boolean flag = false;
    public Register(){
        setSize(210,570);
        setLocation(100, 200);
        
        usernameLbl = new JLabel("Username: ");
        usernameTf = new JTextField(15);
        
        passwordLbl = new JLabel("Password: ");
        pwdField = new JPasswordField(15);
        
        retypePwdLbl = new JLabel("Re-type PW: ");
        retypePwdField = new JPasswordField(15);
        
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
        
        //adds radio into a button group
        bg = new ButtonGroup();
        mgr = new JRadioButton("Manager");
        tech = new JRadioButton("Technician");
        
        registerBtn = new JButton("Register");
        registerBtn.addActionListener(this);
        
        add(usernameLbl);add(usernameTf);
        add(passwordLbl);add(pwdField);
        add(retypePwdLbl);add(retypePwdField);
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
            
            username = usernameTf.getText();
            //checks whether username exist, if yes 'Username Taken' else continue;
            checkDuplicateUsername(username);
            if(flag){
                JOptionPane.showMessageDialog(this, "Username is taken");
                flag = false;
            } else{
                password = new String(pwdField.getPassword());
                retypepw = new String(retypePwdField.getPassword());
                verifyPassword(password,retypepw);
                registerStaff();
            }
        }
    }
    
    public void clearFields(){
        usernameTf.setText(null);
        pwdField.setText(null);
        retypePwdField.setText(null);
        nameTf.setText(null);
        icTf.setText(null);
        emailTf.setText(null);
        phoneNumberTf.setText(null);
        mailingAddressTf.setText(null);
        mgr.setSelected(false);
        tech.setSelected(false);
        bg.clearSelection();
    }
    
    public void checkDuplicateUsername(String username){
        for(int i = 0; i < Oodj.staff.size(); i++){
            if(username.equals(Oodj.staff.get(i).getUsername())){
                flag = true;
                break;
            }
        }
    }
    
    public void verifyPassword(String password, String retypePassword){
        if(!(password.equals(retypepw))){
            JOptionPane.showMessageDialog(this, "Password does not match!");
            pwdField.setText(null);
            retypePwdField.setText(null);
        }
    }
    
    public void registerStaff(){
        String name = nameTf.getText();
        String ic = icTf.getText();
        String email = emailTf.getText();
        String phoneNumber = phoneNumberTf.getText();
        String address = mailingAddressTf.getText();
        String role = null;
        if(username.isEmpty() || password.isEmpty() || retypepw.isEmpty() || name.isEmpty() || ic.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()){
            //checks whether there are some fields that are left empty
            JOptionPane.showMessageDialog(this, "Some fields are empty!");
        } else{
            if(mgr.isSelected()){
                role = mgr.getText();
            } else if(tech.isSelected()){
                role = tech.getText();
            }
            staffAccountDetails = new Staff(username, password,name,ic,email,phoneNumber,address,role);
            Oodj.staff.add(staffAccountDetails);
            JOptionPane.showMessageDialog(this, "Account successfully created!");
            clearFields();
            this.setVisible(false);
            Oodj.mgrMenuGUI.setVisible(true);
        }
    }
}
