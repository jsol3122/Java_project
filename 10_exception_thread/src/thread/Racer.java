package thread;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

// �� 1����
public class Racer extends Canvas implements Runnable{ 
	private Image img;
	private String horseName;
	int pos;
	static int rank=1;
	
	public Racer(String horseName) {
		img = Toolkit.getDefaultToolkit().getImage("image/horse.gif");
		this.horseName = horseName;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	
		g.drawImage(img, pos, 0, 25, this.getSize().height, this);
		// this.getSize().height = ĵ������ ũ�⸦���ؼ� ���̸� ������ �� 
		g.drawLine(0, this.getSize().height-1, this.getSize().width, this.getSize().height-1);
	}
	
	@Override
	public void run() {
		for(int i=0; i<600; i+=(int)(Math.random()*10)+1) { // âũ��ȿ��� �پ�� - ������ŭ �̵�
			pos = i;
			repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(pos>=590) {
				System.out.println(this.rank+"�� = "+horseName);
				this.rank++;
				break;
			} // ��� ���
		}
	} // run
}
