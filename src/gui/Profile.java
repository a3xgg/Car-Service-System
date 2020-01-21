package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import oodj.Oodj;

public class Profile extends JFrame implements ActionListener{
    
    private JButton saveChanges, discardChanges;
    private JLabel username,password,name,ic,email,phone,address,department;
    
    private JTextField usernameTf, icTf, emailTf, phoneTf, addressTf;
    private JPasswordField passwordTf;

    public Profile(){
        setSize(500,500);
        setLocation(200,100);

        saveChanges = new JButton("Save changes");
        saveChanges.addActionListener(this);
        saveChanges.setBounds(50, 300, 150, 25);
        
        discardChanges = new JButton("Discard changes");
        discardChanges.addActionListener(this);
        discardChanges.setBounds(250, 300, 150, 25);
        
        username = new JLabel("Username: ");
        username.setBounds(10,10,200,30);
        
        usernameTf = new JTextField(Oodj.loginAccount.getUsername());
        usernameTf.setBounds(90, 10, 200, 25);
        
        
        password = new JLabel("Password: ");
        password.setBounds(10, 40, 200, 30);
        
        passwordTf = new JPasswordField(Oodj.loginAccount.getPassword());
        passwordTf.setBounds(90, 40, 200, 25);
        
        name = new JLabel("Name: " + Oodj.loginAccount.getName());
        name.setBounds(10,70,200,30);
        
        ic = new JLabel("IC number: ");
        ic.setBounds(10,100,200,30);
        
        icTf = new JTextField(Oodj.loginAccount.getIcNumber());
        icTf.setBounds(90,100,200,25);
        
        email = new JLabel("E-mail: ");
        email.setBounds(10,130,200,30);
        
        emailTf = new JTextField(Oodj.loginAccount.getEmail());
        emailTf.setBounds(90,130,200,25);
        
        phone = new JLabel("Phone: ");
        phone.setBounds(10,160,200,30);
        
        phoneTf = new JTextField(Oodj.loginAccount.getPhoneNumber());
        phoneTf.setBounds(90,160,200,25);
        
        address = new JLabel("Address: ");
        address.setBounds(10,190,200,30);
        
        addressTf = new JTextField(Oodj.loginAccount.getMailingAddress());
        addressTf.setBounds(90,190,200,25);
        
        department = new JLabel("Department: " + Oodj.loginAccount.getDepartment());
        department.setBounds(10,210,200,30);
        
        add(username);add(usernameTf);
        add(password);add(passwordTf);
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
        if(ae.getSource() == saveChanges){
            Oodj.loginAccount.setEmail(emailTf.getText());
        } else if(ae.getSource() == discardChanges){
            this.setVisible(false);
        }
    }
    
}
