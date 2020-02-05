package gui;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.optionalusertools.PickerUtilities;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import oodj.Oodj;
import user.Appointment;
import user.Customer;
import user.Staff;

public class AppointmentBooking extends JFrame implements ActionListener{
    
    private Appointment bookingInfo;
    
    private String[] service = {"","Normal Service", "Major Service"};

    private JLabel customerLbl, serviceTypeLbl, date, time, serviceHourLbl, technicianLbl, serviceDuration, endService, endLbl;
    private JComboBox allCustomer, serviceType, allAvailableTechnician;
    private JButton backBtn, bookAppointment;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private TimePickerSettings timeSettings;
    private DatePickerSettings dateSettings;
    private SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    private Calendar cal = Calendar.getInstance();
    private LocalTime endTime;
    private Customer customer;
    private Staff staff;
    
    public AppointmentBooking(){
        setSize(270,500);
        setLocation(200,100);
        

        customerLbl = new JLabel("Customer:");
        allCustomer = new JComboBox();
        
        serviceTypeLbl = new JLabel("Service Type:");
        serviceType = new JComboBox(service);
        serviceType.addActionListener(e ->{
            if(serviceType.getSelectedIndex() == 1){
                serviceDuration.setText("1 Hour");
                try{
                    Date dt = formatTime.parse(timePicker.getText());
                    cal.setTime(dt);
                    cal.add(Calendar.HOUR, 1);
                    endLbl.setText(formatTime.format(cal.getTime()));
                    
                } catch(ParseException ae){}
            } else if(serviceType.getSelectedIndex() == 2){
                serviceDuration.setText("3 Hours");
                try{
                    Date dt = formatTime.parse(timePicker.getText());
                    cal.setTime(dt);
                    cal.add(Calendar.HOUR, 3);
                    endLbl.setText(formatTime.format(cal.getTime()));
                } catch(ParseException ae){}
            }
        });
       
        serviceHourLbl = new JLabel("Service Hour(s):");
        serviceDuration = new JLabel("");
        
        
        date = new JLabel("Select Date:");
        //This custom java library is implemented to be able to select the date
        dateSettings = new DatePickerSettings();
        dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd");
        dateSettings.setFormatForDatesBeforeCommonEra("uuuu-MM-dd");
        datePicker = new DatePicker(dateSettings);
        datePicker.setDateToToday();
        
        time = new JLabel("Select Time:");
        timeSettings = new TimePickerSettings();
        timeSettings.setFormatForDisplayTime(PickerUtilities.createFormatterFromPatternString("HH:mm:ss", timeSettings.getLocale()));
        timeSettings.setInitialTimeToNow();
        timePicker = new TimePicker(timeSettings);
        
        endService = new JLabel("End service time: ");
        endLbl = new JLabel(formatTime.format(cal.getTime()));
        
        
        technicianLbl = new JLabel("Available Technician(s):");
        allAvailableTechnician = new JComboBox();
        insertToComboBox();
        bookAppointment = new JButton("Book Appointment");
        bookAppointment.addActionListener(this);
        
        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        
        add(customerLbl);
        add(allCustomer);
        add(date);
        add(datePicker);
        add(time);
        add(timePicker);
        add(endService);
        add(endLbl);
        add(serviceTypeLbl);
        add(serviceType);
        
        add(serviceHourLbl);
        add(serviceDuration);
        
        add(technicianLbl);
        add(allAvailableTechnician);
        add(bookAppointment);
        add(backBtn);

        setLayout(new FlowLayout(0,20,20));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == backBtn){
            this.setVisible(false);
            Oodj.mgrMenuGUI.setVisible(true);
        } else if(ae.getSource() == bookAppointment){  
            booking();
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
    
    public void booking(){
        endTime = LocalTime.parse(endLbl.getText());
        for(int i = 0; i < Oodj.customer.size(); i++){
            if(allCustomer.getSelectedItem().toString().equals(Oodj.customer.get(i).getName())){
                customer = Oodj.customer.get(i);
                break;
            }
        }
        for(int i = 0; i < Oodj.staff.size(); i++){
            if(Oodj.staff.get(i).getDepartment().equals("Technician")){
                if(allAvailableTechnician.getSelectedItem().toString().equals(Oodj.staff.get(i).getName())){
                    staff = Oodj.staff.get(i);
                    break;
                }
            }
        }
        int id;
        if(Oodj.appointmentDetails.isEmpty()){
            id = 90001;
        } else{
            int size = Oodj.appointmentDetails.size();
            Appointment last = Oodj.appointmentDetails.get(size - 1);
            id = last.getAppointmentID() + 1;
        }
        LocalDate selectedDate = datePicker.getDate();
        LocalTime selectedTime = timePicker.getTime();
        String service = serviceType.getSelectedItem().toString();
        
        bookingInfo = new Appointment(id,selectedDate,selectedTime,endTime,service,customer,staff);
        
        Oodj.appointmentDetails.add(bookingInfo);
        JOptionPane.showMessageDialog(this, "Booking Successful!");
        this.setVisible(false);
        Oodj.mgrMenuGUI.setVisible(true);
    }
}
