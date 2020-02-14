package gui;

import interfaces.ManageUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oodj.Oodj;
import user.Customer;
import user.Staff;

public class UserList extends JFrame implements ActionListener, ManageUser {
    private final String[][] columnHeader = {
        {"Staff ID","Name","IC","E-mail","Phone Number","Address","Department"},
        {"Cust ID","Name","IC","E-mail","Phone Number","Address"}};
    
    private String name, ic, email, phone, address, department, icNumber;
    private int custID,staffID;
    
    private JTable staffTable, customerTable;
    private JLabel staffLbl, customerLbl;
    
    private final DefaultTableModel staffModel = new DefaultTableModel(columnHeader[0],0);
    private final DefaultTableModel customerModel = new DefaultTableModel(columnHeader[1],0);
    
    private JButton edit, delete, search;
    
    private JScrollPane staffScrollable, customerScrollable;
    private int x;
    
    public UserList(){  
        getStaffData(Oodj.staff);
        getCustomerData(Oodj.customer);
        
        setSize(1500,500);
        setLocation(300,250);
        
        staffLbl = new JLabel("Staff");
        staffLbl.setBounds(10, 10, 100, 25);
        staffTable = new JTable(staffModel);
        
        staffScrollable = new JScrollPane(staffTable);
        staffScrollable.setBounds(20, 50, 500, 500);
        
        customerLbl = new JLabel("Customer");
        customerLbl.setBounds(1000, 10, 100, 25);
        customerTable = new JTable(customerModel);
        
        edit = new JButton("Edit");
        edit.setBounds(500, 10, 100, 25);
        edit.addActionListener(this);
        delete = new JButton("Delete");
        delete.addActionListener(this);
        delete.setBounds(620, 10, 100, 25);
        search = new JButton("Search");
        search.setBounds(750, 10, 140, 25);
        search.addActionListener(this);
        
        customerScrollable = new JScrollPane(customerTable);
        customerScrollable.setBounds(710, 50, 500, 500);
        
        add(edit);
        add(delete);
        add(search);
        
        add(staffLbl);
        add(staffScrollable);
        
        add(customerLbl);
        add(customerScrollable);
        
        
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == delete){
            try{
                x = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter ID to delete"));
                deleteUser();
            } catch(Exception e){
                System.out.println("Operation Cancelled");
            }
            
        } else if(ae.getSource() == edit){
            try{
                x = Integer.parseInt(JOptionPane.showInputDialog(this,"Enter ID to edit"));
                editUser();
            } catch (RuntimeException e){
                System.out.println("Operation Cancelled");
            }
        } else if(ae.getSource() == search){
            try{
                icNumber = JOptionPane.showInputDialog(this,"Enter IC number to find");
                searchUser();
            } catch (RuntimeException e){
                System.out.println("Operation Cancelled");
            }
        }
    }
    
    public final void getStaffData(ArrayList<Staff> staff){
        for(int i = 0; i < staff.size(); i++){
            staffID = staff.get(i).getStaffID();
            name = staff.get(i).getName();
            ic = staff.get(i).getIcNumber();
            email = staff.get(i).getEmail();
            phone = staff.get(i).getPhoneNumber();
            address = staff.get(i).getMailingAddress();
            department = staff.get(i).getDepartment();
            Object[] detail = {staffID,name,ic,email,phone,address,department};
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

    @Override
    public void editUser() {
        boolean flag = false;
        for(int i = 0; i < Oodj.staff.size(); i++){
            if(x == Oodj.staff.get(i).getStaffID()){
                flag = true;
                Oodj.toEditStaff = Oodj.staff.get(i);
                break;
            }
        }
        if(flag == true){
            EditProfile ep = new EditProfile();
            ep.setVisible(true);
            //show edit gui
        } else{
            for(int i = 0; i < Oodj.customer.size(); i++){
                if(x == Oodj.customer.get(i).getCustID()){
                    flag = true;
                    Oodj.toEditCustomer = Oodj.customer.get(i);
                    break;
                }
            }
            if(flag == true){
                EditCustomer ec = new EditCustomer();
                ec.setVisible(true);
            } else{
                JOptionPane.showMessageDialog(this, "No user found");
            }
        }
    }

    @Override
    public void deleteUser() {
        boolean flag = false;
        Customer c = null;
        Staff s = null;
        for(int i = 0; i < Oodj.staff.size(); i++){
            if(x == Oodj.staff.get(i).getStaffID()){
                s = Oodj.staff.get(i);
                Oodj.staff.remove(s);
                staffModel.removeRow(i);
                flag = true;
                break;
            }
        }
        if(flag){
            JOptionPane.showMessageDialog(this, "Staff has been deleted");
        } else{
            for(int i = 0; i < Oodj.customer.size(); i++){
                if(x == Oodj.customer.get(i).getCustID()){
                    c = Oodj.customer.get(i);
                    Oodj.customer.remove(c);
                    customerModel.removeRow(i);
                    flag = true;
                    break;
                }
            }
            if(flag){
                JOptionPane.showMessageDialog(this, "Customer has been deleted");
            } else{
                JOptionPane.showMessageDialog(this, "No user found");
            }
        }
        
    }

    @Override
    public void searchUser() {
        boolean found = false;
        Staff s = null;
        Customer c = null;
        for(int i = 0; i < Oodj.staff.size(); i++){
            if(icNumber.equals(Oodj.staff.get(i).getIcNumber())){
                s = Oodj.staff.get(i);
                found = true;
                break;
            }
        }
        if(found){
            try{
                JOptionPane.showMessageDialog(this, "Name: " + s.getName() + "\n" + "Email: " + s.getEmail() + "\n"
                                                + "IC number: " + s.getIcNumber() + "\n" + "Deparment: " + s.getDepartment() + "\n"
                                                + "Phone: " + s.getPhoneNumber() + "\n" + "Address: " + s.getMailingAddress());
            } catch (NullPointerException e){}
            
        } else{
           for(int i = 0; i < Oodj.customer.size(); i++){
                if(icNumber.equals(Oodj.customer.get(i).getIcNumber())){
                    c = Oodj.customer.get(i);
                    found = true;
                    break;
                }
            } 
           if(found){
               try{
                   JOptionPane.showMessageDialog(this, "Name: " + c.getName() + "\n" + "Email: " + c.getEmail() + "\n"
                                                + "IC number: " + c.getIcNumber() + "\n" + "Phone: " + c.getPhoneNumber() 
                                                + "\n" + "Address: " + c.getMailingAddress());
               } catch(NullPointerException e){}
           } else{
               JOptionPane.showMessageDialog(this,"No User Found");
           }
        }
    }
}
