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

public class UserList extends JFrame implements ActionListener {
    private final String[][] columnHeader = {
        {"Name","IC","E-mail","Phone Number","Address","Department"},
        {"Cust ID","Name","IC","E-mail","Phone Number","Address"}};
    
    private String name, ic, email, phone, address, department;
    
    private JTable staffTable, customerTable;
    private JLabel staffLbl, customerLbl;
    
    private DefaultTableModel staffModel = new DefaultTableModel(columnHeader[0],0);
    private DefaultTableModel customerModel = new DefaultTableModel(columnHeader[1],25);
    
    public UserList(){  
        getUserData(Oodj.staff);
        setSize(1500,500);
        setLocation(300,250);
        
        staffLbl = new JLabel("Staff");
        staffTable = new JTable(staffModel);
        
        JScrollPane staffScrollable = new JScrollPane(staffTable);
        
        add(staffLbl);
        add(staffScrollable);
        
        setLayout(new FlowLayout());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    public void getUserData(ArrayList<Staff> staff){
        for(int i = 0; i < staff.size(); i++){
            name = staff.get(i).getName();
            ic = staff.get(i).getIcNumber();
            email = staff.get(i).getEmail();
            phone = staff.get(i).getPhoneNumber();
            address = staff.get(i).getMailingAddress();
            department = staff.get(i).getDepartment();
            Object[] detail = {name,ic,email,phone,address,department};
            System.out.println(detail);
            staffModel.addRow(detail);
        }
    }
}
