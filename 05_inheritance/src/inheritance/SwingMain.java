package inheritance;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SwingMain extends JFrame{

	private JButton northBtn, southBtn, eastBtn, westBtn, centerBtn; //Ŭ�������� �⺻�� null
	// NullPointerException : new������ ���ؼ� �⺻���� null���� �־ ����
	
	public void init() { // ������ ��� �ʱ�ȭ�޼ҵ� ��� - static�ƴ�
		// ��ư���� - ��ư�� ũ��� ����x(âũ�� �ٿ��� Ű���� �ϸ� ����)
		northBtn = new 	JButton("����");
		southBtn = new JButton("����");
		eastBtn = new JButton("����");
		westBtn = new JButton("����");
		centerBtn = new JButton(new ImageIcon("�۸�.gif"));
		
		//��ġ - ��ҵ��� ��ġ�� �̵����� �����ϴ� ��
		add("North", northBtn); // BorderLayout���� �̹� ������ North������ northBtn�� ��ġ��Ų ��
		add("South", southBtn);
		add("East", eastBtn);
		add("West", westBtn);
		add("Center", centerBtn);
		
		setBounds(900,200,300,400); 
		setVisible(true); 
	}

	public static void main(String[] args) {
		new SwingMain().init();  
	}

}
