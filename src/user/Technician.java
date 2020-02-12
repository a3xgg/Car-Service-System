package user;
import java.util.ArrayList;
public class Technician extends Staff{
    private ArrayList<Appointment> appointment;
    public Technician(int id, String username, String password , String name, String icNumber, String email, String phoneNumber, String mailingAddress, String department){
        super(id, username,password,name,icNumber,email,phoneNumber,mailingAddress,department);
        this.appointment = new ArrayList<Appointment>();
    }
    public ArrayList<Appointment> getAppointment() {
        return appointment;
    }
    public void addAppointment(Appointment apt){
        appointment.add(apt);
    }
}

