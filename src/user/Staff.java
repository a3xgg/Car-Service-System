package user;

public class Staff extends Person{
    
    private String department;
    private StatusAvailability status;
    
    public Staff(String username, String password , String name, String icNumber, String email, String phoneNumber, String mailingAddress, String department, StatusAvailability status) {
        super(username, password, name, icNumber, email, phoneNumber, mailingAddress);
        this.department = department;
        this.status = status;
    }
    
    public String getDepartment() {
        return department;
    }

    public StatusAvailability getStatus() {
        return status;
    }
}
