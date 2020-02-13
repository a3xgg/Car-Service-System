package user;
public abstract class Person {
    private String username, password, name, icNumber, email, phoneNumber, mailingAddress;
    //Constructor reference for subclasses
    public Person(String username, String password,String name, String icNumber, String email, String phoneNumber, String mailingAddress){
        this.username = username;
        this.password = password;
        this.name = name;
        this.icNumber = icNumber;
        this.email = email;
        this.phoneNumber =  phoneNumber;
        this.mailingAddress = mailingAddress;
    }
    
    //Constructor used for Customer when no login is required.
    public Person(String name, String icNumber, String email, String phoneNumber, String mailingAddress){
        this("null","null",name,icNumber,email,phoneNumber,mailingAddress);
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIcNumber(String icNumber) {
        this.icNumber = icNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

}
