package user;

import java.util.ArrayList;

public class Staff extends Person{
    
    private String department;
    private ArrayList<StaffAccount> staffAccount;
    
    public Staff(String name, String icNumber, String email, String phoneNumber, String mailingAddress, String department) {
        super(name, icNumber, email, phoneNumber, mailingAddress);
        this.department = department;
        staffAccount = new ArrayList<StaffAccount>();
    }

    public ArrayList<StaffAccount> getStaffAccount() {
        return staffAccount;
    }
    
    public void addStaffAccount(StaffAccount staffAccount){
        this.staffAccount.add(staffAccount);
    }

    public String getDepartment() {
        return department;
    }
}
