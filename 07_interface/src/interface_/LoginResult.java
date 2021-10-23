package interface_;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class LoginResult extends JFrame implements WindowListener{
	private String id, pwd;
	
	public LoginResult(String id, String pwd) {
		this.id=id;
		this.pwd=pwd;
		
		setFont(new Font("돋움체", Font.BOLD, 20));
		setBounds(1000, 80, 200, 200);
		setVisible(true);
		
		this.addWindowListener(this);
	} // 생성자

	//페인트메소드 안에서 if문으로 로그인 성공/실패 검증
	@Override
	public void paint(Graphics g) {
		super.paint(g); // 창 밑에 투과될때는 부모생성자 불러버리면 됨
		
		if(id.equals("홍길동")&&pwd.equals("1111")) {
			g.setColor(Color.BLUE);
			g.drawString("로그인 성공", 80, 100);
		}
		else {
			g.setColor(Color.RED);
			g.drawString("로그인 실패", 80, 100);
		}
	}
	
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		this.setVisible(false);	
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
	
}
