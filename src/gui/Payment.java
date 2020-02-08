package gui;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import interfaces.Generator;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oodj.Oodj;

public class Payment extends JFrame implements ActionListener, Generator{
    
    private JLabel label;
    private JTextField tf;
    private int remainder;
    
    public Payment(){
        setSize(500,300);
        setLocation(300,300);
        
        label = new JLabel("Customer, your charge is RM100");
        Font f = new Font(Font.SANS_SERIF,Font.BOLD,12);
        label.setFont(f);
        tf = new JTextField(20);
        tf.addActionListener(this);
        setSize(240,120);
        setLocation(800,300);
        setLayout(new FlowLayout());
        add(label);
        add(tf);
        
        setLayout(new FlowLayout());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        int paymentMade = Integer.parseInt(tf.getText());
        tf.setText(null);
        remainder = remainder - paymentMade;
        if(remainder > 0){
            JOptionPane.showMessageDialog(this, "You paid RM" + remainder + " less.");
            label.setText(Oodj.aptPayment.getCustomer().getName() + ", your charge is RM" + remainder);
        } else{
            JOptionPane.showMessageDialog(this, "Thank you for the payment, for any extra change please refer to our technician");
            JOptionPane.showMessageDialog(this, "Extra change RM" + remainder*-1);
            Oodj.aptPayment.setTotalPaid(paymentMade);
            Oodj.aptPayment.setAppointmentStatus("Completed");
            receiptGenerator();
            sendMail(Oodj.aptPayment.getCustomer().getEmail());
            this.setVisible(false);
            Oodj.techMenuGUI.setVisible(true);
        }
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JTextField getTf() {
        return tf;
    }

    public void setTf(JTextField tf) {
        this.tf = tf;
    }

    public int getRemainder() {
        return remainder;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }
    
    @Override
    public void receiptGenerator(){
        try{
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("receipt.pdf"));
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
            cb.showTextAligned(Element.ALIGN_LEFT,"Service Type:", 36, 730, 0);
            cb.showTextAligned(Element.ALIGN_LEFT, Oodj.aptPayment.getServiceType(), 120, 730, 0);
            cb.showTextAligned(Element.ALIGN_LEFT,"Date of Service:", 36, 700, 0);
            cb.showTextAligned(Element.ALIGN_LEFT, Oodj.aptPayment.getAppointmentDate().toString(), 120, 700, 0);
            cb.showTextAligned(Element.ALIGN_LEFT,"Service Hour:", 36, 680, 0);
            cb.showTextAligned(Element.ALIGN_LEFT, Oodj.aptPayment.getAppointmentStartTime().toString(), 120, 680, 0);
            cb.showTextAligned(Element.ALIGN_LEFT,"Service End Time:", 36, 630, 0);
            cb.showTextAligned(Element.ALIGN_LEFT, Oodj.aptPayment.getAppointmentEndTime().toString(), 140, 630, 0);
            cb.showTextAligned(Element.ALIGN_LEFT,"Technician:", 36, 600, 0);
            cb.showTextAligned(Element.ALIGN_LEFT, Oodj.aptPayment.getStaff().getName(), 100, 600, 0);
            cb.endText();
            document.close();
        } catch(Exception e){}
    }

    @Override
    public void idGenerator() {}
    
    
    public static void sendMail(String mailTo){
        final String username = "noreplyapuautomotive@gmail.com";
        final String password = "apuservice";
        final String fromEmail = "no-reply@apuautomotiveservice.com";
        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socket", "587");
        
        Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
           protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(username,password);
           }
        });
        MimeMessage msg = new MimeMessage(session);
        try{
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
            msg.setSubject("Here is your E-Receipt");

            Multipart emailContent = new MimeMultipart();
            
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Dear ,"  + "\nThank you for choosing APU automotive service.\nHere is your receipt of payment.");
            
            MimeBodyPart pdfFile = new MimeBodyPart();
            pdfFile.attachFile("C:\\Users\\ander\\Documents\\GitHub\\OODJ\\receipt.pdf");
            
            emailContent.addBodyPart(textBodyPart);
            emailContent.addBodyPart(pdfFile);
            
            msg.setContent(emailContent);
//            
            System.out.println("Message Sent");

            Transport.send(msg);
        } catch(MessagingException e){}catch(IOException e){}
    }
}
