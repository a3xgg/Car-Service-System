package user;
public class Manager extends Person{

    private int mgrID;
    private String department;

    public Manager(int mgrID, String department, String name, String icNumber, String email, String phoneNumber, String mailingAddress) {
        super(name, icNumber, email, phoneNumber, mailingAddress);
        this.mgrID = mgrID;
        this.department = department;
    }        
}
