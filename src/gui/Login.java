package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oodj.*;

public class Login extends JFrame implements ActionListener{

    private final JButton loginBtn, quitBtn;
    private final JTextField username, password;
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
            boolean flag = false;
            String uname = username.getText();
            String pwd = password.getText();
            for(int i = 0; i < Oodj.staffAccounts.size(); i++){
                if(uname.equals(Oodj.staffAccounts.get(i).getUsername())){
                    Oodj.loginAccount = Oodj.staffAccounts.get(i);
                    flag = true;
                    break;
                } 
            }
            if(flag){
                if(pwd.equals(Oodj.loginAccount.getPassword())){
                    if(Oodj.loginAccount.getStaff().getDepartment().equals("Manager")){
                        this.setVisible(false);
                        Oodj.mgrMenuGUI.setVisible(true);
                    } else if(Oodj.loginAccount.getStaff().getDepartment().equals("Technician")){
                        this.setVisible(false);
                        Oodj.techMenuGUI.setVisible(true);
                    }
                }
            } else{
                JOptionPane.showMessageDialog(this, "Wrong Credentials!");
            }
            username.setText(null);
            password.setText(null);
        } else if(ae.getSource() == quitBtn){
            /*
            The following code will execute once the technician or manager presses the quit button
            Staff details will be stored in separate folders from the Staff Account
            Staff Details will be stored in the staff.txt file
            Staff Account Details will be stored in the staffAccount.txt file
            */
            try{
                PrintWriter p = new PrintWriter("staff.txt");
                for(int i = 0; i < Oodj.staffDetails.size(); i++){
                    p.println(Oodj.staffDetails.get(i).getName());
                    p.println(Oodj.staffDetails.get(i).getIcNumber());
                    p.println(Oodj.staffDetails.get(i).getEmail());
                    p.println(Oodj.staffDetails.get(i).getPhoneNumber());
                    p.println(Oodj.staffDetails.get(i).getMailingAddress());
                    p.println(Oodj.staffDetails.get(i).getDepartment());
                    p.println();
                }
                p.close();
                PrintWriter p2 = new PrintWriter("staffAccount.txt");
                for(int i = 0; i < Oodj.staffAccounts.size(); i++){
                    p2.println(Oodj.staffAccounts.get(i).getUsername());
                    p2.println(Oodj.staffAccounts.get(i).getPassword());
                    p2.println(Oodj.staffAccounts.get(i).getStaff().getName());
                    p2.println();
                }
                p2.close();
                System.exit(0);
            } catch(Exception e){}
        }
    }
}
