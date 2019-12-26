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
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener{
    
    private final JButton loginBtn, quitBtn;
    private final JTextField username;
    private final JPasswordField password;
    private final JLabel usrlbl, passlbl;
    public JLabel loggedInUser;

    public Login(){

        setSize(300,140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100,200);
        //username label
        usrlbl = new JLabel("Username: ");
        //username textfield
        username = new JTextField(15);
        username.addActionListener(this);
        //password label
        passlbl = new JLabel("Password: ");
        //password textfield
        password = new JPasswordField(15);
        password.addActionListener(this);
        

        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener(this);

        add(usrlbl);add(username);add(passlbl);add(password);//add(password1);
        add(loginBtn);add(quitBtn);
        
        setVisible(true);
        setLayout(new FlowLayout());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        /*
        Login button and pressing the ENTER button will invoke the action to login.
        if no username and password is entered, program will show 'Wrong Credentials'
        if wrong username and password is entered, program will show 'Wrong Credentials'
        */
        if(ae.getSource() == loginBtn || ae.getSource() == username || ae.getSource() == password){
            boolean flag = false;
            String uname = username.getText();
            String pwd = new String(password.getPassword());
            for(int i = 0; i < Oodj.staffAccounts.size(); i++){ // searches through the file for the username
                if(uname.equals(Oodj.staffAccounts.get(i).getUsername())){
                    Oodj.loginAccount = Oodj.staffAccounts.get(i); // if it gets the username, it will store the logged in user's 'object' into the loginAccount variable, else 'Wrong Credentials'
                    flag = true;
                    break;
                } 
            }
            if(flag){ // if it got the result, next is to check the password
                if(pwd.equals(Oodj.loginAccount.getPassword())){
                    loggedInUser = new JLabel("Logged in as: " + Oodj.loginAccount.getStaff().getName());
                    if(Oodj.loginAccount.getStaff().getDepartment().equals("Manager")){
                        this.setVisible(false);
                        Oodj.mgrMenuGUI.add(loggedInUser);
                        Oodj.mgrMenuGUI.setVisible(true);
                    } else if(Oodj.loginAccount.getStaff().getDepartment().equals("Technician")){
                        this.setVisible(false);
                        Oodj.techMenuGUI.add(loggedInUser);
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
