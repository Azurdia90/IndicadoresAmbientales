package Controllers;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mail_cgp {
	
	private Properties props;
	
	private String correo = components_web_controller.getProperty("MAIL_USER_CGP");
	private String clave = components_web_controller.getProperty("MAIL_PASS_CGP");
	
	public mail_cgp() throws Exception
	{
		props = new Properties();

        props.setProperty("mail.smtp.host", components_web_controller.getProperty("MAIL_SMTP_CGP"));
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", components_web_controller.getProperty("MAIL_PORT_CGP"));
        props.setProperty("mail.smtp.user", correo);//Correo origen
        props.setProperty("mail.smtp.auth", "true");
		
	}
	
	public void send_message(String name, String transmitter, String subject, String text){
		
		String resultado="";	
		
		try
        {
			
            // Preparamos la sesion
            //Session session = Session.getDefaultInstance(props);
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(correo, clave);
                }
            });

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(transmitter));//Correo origen
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(correo));//Correo destino

            message.setSubject(subject + " - " + name);
            message.setText(text, "utf-8", "html");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(correo, clave);
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
            resultado ="{\"resultado\":\"OK\"}";
           
        }
		
        catch (Exception e)
        {
        	resultado ="{\"resultado\":\"ERROR\"}";
            e.printStackTrace();
            
        }
	}

}
