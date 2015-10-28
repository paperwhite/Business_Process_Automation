/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project1;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/*import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
*/
import javax.mail.*;
import javax.mail.internet.*;
import java.security.SecureRandom;
import java.math.BigInteger;
import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Shibani
 */

final class SessionIdentifierGenerator
{

  private SecureRandom random = new SecureRandom();

  public String nextSessionId()
  {
    return new BigInteger(130, random).toString(32);
  }

}
class SMTPAuthenticator extends javax.mail.Authenticator
{static final String SMTP_HOST_NAME = "smtp.gmail.com";
  static final String SMTP_AUTH_USER = "formprocessor123@gmail.com";
  static final String SMTP_AUTH_PWD  = "IjustPROCESSforms";
    public PasswordAuthentication getPasswordAuthentication()
    {
        String username = SMTP_AUTH_USER;
        String password = SMTP_AUTH_PWD;
        return new PasswordAuthentication(username, password);
    }
}
public class SendPassword {
    Statement s ;
    String user_id, password, to;
    public SendPassword(Connection c1,String recipient, String userid) throws SQLException{
       user_id = userid;
       SessionIdentifierGenerator sig = new SessionIdentifierGenerator();
        password = sig.nextSessionId();
        password = password.substring(0,10);
       /* to = recipient;
       Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        SessionIdentifierGenerator sig = new SessionIdentifierGenerator();
        password = sig.nextSessionId();
        //ResultSet i = s.executeQuery(s2);
        String msgBody = "Your password for user_id ="+user_id+"is :"+password;

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("formprocessor123@gmail.com", "FormProcessor Admin"));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress(to, user_id));
            msg.setSubject("Your formprocessor account has been activated");
            msg.setText(msgBody);
            Transport.send(msg);

        } catch (AddressException e) {
            // ...
        } catch (MessagingException e) {
            // ...
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SendPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
   */
        Authenticator auth = new SMTPAuthenticator();
        // Recipient's email ID needs to be mentioned.
      to = recipient;

      // Sender's email ID needs to be mentioned
      String from = "formprocessor123@gmail.com";

      // Assuming you are sending email from localhost
      String host = "smtp.gmail.com";

      // Get system properties
      Properties properties = System.getProperties();
//SmtpClient smtp = new SmtpClient("smtp.gmail.com", 587);
      // Setup mail server
      //properties.setProperty("mail.smtp.host",host);
      properties.put("mail.transport.protocol", "smtp");
properties.put("mail.smtp.host","smtp.gmail.com");
properties.put("mail.smtp.port", "25");
properties.put("mail.smtp.auth", "true");
properties.put("mail.smtp.starttls.enable", "true");
      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties,auth);

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Your formprocessor account has been activated");

         // Now set the actual message
         message.setText("Your password for user_id : "+user_id+" is : "+password);

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
    }
}
