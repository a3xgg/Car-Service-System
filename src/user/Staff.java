package user;

public class Staff extends Person{
    
    private String department;
    public Staff(String name, String icNumber, String email, String phoneNumber, String mailingAddress, String department) {
        super(name, icNumber, email, phoneNumber, mailingAddress);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
