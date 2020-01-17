package user;

import java.util.Date;

public class Appointment {
    private int appointmentID;
    private Date appointmentDate;
    private Customer customer;
    private Staff staff;
    private String serviceType;

    public Appointment(int appointmentID, Date appointmentDate, String serviceType, Customer customer, Staff staff) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.customer = customer;
        this.staff = staff;
        this.serviceType = serviceType;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public String getServiceType() {
        return serviceType;
    }
}
