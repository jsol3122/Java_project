package selfTest;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	
	public static void main(String[] args) throws Exception {
		String host = "smtp.gmail.com";
		String user = "javatest0987@gmail.com";
		String sender = "jsol3122@gmail.com";
		String pwd = "javatest";
		
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.user", user);
		props.put("mail.smtp.password", pwd);
		props.put("mail.transport.protocol", "smtp");
		//props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPassswordAuthentication() {
				return new PasswordAuthentication(user, pwd);
			}
		});
		
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(user));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(sender));
			
			msg.setSubject("������ �Է��ϼ���");
			msg.setText("������ �Է��ϼ���");
			
			Transport transport = session.getTransport("smtp");
			transport.connect(host, user, pwd);
			transport.sendMessage(msg, msg.getAllRecipients());
			//Transport.send(msg);
			System.out.println("������ ���������� �����Ͽ����ϴ�");
		} catch (MessagingException e) {
			e.printStackTrace();
		} 
	}
	
}
