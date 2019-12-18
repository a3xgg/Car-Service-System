package user;
public class Mechanic extends Person{
    
    private int techID;
    private String department;

    public Mechanic(int techID, String department, String name, String icNumber, String email, String phoneNumber, String mailingAddress) {
        super(name, icNumber, email, phoneNumber, mailingAddress);
        this.techID = techID;
        this.department = department;
    }
}
