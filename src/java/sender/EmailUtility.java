package sender;


import javax.mail.*;
import java.util.Properties;
import java.util.Random;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {

    public static String getRandomCode() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        return String.format("%06d", number);
    }

    public static void sendEmail(String toEmail, String code) {
        
        String fromEmail = "tuananhtran291003@gmail.com";
        String password = "bvqquguldrnovxyx";

        try {
            Properties pro = new Properties();
            pro.put("mail.smtp.host", "smtp.gmail.com");
            pro.put("mail.smtp.port", "587");
            pro.put("mail.smtp.auth", "true");
            pro.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(pro, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });
            
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            message.setSubject("Account email verification");
            message.setText("Register successfully. Verification code: " + code);

            Transport.send(message);

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
