package thread;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Packman extends JFrame implements Runnable{
	private Image img, icon;
	int size=2;
	int x=225, y=225, mx, my;
	int[] foodX=new int[5]; // ������ġ�� �迭
	int[] foodY=new int[5];
	
	public Packman() {
		// ���⼭ Toolkit �����ϴ°͵� ����
		// ToolkitŬ������ new ����x / �ڽ�Ŭ������x
		img = Toolkit.getDefaultToolkit().getImage("image/packman.png");
		icon = Toolkit.getDefaultToolkit().getImage("image/icon.png");
		
		setBounds(800, 150, 500, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					size=0;
					mx=-10; my=0;
				}else if(e.getKeyCode()==KeyEvent.VK_UP) {
					size=4;
					mx=0; my=-10;
				}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					size=2;
					mx=10; my=0;
				}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
					size=6;
					mx=0; my=10;
				}else if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}
			}
		});
		
		for(int i=0; i<foodX.length; i++) { // ���� ��ġ �����߻�
			this.foodX[i] = (int)(Math.random()*461)+20;
			this.foodY[i] = (int)(Math.random()*461)+20;
		}
		
		Thread t = new Thread(this);
		t.start();
		
	} // ������
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// (�����̹��� / ������ǥx,y / �����̹�����ǥx,y / this) 
		g.drawImage(img, x, y, x+50, y+50, size*50, 0, size*50+50, 50, this);
		
		for(int i=0; i<foodX.length; i++) { // ���� 5�� ���������� ����
			g.drawImage(icon, foodX[i], foodY[i], foodX[i]+20, foodY[i]+20, 0, 0, 512, 512, this);
		}
	} // paint
	
	@Override
	public void run() {
		while(true) {
			repaint(); // Ű���� ���������� �׸��°� �ƴ϶�, ���ѷ������� repaint�ֱ�
			
			if(size%2==0) size++; // �Թ����� ������ ���� / 50���̴ϱ� �׿����� ������ ����
			else size--;
			
			x=x+mx; // �̵� ���� / ��ǥ�� ����
			y=y+my;
			
			if(x>500) x=0; // â ��� ��� �ٽ� â ������ ���ƿ��� �ϱ�
			else if(x<0) x=500;
			else if(y>500) y=0;
			else if(y<0) y=500;
			
			for(int i=0;i<foodX.length;i++) { // �Ѹ��� ���� ���� ��� ������ġ �缳��
				if(x+25>=foodX[i] && x+25<=foodX[i]+20 
					&& y+25>=foodY[i] && y+25<=foodY[i]+20) {
					foodX[i]=-10; foodY[i]=-10;
					break;
				}
			}
			
			try { // Override�� �޼ҵ�� throws �Ұ���
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} // run
	
	//------------------------------------------------------------
	public static void main(String[] args) {
		new Packman();
	}
}
