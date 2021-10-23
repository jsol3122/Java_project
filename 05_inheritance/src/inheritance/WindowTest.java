package inheritance;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;

public class WindowTest extends Frame { // FrameŬ������ �� ����Ŭ������ ���� �� ��� ����!
	// �Լ� �ɸ� ������ �ϴ� set~~ã�� ������ �θ�Ŭ������ Frame���� ã��! ������ �����θ�, ������ ���� �θ� ...

	public WindowTest() { 
		//setTitle("��������׸���"); // ������
		//new Frame("��������׸���").setVisible(true); // �̷��� �ϸ� ���ο� â �ϳ� �� �����(visible�ؾ� ����/���ϸ� �Ⱥ��ϻ�)
		super("��������׸���"); //�θ������(Frame������) ȣ�� -> �굵 �����ڴϱ� �ٸ������� ȣ�Ⱑ��
		
		setFont(new Font("�ü�ü", Font.BOLD, 32));
		
		//setBackground(Color.YELLOW); // ���� ���� - Ŭ����Ÿ�� ���� Color ���
		setBackground(new Color(151,225,181)); // �̰� ��ȸ��
		//ColorŬ������ ������ ȣ���ؼ� ���ϴ� ���� RGB�� �༭ �����ϰ� ������
		setForeground(Color.WHITE);
		
		//setSize(300,400); â ũ�� ����,���� ����
		setBounds(900,200,300,400); // â�� ��𿡼� ó�� ����+âũ�� ����
		setVisible(true); // �����ּ���~
	}
	
	@Override
	public void paint(Graphics g) { // java.window�� ������ override�Ǿ �ڽ��� ���Ⲩ�� ����
		g.drawString("����", 100, 80); // ��ġ�� ������� â�� �������𼭸��� 0,0���� ����
		g.drawLine(100,100,250,300); // �� �������� x,y�ప�� ������ x,y�ప �Է�
		g.drawRect(100,300,150,80); // �簢�������
		//g.drawOval(100,300,150,80); // ������� - �߽��� �ƴ϶� ������ ����
		g.fillOval(100,300,150,80); // ���� ��ĥ�� �� �����
	}
	
	public static void main(String[] args) {
			WindowTest wt = new WindowTest(); // �̰� ��ȸ��x / �ѹ������Ÿ� new���͸� �ᵵ ��

	}
}
