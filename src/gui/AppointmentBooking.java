package gui;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import oodj.Oodj;

public class AppointmentBooking extends JFrame implements ActionListener{
    
    private String[] service = {"Normal Service", "Major Service"};

    private JLabel customerLbl, serviceTypeLbl, date, time, serviceHourLbl, technicianLbl, serviceDuration;
    private JComboBox allCustomer, serviceType, allAvailableTechnician;
    private JButton backBtn, bookAppointment;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private DatePickerSettings dateSettings;

    public AppointmentBooking(){
        setSize(1350,200);
        setLocation(200,100);
        

        customerLbl = new JLabel("Customer");
        allCustomer = new JComboBox();
        
        serviceTypeLbl = new JLabel("Service Type");
        serviceType = new JComboBox(service);
        serviceType.addActionListener(e ->{
            if(serviceType.getSelectedIndex() == 0){
                serviceDuration.setText("1 Hour");
            } else if(serviceType.getSelectedIndex() == 1){
                serviceDuration.setText("3 Hours");
            }
        });
        
        serviceHourLbl = new JLabel("Service Hours");
        serviceDuration = new JLabel("1 Hour");
        
        
        date = new JLabel("Select Date");
        //This custom java library is implemented to be able to select the date
        dateSettings = new DatePickerSettings();
        dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd");
        dateSettings.setFormatForDatesBeforeCommonEra("uuuu-MM-dd");
        datePicker = new DatePicker(dateSettings);
        datePicker.setDateToToday();
        
        time = new JLabel("Select Time");
        timePicker = new TimePicker();
        timePicker.setTimeToNow();
        
        technicianLbl = new JLabel("Available Technician(s)");
        allAvailableTechnician = new JComboBox();
        insertToComboBox();
        bookAppointment = new JButton("Book Appointment");
        bookAppointment.addActionListener(this);
        
        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        
        add(customerLbl);
        add(allCustomer);
        
        add(serviceTypeLbl);
        add(serviceType);
        
        add(serviceHourLbl);
        add(serviceDuration);
        add(date);
        add(datePicker);
        add(time);
        add(timePicker);
        add(technicianLbl);
        add(allAvailableTechnician);
        add(bookAppointment);
        add(backBtn);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(0,20,20));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == backBtn){
            this.setVisible(false);
            Oodj.mgrMenuGUI.setVisible(true);
        } else if(ae.getSource() == bookAppointment){    
        }
    }
    
    public final void insertToComboBox(){
        for(int i = 0; i < Oodj.customer.size(); i++){
            allCustomer.addItem(Oodj.customer.get(i).getName());
        }
        for(int i = 0; i < Oodj.staff.size(); i++){
            if(Oodj.staff.get(i).getDepartment().equals("Technician")){
                allAvailableTechnician.addItem(Oodj.staff.get(i).getName());
            }
        }
    }
}
