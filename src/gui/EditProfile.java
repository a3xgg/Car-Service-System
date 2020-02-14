package gui;

import interfaces.ManageUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import oodj.Oodj;
import user.Customer;

public class EditProfile extends JFrame implements ActionListener, ManageUser{
    private JButton saveChanges, discardChanges;
    private JLabel username,name,ic,email,phone,address,department;
    
    private JTextField icTf, emailTf, phoneTf, addressTf;
    
    public EditProfile(){
        setSize(700,400);
        setLocation(200,100);
        try{
            username = new JLabel("Username: " + Oodj.toEditStaff.getUsername());
            name = new JLabel("Name: " + Oodj.toEditStaff.getName());
            icTf = new JTextField(Oodj.toEditStaff.getIcNumber());
            emailTf = new JTextField(Oodj.toEditStaff.getEmail());
            phoneTf = new JTextField(Oodj.toEditStaff.getPhoneNumber());
            addressTf = new JTextField(Oodj.toEditStaff.getMailingAddress());
            department = new JLabel("Department: " + Oodj.toEditStaff.getDepartment());
        } catch (NullPointerException e){
        }
        saveChanges = new JButton("Save changes");
        saveChanges.addActionListener(this);
        saveChanges.setBounds(50, 300, 150, 25);
        
        discardChanges = new JButton("Discard changes");
        discardChanges.addActionListener(this);
        discardChanges.setBounds(250, 300, 150, 25);
        
        username.setBounds(10,10,200,30);
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
        department.setBounds(10,210,200,30);
        
        add(username);
        add(name);
        add(ic);add(icTf);
        add(email);add(emailTf);
        add(phone);add(phoneTf);
        add(address);add(addressTf);
        add(department);
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
            Oodj.toEditStaff.setEmail(emailTf.getText());
            Oodj.toEditStaff.setIcNumber(icTf.getText());
            Oodj.toEditStaff.setMailingAddress(addressTf.getText());
            Oodj.toEditStaff.setPhoneNumber(phoneTf.getText());
            JOptionPane.showMessageDialog(this,"User updated!");
            this.setVisible(false);
        }
    }

    @Override
    public void deleteUser() {
    }

    @Override
    public void searchUser() {
    }
}
