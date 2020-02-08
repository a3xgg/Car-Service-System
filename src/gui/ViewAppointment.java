package gui;

import java.awt.FlowLayout;
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

public class ViewAppointment extends JFrame implements ActionListener{

    private int appointmentID;
    private LocalDate appointmentDate;
    private LocalTime appointmentStartTime, appointmentEndTime;
    private String customer;
    private String serviceType, appointmentStatus;
    private final String[][] columnHeader = { {"AppointmentID","Appointment Date","Appointment Start Time","Appointment End Time", "Customer", "Service Type", "Appointment Status"} };
    
    private JTable appointmentTable;
    private final DefaultTableModel appointmentModel = new DefaultTableModel(columnHeader[0],0);
    private JScrollPane appointmentScrollable;
    private JLabel label;
    
    public ViewAppointment(){
        setData(Oodj.appointmentDetails);
        setSize(1000,500);
        setLocation(400,400);
        
        label = new JLabel("Appointments");
        label.setBounds(10, 10, 100, 25);
        
        appointmentTable = new JTable(appointmentModel);
        appointmentScrollable = new JScrollPane(appointmentTable);
        appointmentScrollable.setBounds(50, 100, 700, 500);
        add(label);
        add(appointmentScrollable);
        setLayout(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    public final void setData(ArrayList<Appointment> appointment){
        for(int i = 0; i < Oodj.appointmentDetails.size(); i++){
            if(Oodj.loginAccount.getName().equals(Oodj.appointmentDetails.get(i).getStaff().getName())){
                appointmentID = Oodj.appointmentDetails.get(i).getAppointmentID();
                appointmentDate = Oodj.appointmentDetails.get(i).getAppointmentDate();
                appointmentStartTime = Oodj.appointmentDetails.get(i).getAppointmentStartTime();
                appointmentEndTime = Oodj.appointmentDetails.get(i).getAppointmentEndTime();
                customer = Oodj.appointmentDetails.get(i).getCustomer().getName();
                serviceType = Oodj.appointmentDetails.get(i).getServiceType();
                appointmentStatus = Oodj.appointmentDetails.get(i).getAppointmentStatus();
                
                Object[] detail = {appointmentID,appointmentDate,appointmentStartTime,appointmentEndTime,customer,serviceType,appointmentStatus};
                appointmentModel.addRow(detail);
            }
        }
    }
}
