package inheritance;

import java.awt.Button;
import java.awt.Frame;

// Frame�� BorderLayout���� ������ �⺻���� ��������(��������)
public class AwtMain extends Frame {
	private Button northBtn, southBtn, eastBtn, westBtn, centerBtn; //Ŭ�������� �⺻�� null
	// NullPointerException : new������ ���ؼ� �⺻���� null���� �־ ����
	
	public void init() { // ������ ��� �ʱ�ȭ�޼ҵ� ��� - static�ƴ�
		// ��ư���� - ��ư�� ũ��� ����x(âũ�� �ٿ��� Ű���� �ϸ� ����)
		northBtn = new Button("����");
		southBtn = new Button("����");
		eastBtn = new Button("����");
		westBtn = new Button("����");
		centerBtn = new Button("�߾�");
		
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
		AwtMain am = new AwtMain();
		am.init();
		
		//new AwtMain().init();  --> �̷��� �ϸ� ��ȸ�� Ŭ��������+������ȣ��+initȣ��
	}

}
