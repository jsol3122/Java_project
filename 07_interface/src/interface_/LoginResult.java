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
		
		setFont(new Font("����ü", Font.BOLD, 20));
		setBounds(1000, 80, 200, 200);
		setVisible(true);
		
		this.addWindowListener(this);
	} // ������

	//����Ʈ�޼ҵ� �ȿ��� if������ �α��� ����/���� ����
	@Override
	public void paint(Graphics g) {
		super.paint(g); // â �ؿ� �����ɶ��� �θ������ �ҷ������� ��
		
		if(id.equals("ȫ�浿")&&pwd.equals("1111")) {
			g.setColor(Color.BLUE);
			g.drawString("�α��� ����", 80, 100);
		}
		else {
			g.setColor(Color.RED);
			g.drawString("�α��� ����", 80, 100);
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
