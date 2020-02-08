package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oodj.Oodj;
import user.Customer;
import user.Staff;

public class UserList extends JFrame implements ActionListener {
    private final String[][] columnHeader = {
        {"Name","IC","E-mail","Phone Number","Address","Department"},
        {"Cust ID","Name","IC","E-mail","Phone Number","Address"}};
    
    private String name, ic, email, phone, address, department;
    private int custID;
    
    private JTable staffTable, customerTable;
    private JLabel staffLbl, customerLbl;
    
    private final DefaultTableModel staffModel = new DefaultTableModel(columnHeader[0],0);
    private final DefaultTableModel customerModel = new DefaultTableModel(columnHeader[1],0);
    
    private JButton editCustomer, deleteCustomer, searchCustomer,editStaff, deleteStaff, searchStaff;
    
    private JScrollPane staffScrollable, customerScrollable;
    
    public UserList(){  
        getStaffData(Oodj.staff);
        getCustomerData(Oodj.customer);
        
        setSize(1500,500);
        setLocation(300,250);
        
        staffLbl = new JLabel("Staff");
        staffLbl.setBounds(10, 10, 100, 25);
        staffTable = new JTable(staffModel);
        
        editStaff = new JButton("Edit Staff");
        editStaff.setBounds(50, 10, 100, 25);
        deleteStaff = new JButton("Delete Staff");
        deleteStaff.setBounds(160, 10, 100, 25);
        searchStaff = new JButton("Search Staff");
        searchStaff.setBounds(280, 10, 120, 25);
        
        staffScrollable = new JScrollPane(staffTable);
        staffScrollable.setBounds(20, 50, 500, 500);
        
        customerLbl = new JLabel("Customer");
        customerLbl.setBounds(700, 10, 100, 25);
        customerTable = new JTable(customerModel);
        
        editCustomer = new JButton("Edit Customer");
        editCustomer.setBounds(800, 10, 100, 25);
        deleteCustomer = new JButton("Delete Customer");
        deleteCustomer.setBounds(920, 10, 100, 25);
        searchCustomer = new JButton("Search Customer");
        searchCustomer.setBounds(1050, 10, 140, 25);
        
        customerScrollable = new JScrollPane(customerTable);
        customerScrollable.setBounds(710, 50, 500, 500);
        
        add(staffLbl);
        add(editStaff);
        add(deleteStaff);
        add(searchStaff);
        add(staffScrollable);
        
        add(customerLbl);
        add(customerScrollable);
        add(editCustomer);
        add(deleteCustomer);
        add(searchCustomer);
        
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    public final void getStaffData(ArrayList<Staff> staff){
        for(int i = 0; i < staff.size(); i++){
            name = staff.get(i).getName();
            ic = staff.get(i).getIcNumber();
            email = staff.get(i).getEmail();
            phone = staff.get(i).getPhoneNumber();
            address = staff.get(i).getMailingAddress();
            department = staff.get(i).getDepartment();
            Object[] detail = {name,ic,email,phone,address,department};
            staffModel.addRow(detail);
        }
    }
    
    public final void getCustomerData(ArrayList<Customer> customer){
        for(int i = 0; i < customer.size(); i++){
            custID = customer.get(i).getCustID();
            name = customer.get(i).getName();
            ic = customer.get(i).getIcNumber();
            email = customer.get(i).getEmail();
            phone = customer.get(i).getPhoneNumber();
            address = customer.get(i).getMailingAddress();
            Object[] detail = {custID,name,ic,email,phone,address};
            customerModel.addRow(detail);
        }
    }
}
