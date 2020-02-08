package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oodj.*;
import user.Customer;
import interfaces.*;

public class RegisterCustomer extends JFrame implements ActionListener, Registration, PlainJTextField, Generator{
    
    private final JButton registerBtn, backBtn;
    private final JLabel name, ic, email, phoneNumber, mailingAddress;
    private final JTextField nameTf, icTf, emailTf, phoneNumberTf, mailingAddressTf;
    private Customer customerDetails;
    private AppointmentBooking bookingGUI;
    private int id;
    
    public RegisterCustomer(){
        setSize(210,570);
        setLocation(100, 200);

        name = new JLabel("Full Name: ");
        nameTf = new JTextField(15);
        
        ic = new JLabel("IC/Passport: ");
        icTf = new JTextField(15);
        
        email = new JLabel("E-mail: ");
        emailTf = new JTextField(15);
        
        phoneNumber = new JLabel("Phone No: ");
        phoneNumberTf = new JTextField(15);
        
        mailingAddress = new JLabel("Address: ");
        mailingAddressTf = new JTextField(15);
        
        registerBtn = new JButton("Register Customer");
        registerBtn.addActionListener(this);
        
        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        
        add(name);add(nameTf);
        add(ic);add(icTf);
        add(email);add(emailTf);
        add(phoneNumber);add(phoneNumberTf);
        add(mailingAddress);add(mailingAddressTf);
        add(registerBtn);add(backBtn);
        
        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == registerBtn){
            registerUser();
        } else if(ae.getSource() == backBtn){
            this.setVisible(false);
            Oodj.mgrMenuGUI.setVisible(true);
        }
    }
    @Override
    public void clearTextFields(){
        nameTf.setText(null);
        icTf.setText(null);
        emailTf.setText(null);
        phoneNumberTf.setText(null);
        mailingAddressTf.setText(null);
    }
    @Override
    public void registerUser(){
        idGenerator();
        String name = nameTf.getText();
        String ic = icTf.getText();
        String email = emailTf.getText();
        String phone = phoneNumberTf.getText();
        String address = mailingAddressTf.getText();
        if(name.isEmpty() || ic.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()){
            JOptionPane.showMessageDialog(this, "Some Fields are empty");
        } else{
            customerDetails = new Customer(id,name,ic,email,phone,address);
            Oodj.customer.add(customerDetails);
            clearTextFields();
            JOptionPane.showMessageDialog(this,"Successfully Registered Customer!");
            this.setVisible(false);
            bookingGUI = new AppointmentBooking();
            bookingGUI.setVisible(true);
        } 
    }
    @Override
    public void idGenerator(){
        if(Oodj.customer.isEmpty()){
            id = 101;
        } else{
            int size = Oodj.customer.size();
            Customer last = Oodj.customer.get(size - 1);
            id = last.getCustID() + 1;
        }
    }

    @Override
    public void receiptGenerator() {}
}
