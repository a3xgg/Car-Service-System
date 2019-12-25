package user;
public class Customer extends Person{
    
    private int custID;

    public Customer(int custID, String name, String icNumber, String email, String phoneNumber, String mailingAddress) {
        super(name, icNumber, email, phoneNumber, mailingAddress);
        this.custID = custID;
    }

    public int getCustID() {
        return custID;
    }
}
