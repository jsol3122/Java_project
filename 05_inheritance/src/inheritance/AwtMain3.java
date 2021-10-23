package inheritance;

import java.awt.Button;
import java.awt.Frame;

public class AwtMain3 extends Frame{
	private Button newBtn, exitBtn;
	
	public void init() {
		newBtn = new Button("새로만들기");
		exitBtn = new Button("종료");
		
		setLayout(null); // layout을 아예 다 없애버리기
		newBtn.setBounds(100, 100, 120, 50); // 버튼의 위치와 크기 지정
		exitBtn.setBounds(100, 180, 120, 50);
		add(newBtn); // 버튼 생성
		add(exitBtn);
		setTitle("창");
		setBounds(900,200,300,400); 
		setVisible(true);
	}

	public static void main(String[] args) {
		new AwtMain3().init();

	}

}
