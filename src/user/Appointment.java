package user;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int appointmentID;
    private LocalDate appointmentDate;
    private LocalTime appointmentStartTime, appointmentEndTime;
    private Customer customer;
    private Staff staff;
    private String serviceType, appointmentStatus;

    public Appointment(int appointmentID, LocalDate appointmentDate, LocalTime appointmentStartTime, LocalTime appointmentEndTime, String serviceType, Customer customer, Staff staff, String appointmentStatus) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.customer = customer;
        this.staff = staff;
        this.serviceType = serviceType;
        this.appointmentStatus = appointmentStatus;
    }
    public Appointment(int appointmentID, LocalDate appointmentDate, LocalTime appointmentStartTime, LocalTime appointmentEndTime, String serviceType, Customer customer, Staff staff) {
        this(appointmentID,appointmentDate,appointmentStartTime,appointmentEndTime, serviceType, customer,staff,"Not Completed");
        
    }
    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public LocalTime getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentStartTime() {
        return appointmentStartTime;
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
