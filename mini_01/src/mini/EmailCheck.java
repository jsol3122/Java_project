package mini;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailCheck {
	private String email;
	private String host = "smtp.gmail.com"; 
	private String user = "javatest0987@gmail.com"; // �߽��� id
	private String sender = email; // ������ȣ �޴»��
	private String pwd = "javatest"; // �߽��� ���
	private int emailNum;
	
	public EmailCheck(String email) {
		this.email = email;
		emailNum = (int)(Math.random() * (99999 - 10000 + 1)) + 10000; // ������ȣ - 5�ڸ�����
		
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.user", user);
		props.put("mail.smtp.password", pwd);
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPassswordAuthentication() {
				return new PasswordAuthentication(user, pwd);
			}
		});
		
		if(email != null) {
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(user));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			
			msg.setSubject("������ �˻� ���α׷� ȸ�����Կ� ������ȣ�Դϴ�");
			msg.setText("�ȳ��ϼ���.\r\n"
					+ "\r\n"
					+ "������ȣ�� "+emailNum+ " �Դϴ�.\r\n"
					+ "\r\n"
					+ "�ش� ��ȣ�� ȸ������â�� ������ȣ���� �������ֽø� ȸ�������� �Ϸ�˴ϴ�.\r\n"
					+ "\r\n"
					+ "�����մϴ�.");

			Transport transport = session.getTransport();
			try {
				transport.connect(host, 587, user, pwd);
				transport.sendMessage(msg, msg.getAllRecipients());
				System.out.println("���� �Ϸ�");
			} catch (Exception ex) {
				ex.printStackTrace();
			}finally {
			    transport.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
	    } // try
		} // if
	}
	
	public int getEmailNum() {
		return emailNum;
	}

}
