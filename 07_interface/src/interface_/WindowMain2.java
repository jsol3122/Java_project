package interface_;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class ImageMove extends Frame implements ActionListener, KeyListener, WindowListener{
	private Button initBtn, upBtn, downBtn, leftBtn, rightBtn;
	private int x=100, y=100;
	
	public ImageMove() {
		initBtn = new Button("�ʱ�ȭ");
		upBtn = new Button("��");
		downBtn = new Button("��");
		leftBtn = new Button("��");
		rightBtn = new Button("��");
		
		Panel p = new Panel();
		p.add(initBtn);
		p.add(leftBtn);
		p.add(upBtn);
		p.add(downBtn);
		p.add(rightBtn);
		add("North", p);
		
		setTitle("�̹��� �̵�");
		setBounds(800, 200, 500, 500);
		setVisible(true); // �갡 paint�� callback��
		
		this.addWindowListener(this);
		initBtn.addActionListener(this);
		leftBtn.addActionListener(this);
		upBtn.addActionListener(this);
		downBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		
		this.addKeyListener(this);
		initBtn.addKeyListener(this);
		leftBtn.addKeyListener(this);
		upBtn.addKeyListener(this);
		downBtn.addKeyListener(this);
		rightBtn.addKeyListener(this);
		
	} // ������
	
	// ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==initBtn) {
			
		}else if(e.getSource()==leftBtn) {
			x-=10;
			if(x==-190) x=450;
		}else if(e.getSource()==upBtn) {
			y-=10;
			if(y==-180) y=470;
		}else if(e.getSource()==downBtn) {
			y+=10;
			if(y==470) y=-190;
		}else if(e.getSource()==rightBtn) {
			x+=10;
			if(x==450) x=-190;
		}
		
		System.out.println("x= "+x+" y = "+y);
		repaint(); // JVM�� ���� paint�޼ҵ带 call�ϱ� - �ѹ� �ϰ��� �ٽ� paint���� x�� �缳���ؼ� â�� ������ϴϱ�
	}
	
	@Override
	public void paint(Graphics g) { 
		//�̹��� �ҷ����� Ŭ���� ���� --> �߻�Ŭ������ new�ȵ� / �ڽ�Ŭ������x
		Toolkit t = Toolkit.getDefaultToolkit(); // ����
		Image img = t.getImage("image/���ε�.png"); // �̹��� �ҷ����� - image������ �ִٴ� ��
	
		// �̹��� �۰� (�̹��� �����ִ¾�, �׸��� ��ǥ, ���ϴ�ȭ��ũ�� ��ǥ, �̹���ũ�� ��ǥ(����/����), ���ٱ׷���?)
		g.drawImage(img, x, y, this);
	}
	
	// keyListener
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				x-=10;
				if(x==-190) x=450;
		}else if(e.getKeyCode()==KeyEvent.VK_UP) {
				y-=10;
				if(y==-180) y=470;
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				y+=10;
				if(y==470) y=-190;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				x+=10;
				if(x==450) x=-190;
		}
		repaint();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}

	// WindowListener
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {	}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}


	
}
//---------------------------------------------------------
public class WindowMain2 {

	public static void main(String[] args) {
		new ImageMove();

	}

}
