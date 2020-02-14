package gui;

import interfaces.ManageUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oodj.Oodj;

public class EditCustomer extends JFrame implements ActionListener, ManageUser{
    private JButton saveChanges, discardChanges;
    private JLabel name,ic,email,phone,address;
    
    private JTextField  icTf, emailTf, phoneTf, addressTf;

    public EditCustomer(){
        setSize(700,400);
        setLocation(200,100);
        try{
            name = new JLabel("Name: " + Oodj.toEditCustomer.getName());
            icTf = new JTextField(Oodj.toEditCustomer.getIcNumber());
            emailTf = new JTextField(Oodj.toEditCustomer.getEmail());
            phoneTf = new JTextField(Oodj.toEditCustomer.getPhoneNumber());
            addressTf = new JTextField(Oodj.toEditCustomer.getMailingAddress());
        } catch (NullPointerException e){
        }
        saveChanges = new JButton("Save changes");
        saveChanges.addActionListener(this);
        saveChanges.setBounds(50, 300, 150, 25);
        
        discardChanges = new JButton("Discard changes");
        discardChanges.addActionListener(this);
        discardChanges.setBounds(250, 300, 150, 25);
        
       
        name.setBounds(10,70,200,30);
        
        ic = new JLabel("IC number: ");
        ic.setBounds(10,100,200,30);
        icTf.setBounds(90,100,200,25);
        email = new JLabel("E-mail: ");
        email.setBounds(10,130,200,30);
        emailTf.setBounds(90,130,200,25);
        phone = new JLabel("Phone: ");
        phone.setBounds(10,160,200,30);
        phoneTf.setBounds(90,160,200,25);
        address = new JLabel("Address: ");
        address.setBounds(10,190,200,30);
        addressTf.setBounds(90,190,200,25);
        
        add(name);
        add(ic);add(icTf);
        add(email);add(emailTf);
        add(phone);add(phoneTf);
        add(address);add(addressTf);
        add(saveChanges);
        add(discardChanges);
        
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == discardChanges){
            this.setVisible(false);
        } else if(ae.getSource() == saveChanges){
            editUser();
        }
    }

    @Override
    public void editUser() {
        if(icTf.getText().isEmpty() || emailTf.getText().isEmpty() || addressTf.getText().isEmpty() || phoneTf.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Some fields are empty!");
        } else{
            Oodj.toEditCustomer.setIcNumber(icTf.getText());
            Oodj.toEditCustomer.setEmail(emailTf.getText());
            Oodj.toEditCustomer.setMailingAddress(addressTf.getText());
            Oodj.toEditCustomer.setPhoneNumber(phoneTf.getText());
            JOptionPane.showMessageDialog(this,"User updated!");
            this.setVisible(false);
        }
    }

    @Override
    public void deleteUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void searchUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
