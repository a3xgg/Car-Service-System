package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import oodj.*;

public class Login extends JFrame implements ActionListener{

    private final JButton loginBtn, quitBtn;
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
        
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener(this);

        add(usrlbl);add(username);add(passlbl);add(password);add(loginBtn);add(quitBtn);
        
        setVisible(true);
        setLayout(new FlowLayout());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == loginBtn){
            username.setText(null);
            password.setText(null);
            this.setVisible(false);
            Oodj.registerGUI.setVisible(true);
        } else if(ae.getSource() == quitBtn){
            try{
                PrintWriter p = new PrintWriter("staff.txt");
                for(int i = 0; i < Oodj.allUser.size(); i++){
                    p.println(Oodj.allUser.get(i).getUsername());
                    p.println(Oodj.allUser.get(i).getPassword());
                    p.println(Oodj.allUser.get(i).getName());
                    p.println(Oodj.allUser.get(i).getIcNumber());
                    p.println(Oodj.allUser.get(i).getEmail());
                    p.println(Oodj.allUser.get(i).getPhoneNumber());
                    p.println(Oodj.allUser.get(i).getMailingAddress());
                    p.println(Oodj.allUser.get(i).getDepartment());
                    p.println();
                }
                p.close();
                System.exit(0);
            } catch(Exception e){}
        }
    }
}
