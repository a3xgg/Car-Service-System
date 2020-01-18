package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oodj.Oodj;
import user.Staff;

public class RegisteredUser extends JFrame implements ActionListener {
    
    private String[] columnHeader = {"Name","IC","E-mail","Phone Number","Address","Department"};
    
    //TODO change this to dynamic and change string array to object array
    private JTable staffTable, customerTable;
    private JLabel staffLbl, customerLbl;
    private DefaultTableModel tableModel = new DefaultTableModel(columnHeader,0);
    
    public RegisteredUser(){
        getUserData(Oodj.staff);
        
        setSize(1500,500);
        setLocation(300,250);
        
        staffLbl = new JLabel("Staffs");
        staffTable = new JTable(tableModel);
        customerLbl = new JLabel("Customers");
        
        JScrollPane staffScrollable = new JScrollPane(staffTable);
        JScrollPane customerScrollable = new JScrollPane(customerTable);
        
        add(staffLbl);
        add(staffScrollable);
        add(customerLbl);
        add(customerScrollable);
        
        setLayout(new FlowLayout());
    }
    //can make into something like abstract class
    //find a way to get this to work
    public final void getUserData(ArrayList<Staff> staff){
        for(int i = 0;i < staff.size(); i++){
            String name = staff.get(i).getName();
            String ic = staff.get(i).getIcNumber();
            String email = staff.get(i).getEmail();
            String phone = staff.get(i).getPhoneNumber();
            String address = staff.get(i).getMailingAddress();
            String department = staff.get(i).getDepartment();
            Object[] userDetails = {name,ic,email,phone,address,department};
            
            tableModel.addColumn(userDetails);
            System.out.println(userDetails);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
