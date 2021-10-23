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
	private String user = "javatest0987@gmail.com"; // 발신자 id
	private String sender = email; // 인증번호 받는사람
	private String pwd = "javatest"; // 발신자 비번
	private int emailNum;
	
	public EmailCheck(String email) {
		this.email = email;
		emailNum = (int)(Math.random() * (99999 - 10000 + 1)) + 10000; // 인증번호 - 5자리난수
		
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
			
			msg.setSubject("레시피 검색 프로그램 회원가입용 인증번호입니다");
			msg.setText("안녕하세요.\r\n"
					+ "\r\n"
					+ "인증번호는 "+emailNum+ " 입니다.\r\n"
					+ "\r\n"
					+ "해당 번호를 회원가입창의 인증번호란에 기재해주시면 회원가입이 완료됩니다.\r\n"
					+ "\r\n"
					+ "감사합니다.");

			Transport transport = session.getTransport();
			try {
				transport.connect(host, 587, user, pwd);
				transport.sendMessage(msg, msg.getAllRecipients());
				System.out.println("전송 완료");
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
