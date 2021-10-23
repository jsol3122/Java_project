package abstract_;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

public class WindowMain extends Frame {
	private Button initBtn, upBtn, downBtn, leftBtn, rightBtn;
	
	public WindowMain() {
		setTitle("�̹���");
		setSize(400,400);
		setVisible(true);
		//setVisible(false);�� ����â���� �Ѿ�� ���̻� �Ⱦ��� â�� �ݱ⵵ ��
		
		Panel p = new Panel();
		p.setLayout(new GridLayout(1,5,5,5));
		Button initBtn = new Button("�ʱ�ȭ");
		p.add(initBtn);
		Button leftBtn = new Button("����");
		p.add(leftBtn);
		Button upBtn = new Button("��");
		p.add(upBtn);
		Button downBtn = new Button("�Ʒ�");
		p.add(downBtn);
		Button rightBtn = new Button("������");
		p.add(rightBtn);
		p.setBounds(0,0,400,70);
		add("North",p);
	}
	@Override
	public void paint(Graphics g) { 
		g.drawString("īī�� �̹���", 50, 80); 
		
		//�̹��� �ҷ����� Ŭ���� ���� --> �߻�Ŭ������ new�ȵ� / �ڽ�Ŭ������x
		Toolkit t = Toolkit.getDefaultToolkit(); // ����
		Image img = t.getImage("����ġ2.gif"); // �̹��� �ҷ�����
		
		// �̹��� �׸���(�̹��� �����ִ¾�, �׸��� xy��ǥ, ���ٱ׷���?=this=��
		//g.drawImage(img, 30, 120, this); 
		
		// �̹��� �۰� (�̹��� �����ִ¾�, �׸��� ��ǥ, ���ϴ�ȭ��ũ�� ��ǥ, �̹���ũ�� ��ǥ(����/����), ���ٱ׷���?)
		g.drawImage(img, 30, 120, 200, 300, 0, 0, 638, 614, this);
		
		// �̹��� �Ųٷ� �������� --> �̹���ũ����ǥ�� �������� ������ �ٲٸ� ������!!
		//g.drawImage(img, 30, 120, 200, 300, 638, 614, 0, 0, this);
	}
	
	public static void main(String[] args) {
		new WindowMain();

	}

}
