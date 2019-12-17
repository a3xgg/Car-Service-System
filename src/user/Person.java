package user;
public class Person {
    private String name, icNumber, department, email, phoneNumber, mailingAddress;
    //Default Constructor
    public Person(){}
    //Constructor for Customer
    public Person(String name, String icNumber, String email, String phoneNumber, String mailingAddress, String department){
        this.name = name;
        this.icNumber = icNumber;
        this.email = email;
        this.phoneNumber =  phoneNumber;
        this.mailingAddress = mailingAddress;
        this.department = department;
    }

    public String getDepartment() {
        return department;
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
