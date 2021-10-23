package thread;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

// 말 1마리
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
		// this.getSize().height = 캔버스의 크기를구해서 높이를 가져온 것 
		g.drawLine(0, this.getSize().height-1, this.getSize().width, this.getSize().height-1);
	}
	
	@Override
	public void run() {
		for(int i=0; i<600; i+=(int)(Math.random()*10)+1) { // 창크기안에서 뛰어라 - 랜덤만큼 이동
			pos = i;
			repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(pos>=590) {
				System.out.println(this.rank+"등 = "+horseName);
				this.rank++;
				break;
			} // 등수 출력
		}
	} // run
}
