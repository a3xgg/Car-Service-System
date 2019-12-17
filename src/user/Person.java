package user;
public class Person {
    private String name, icNumber, role, email, phoneNumber, mailingAddress;
    //Default Constructor
    public Person(){}
    //Constructor for Customer
    public Person(String name, String icNumber, String email, String phoneNumber, String mailingAddress, String role){
        this.name = name;
        this.icNumber = icNumber;
        this.email = email;
        this.phoneNumber =  phoneNumber;
        this.mailingAddress = mailingAddress;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getIcNumber() {
        return icNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

}
