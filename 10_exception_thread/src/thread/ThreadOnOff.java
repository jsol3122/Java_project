package thread;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThreadOnOff extends JFrame implements Runnable {
	private JLabel label;
	private JButton btn;
	private int count;
	private boolean onoff; // 마우스 떼면 강제로 while문 빠져나와서 백그라운드에서 돌지 않도록
	
	public ThreadOnOff() {
		label = new JLabel("0", JLabel.CENTER);
		label.setFont(new Font("고딕체", Font.BOLD, 70));
		label.setForeground(Color.RED);
		btn = new JButton("누르기"); // 꾹누르고있는건 acion리스너에 없어서, mouse리스너 이용
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(btn);
		
		add("Center", label);
		add("South", p);
		
		setBounds(700, 200, 300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		btn.addMouseListener(new MouseAdapter() { // 추상메소드 없는 추상클래스니까 override 안해도됨
			Thread t;
			@Override
			public void mousePressed(MouseEvent e) { // 꾹 누르고 있기
				// 익명inner클래스 안의 this는 익명내부클래스를 지칭해버림 BUT 지금은 외부클래스를 지칭해야함
				// thread 생성 - this는 외부클래스 지칭해야 하므로 ThreadOnOff의 this임을 알려줌
				t = new Thread(ThreadOnOff.this); // thread 생성
				t.start();
				System.out.println("누르기 t = "+t);
				onoff = true;
			}
			
			@Override
			public void mouseReleased(MouseEvent e) { // 눌렀다가 떼기
				t = null; // thread 해제
				System.out.println("손떼기 t = "+t);
				onoff = false;
			}
		});
	} // 생성자
	
	@Override
	public void run() {
		while(true) { // true 대신 onoff변수를 넣어줘도 됨
			count++;
			label.setText(count+""); // 숫자를 문자열로 변환
			
			if(!onoff) break; // onoff=true일때 들어왔으니, 그 반대(false)일때 while을 벗어나라
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(count>=50) count=0; // 올라가는 숫자 최댓값 50으로 설정 - 넘으면 다시 0으로 초기화
		} // while
		
	}
	
	public static void main(String[] args) {
		new ThreadOnOff();
	}

}
