package inheritance;

import java.awt.Button;
import java.awt.Frame;

public class AwtMain3 extends Frame{
	private Button newBtn, exitBtn;
	
	public void init() {
		newBtn = new Button("���θ����");
		exitBtn = new Button("����");
		
		setLayout(null); // layout�� �ƿ� �� ���ֹ�����
		newBtn.setBounds(100, 100, 120, 50); // ��ư�� ��ġ�� ũ�� ����
		exitBtn.setBounds(100, 180, 120, 50);
		add(newBtn); // ��ư ����
		add(exitBtn);
		setTitle("â");
		setBounds(900,200,300,400); 
		setVisible(true);
	}

	public static void main(String[] args) {
		new AwtMain3().init();

	}

}
