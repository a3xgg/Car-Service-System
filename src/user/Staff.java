package user;

public class Staff extends Person{
    
    private String department;

    public Staff(String username, String password , String name, String icNumber, String email, String phoneNumber, String mailingAddress, String department) {
        super(username, password, name, icNumber, email, phoneNumber, mailingAddress);
        this.department = department;
    }
    
    public String getDepartment() {
        return department;
    }
}
