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

public class RegisterCustomer extends JFrame implements ActionListener{
    
    private JButton registerBtn, backBtn;
    private JLabel nameLbl, icLbl, emailLbl, phoneNumberLbl, mailingAddressLbl;
    private JTextField nameTf, icTf, emailTf, phoneNumberTf, mailingAddressTf;
    private Customer customerDetails;
    private AppointmentBooking bookingGUI;
    
    public RegisterCustomer(){
        setSize(210,570);
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
        
        registerBtn = new JButton("Register Customer");
        registerBtn.addActionListener(this);
        
        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        
        add(nameLbl);add(nameTf);
        add(icLbl);add(icTf);
        add(emailLbl);add(emailTf);
        add(phoneNumberLbl);add(phoneNumberTf);
        add(mailingAddressLbl);add(mailingAddressTf);
        add(registerBtn);add(backBtn);
        
        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == registerBtn){
            registerCustomer();
        } else if(ae.getSource() == backBtn){
            this.setVisible(false);
            Oodj.mgrMenuGUI.setVisible(true);
        }
    }  
    
    public void clearFields(){
        nameTf.setText(null);
        icTf.setText(null);
        emailTf.setText(null);
        phoneNumberTf.setText(null);
        mailingAddressTf.setText(null);
    }
    
    public void registerCustomer(){
        int id;
        if(Oodj.customer.isEmpty()){
            id = 101;
        } else{
            int size = Oodj.customer.size();
            Customer last = Oodj.customer.get(size - 1);
            id = last.getCustID() + 1;
        }
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
            clearFields();
            JOptionPane.showMessageDialog(this,"Successfully Registered Customer!");
            this.setVisible(false);
            bookingGUI = new AppointmentBooking();
            bookingGUI.setVisible(true);
        } 
    }
}
