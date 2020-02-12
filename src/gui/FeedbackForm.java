package gui;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import interfaces.Generator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import oodj.Oodj;

public class FeedbackForm extends Payment implements ActionListener{

    public JLabel customerLbl,technicianLbl,appointmentLbl;
    private JLabel feedback;
    private JTextArea feedbackDetails;
    private JButton confirm;
    
    public FeedbackForm(){
        setSize(500,500);
        setLocation(300,300);
        
        customerLbl = new JLabel("Customer Name: ");
        technicianLbl = new JLabel("Technician Name: ");
        appointmentLbl = new JLabel("Appointment ID: ");
        customerLbl.setBounds(10,10,200,25);
        technicianLbl.setBounds(10, 40, 220, 25);
        appointmentLbl.setBounds(10, 70, 200, 25);
        feedback = new JLabel("Feedback: ");
        feedback.setBounds(10, 100, 200, 25);
        feedbackDetails = new JTextArea();
        feedbackDetails.setBounds(10,120,400,300);
        confirm = new JButton("Confirm");
        confirm.setBounds(10, 430, 200, 30);
        confirm.addActionListener(this);
        add(appointmentLbl);
        add(customerLbl);
        add(technicianLbl);
        add(feedback);
        add(feedbackDetails);
        add(confirm);
        setLayout(null);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(feedbackDetails.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please provide customer feedback");
        } else{
            feedbackGenerator();
            sendMail(Oodj.aptPayment.getCustomer().getEmail());
            this.setVisible(false);
        }
    }

    public JLabel getCustomerLbl() {
        return customerLbl;
    }

    public JLabel getTechnicianLbl() {
        return technicianLbl;
    }

    public JLabel getAppointmentLbl() {
        return appointmentLbl;
    }
    public void feedbackGenerator(){
        try{
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("feedback.pdf"));
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            cb.beginText();
            BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            cb.setFontAndSize(bf, 12);
            cb.setRGBColorFill(0, 0, 0);
            cb.showTextAligned(Element.ALIGN_LEFT,"Appointment ID:", 36, 788, 0);
            cb.showTextAligned(Element.ALIGN_LEFT,Integer.toString(Oodj.aptPayment.getAppointmentID()), 120, 788, 0);
            cb.showTextAligned(Element.ALIGN_LEFT,"Name:", 36, 760, 0);
            cb.showTextAligned(Element.ALIGN_LEFT, Oodj.aptPayment.getCustomer().getName(), 70, 760, 0);
            cb.showTextAligned(Element.ALIGN_LEFT,"Technician:", 36, 740, 0);
            cb.showTextAligned(Element.ALIGN_LEFT, Oodj.aptPayment.getStaff().getName(), 100, 740, 0);
            cb.showTextAligned(Element.ALIGN_LEFT, "Feedback: \n", 36, 720, 0);
            cb.showTextAligned(Element.ALIGN_LEFT, feedbackDetails.getText(), 36, 700, 0);
            cb.endText();
            document.close();
        } catch(Exception e){}
    }
    
}
