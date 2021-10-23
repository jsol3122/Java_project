package inheritance;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

//Frame���� �⺻���� ������ BorderLayout(��������)�� ������ �� ���� ���� �� 1���� ��ư�� ���� �� ����
public class AwtMain2 extends Frame{
	private Button newBtn, exitBtn;
	
	public void init() {
		newBtn = new Button("���θ����");
		exitBtn = new Button("����");
		
		// �г�(�ѱ����� ������ư���� ����)�� �ѹ����� �����Ŷ� �ʵ帻�� �������� ����
		// FlowLayout - ����� �߽����� ������� ��ġ��(��������x)
		Panel p = new Panel(); 
		p.setLayout(new GridLayout(1, 2, 10, 0)); // �յ��� ���̾ƿ�(�࿭��ġ)���� ���� ����
		p.setBackground(new Color(151,225,181)); // �гλ� ����
		p.add(newBtn);
		p.add(exitBtn);
		
		add("North", p); // ��ư ũ��� ����x(���� ���̿� ���� �ٸ��� ����)
		
		//super("â"); --> �̷������� �θ������ ȣ���Ϸ��� ���� �����ڿ��� ��(������ �ʱ�ȭ�޼ҵ�)
		setTitle("â");
		
		setBounds(900,200,300,400); 
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AwtMain2().init();

	}

}
