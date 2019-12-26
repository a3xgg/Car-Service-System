package user;
public class StaffAccount {
    
    private String username, password;
    private Staff staff;
    
    public StaffAccount(String username, String password, Staff staff){
        this.username = username;
        this.password = password;
        this.staff = staff;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Staff getStaff() {
        return staff;
    }
    
}
