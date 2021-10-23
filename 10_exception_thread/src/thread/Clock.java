package thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JFrame;

public class Clock extends JFrame implements Runnable {
	
	@Override
	public void run() {
		while(true) {
			repaint(); // paint()호출 - paint()없으면 frame과 별개로 호출 불가능
			try { // 너무 빨리 thread가 전환되니까 천천히 쉬었다 가세요 - 단위: 1/1000초
				Thread.sleep(1000); // 1000으로 설정하면 쉬다가 1초만에 실행하라는 뜻
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		} // while - run()안의 무한루프는 운영체제가 알아서 종료시킴
	} // run - thread가 아닌 그냥메소드에서 무한루프 돌리면 영원히 못빠져나옴
	
	public Clock() {
		
		setFont(new Font("Arial", Font.BOLD, 36));
		setForeground(Color.RED);
		setTitle("시계");
		setBounds(800, 200, 400, 150);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X눌러 종료 메소드
		
		// thread 생성
		Thread t = new Thread(this); // this=Clock (생성자 안이니까)
		t.start(); // thread 시작 - run()으로 가도록
		
	} // 생성자
	
	@Override
	public void paint(Graphics g) { 
		super.paint(g); // 새로 불러오는 역할
		
		// 시계는 계속 시간을 받아와서 무한히 출력해야함 -- multi-thread 이용!
		// 그러나 main메소드의 frame과는 별개여야 함 (한번에 돌리면 시간중첩되고, 영원히 프레임 끌 수 없음)
		Calendar cal = Calendar.getInstance(); // 추상클래스라서 new생성 x
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		String time = String.format("%02d : %02d : %02d", hour, minute, second);
		// %02d로 형식 설정하면 13:3:4 일 때 13:03:04처럼 두자릿수로 출력
		
		g.drawString(time, 100, 90);
	}

	public static void main(String[] args) {
		new Clock();
	}

	
}
