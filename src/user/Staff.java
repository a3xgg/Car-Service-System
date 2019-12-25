package user;
public class Staff extends Person{
    
    private String department, username, password;
    
    public Staff(String username, String password, String name, String icNumber, String email, String phoneNumber, String mailingAddress, String department) {
        super(name, icNumber, email, phoneNumber, mailingAddress);
        this.department = department;
        this.username = username;
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
