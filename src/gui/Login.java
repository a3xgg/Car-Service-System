package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import oodj.*;
import user.Role;

public class Login extends JFrame implements ActionListener{

    private final JButton loginBtn,signUpBtn;
    private JTextField username, password;
    private final JLabel usrlbl, passlbl;

    public Login(){
        setSize(300,140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100,200);
        //username label
        usrlbl = new JLabel("Username: ");
        //username textfield
        username = new JTextField(15);
        //password label
        passlbl = new JLabel("Password: ");
        //password textfield
        password = new JTextField(15);

        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        signUpBtn = new JButton("Sign Up");
        signUpBtn.addActionListener(this);

        add(usrlbl);add(username);add(passlbl);add(password);add(loginBtn);add(signUpBtn);
        
        setVisible(true);
        setLayout(new FlowLayout());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == signUpBtn){
            this.setVisible(false);
            Oodj.registerGUI.setVisible(true);
        } else if(ae.getSource() == loginBtn){
            String user,pass;
            user = username.getText().toString();
            pass = password.getText().toString();
            if(user.equals("admin")){
                if(pass.equals("foobar")){
                    
                }
            } else{
                
            }
        }
    }
    
    
}
