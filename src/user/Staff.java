package user;

import java.util.ArrayList;

public class Staff extends Person{
    
    private String department;
    private int staffID;

    public Staff(int staffID, String username, String password , String name, String icNumber, String email, String phoneNumber, String mailingAddress, String department) {
        super(username, password, name, icNumber, email, phoneNumber, mailingAddress);
        this.department = department;
        this.staffID = staffID;
    }
    
    public String getDepartment() {
        return department;
    }

    public int getStaffID() {
        return staffID;
    }

}
