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

public class Login extends JFrame implements ActionListener{

    private final JButton loginBtn;
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

        add(usrlbl);add(username);add(passlbl);add(password);add(loginBtn);
        
        setVisible(true);
        setLayout(new FlowLayout());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == loginBtn){
            if(username.getText().equals("manager")){
                if(password.getText().equals("foobar")){
                    this.setVisible(false);
                    username.setText(null);
                    password.setText(null);
                    Oodj.mgrMenuGUI.setVisible(true);
                }
            } else if(username.getText().equals("Technician")){
                if(password.getText().equals("techpass")){
                    username.setText(null);
                    password.setText(null);
                    this.setVisible(false);
                    Oodj.techMenuGUI.setVisible(true);
                }
            } else{
                JOptionPane.showMessageDialog(this, "Wrong username!");
            }
        }
    }
    
    
}
