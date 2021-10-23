package inheritance;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SwingMain extends JFrame{

	private JButton northBtn, southBtn, eastBtn, westBtn, centerBtn; //클래스형은 기본값 null
	// NullPointerException : new생성을 안해서 기본값인 null값만 있어서 에러
	
	public void init() { // 생성자 대신 초기화메소드 잡기 - static아님
		// 버튼생성 - 버튼의 크기는 고정x(창크기 줄였다 키웠다 하면 변동)
		northBtn = new 	JButton("북쪽");
		southBtn = new JButton("남쪽");
		eastBtn = new JButton("동쪽");
		westBtn = new JButton("서쪽");
		centerBtn = new JButton(new ImageIcon("멍멍.gif"));
		
		//배치 - 요소들의 위치를 이동시켜 설정하는 것
		add("North", northBtn); // BorderLayout으로 이미 설정된 North구역에 northBtn을 배치시킨 것
		add("South", southBtn);
		add("East", eastBtn);
		add("West", westBtn);
		add("Center", centerBtn);
		
		setBounds(900,200,300,400); 
		setVisible(true); 
	}

	public static void main(String[] args) {
		new SwingMain().init();  
	}

}
