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
	int[] foodX=new int[5]; // 먹이위치값 배열
	int[] foodY=new int[5];
	
	public Packman() {
		// 여기서 Toolkit 생성하는것도 가능
		// Toolkit클래스는 new 생성x / 자식클래스도x
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
		
		for(int i=0; i<foodX.length; i++) { // 먹이 위치 랜덤발생
			this.foodX[i] = (int)(Math.random()*461)+20;
			this.foodY[i] = (int)(Math.random()*461)+20;
		}
		
		Thread t = new Thread(this);
		t.start();
		
	} // 생성자
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// (넣을이미지 / 넣을좌표x,y / 넣을이미지좌표x,y / this) 
		g.drawImage(img, x, y, x+50, y+50, size*50, 0, size*50+50, 50, this);
		
		for(int i=0; i<foodX.length; i++) { // 먹이 5개 프레임위에 띄우기
			g.drawImage(icon, foodX[i], foodY[i], foodX[i]+20, foodY[i]+20, 0, 0, 512, 512, this);
		}
	} // paint
	
	@Override
	public void run() {
		while(true) {
			repaint(); // 키보드 누를때마다 그리는게 아니라, 무한루프에서 repaint넣기
			
			if(size%2==0) size++; // 입벌리고 닫히고 설정 / 50차이니까 그에맞춰 변수값 설정
			else size--;
			
			x=x+mx; // 이동 설정 / 좌표값 설정
			y=y+my;
			
			if(x>500) x=0; // 창 벗어난 경우 다시 창 안으로 돌아오게 하기
			else if(x<0) x=500;
			else if(y>500) y=0;
			else if(y<0) y=500;
			
			for(int i=0;i<foodX.length;i++) { // 팩맨이 먹이 먹을 경우 먹이위치 재설정
				if(x+25>=foodX[i] && x+25<=foodX[i]+20 
					&& y+25>=foodY[i] && y+25<=foodY[i]+20) {
					foodX[i]=-10; foodY[i]=-10;
					break;
				}
			}
			
			try { // Override된 메소드는 throws 불가능
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
