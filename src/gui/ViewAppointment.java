package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import user.Appointment;
import oodj.Oodj;
import user.Customer;

public class ViewAppointment extends JFrame implements ActionListener{

    private int appointmentID;
    private String techName;
    private LocalDate appointmentDate;
    private LocalTime appointmentStartTime, appointmentEndTime;
    private String customer,address,phone,technician;
    private String serviceType, appointmentStatus;
    private final String[][] columnHeader = { {"AppointmentID","Appointment Date","Appointment Start Time","Appointment End Time", "Customer","Address" ,"Phone","Service Type", "Appointment Status"},
    {"AppointmentID","Appointment Date","Appointment Start Time","Appointment End Time", "Customer","Address" ,"Phone","Service Type", "Appointment Status","Technician"},
    {"Appointment Date","Appointment Time","Technician","Technician Contact"}};
    
    private JTable appointmentTable;
    private final DefaultTableModel ownModel = new DefaultTableModel(columnHeader[0],0);
    private final DefaultTableModel staffModel = new DefaultTableModel(columnHeader[1],0);
    private final DefaultTableModel custModel = new DefaultTableModel(columnHeader[2],0);

    private JScrollPane appointmentScrollable;
    private JLabel label;
    
    public ViewAppointment(){
        try{
            if(Oodj.loginAccount.getDepartment().equals("Technician")){
                appointmentTable = new JTable(ownModel);
                setData(Oodj.appointmentDetails);
            } else if(Oodj.loginAccount.getDepartment().equals("Manager")){
                appointmentTable = new JTable(staffModel);
                setAllData(Oodj.appointmentDetails);
            }
        } catch(Exception e){
            appointmentTable = new JTable(custModel);
            setCustData(Oodj.appointmentDetails);
        }
        
        
        setSize(1200,500);
        setLocation(400,400);
        
        label = new JLabel("Appointments");
        label.setBounds(10, 10, 100, 25);
        
        
        appointmentScrollable = new JScrollPane(appointmentTable);
        appointmentScrollable.setBounds(50, 50, 1000, 500);
        add(label);
        add(appointmentScrollable);
        setLayout(null);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    public final void setAllData(ArrayList<Appointment> appointment){
        for(int i = 0; i < Oodj.appointmentDetails.size(); i++){
            appointmentID = Oodj.appointmentDetails.get(i).getAppointmentID();
            appointmentDate = Oodj.appointmentDetails.get(i).getAppointmentDate();
            appointmentStartTime = Oodj.appointmentDetails.get(i).getAppointmentStartTime();
            appointmentEndTime = Oodj.appointmentDetails.get(i).getAppointmentEndTime();
            customer = Oodj.appointmentDetails.get(i).getCustomer().getName();
            address = Oodj.appointmentDetails.get(i).getCustomer().getMailingAddress();
            phone = Oodj.appointmentDetails.get(i).getCustomer().getPhoneNumber();
            techName = Oodj.appointmentDetails.get(i).getStaff().getName();
            serviceType = Oodj.appointmentDetails.get(i).getServiceType();
            appointmentStatus = Oodj.appointmentDetails.get(i).getAppointmentStatus();
            Object[] detail = {appointmentID,appointmentDate,appointmentStartTime,appointmentEndTime,customer,address,phone,serviceType,appointmentStatus,techName};
            staffModel.addRow(detail);
        }
    }
    
    public final void setData(ArrayList<Appointment> appointment){
        for(int i = 0; i < Oodj.appointmentDetails.size(); i++){
            if(Oodj.loginAccount.getName().equals(Oodj.appointmentDetails.get(i).getStaff().getName())){
                appointmentID = Oodj.appointmentDetails.get(i).getAppointmentID();
                appointmentDate = Oodj.appointmentDetails.get(i).getAppointmentDate();
                appointmentStartTime = Oodj.appointmentDetails.get(i).getAppointmentStartTime();
                appointmentEndTime = Oodj.appointmentDetails.get(i).getAppointmentEndTime();
                customer = Oodj.appointmentDetails.get(i).getCustomer().getName();
                address = Oodj.appointmentDetails.get(i).getCustomer().getMailingAddress();
                phone = Oodj.appointmentDetails.get(i).getCustomer().getPhoneNumber();
                serviceType = Oodj.appointmentDetails.get(i).getServiceType();
                appointmentStatus = Oodj.appointmentDetails.get(i).getAppointmentStatus();
                Object[] detail = {appointmentID,appointmentDate,appointmentStartTime,appointmentEndTime,customer,address,phone,serviceType,appointmentStatus};
                ownModel.addRow(detail);
            }
        }
    }
    
    public final void setCustData(ArrayList<Appointment> appointment){
        for(int i = 0; i < Oodj.appointmentDetails.size(); i++){
            if(Oodj.custLogin.getName().equals(Oodj.appointmentDetails.get(i).getCustomer().getName())){
                appointmentDate = Oodj.appointmentDetails.get(i).getAppointmentDate();
                appointmentStartTime = Oodj.appointmentDetails.get(i).getAppointmentStartTime();
                technician = Oodj.appointmentDetails.get(i).getStaff().getName();
                phone = Oodj.appointmentDetails.get(i).getStaff().getPhoneNumber();
                Object[] detail = {appointmentDate,appointmentStartTime,technician,phone};
                custModel.addRow(detail);
            }
        }
    }
}
