package user;
public class Person {
    private String name, icNumber, email, phoneNumber, mailingAddress;
    //Constructor reference for subclasses
    public Person(String name, String icNumber, String email, String phoneNumber, String mailingAddress){
        this.name = name;
        this.icNumber = icNumber;
        this.email = email;
        this.phoneNumber =  phoneNumber;
        this.mailingAddress = mailingAddress;
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
