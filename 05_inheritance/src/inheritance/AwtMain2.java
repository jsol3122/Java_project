package inheritance;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

//Frame에서 기본으로 설정된 BorderLayout(동서남북)은 변경할 수 없고 구역 당 1개의 버튼만 넣을 수 있음
public class AwtMain2 extends Frame{
	private Button newBtn, exitBtn;
	
	public void init() {
		newBtn = new Button("새로만들기");
		exitBtn = new Button("종료");
		
		// 패널(한구역에 여러버튼넣을 수단)은 한번쓰고 버릴거라서 필드말고 지역으로 선언
		// FlowLayout - 가운데를 중심으로 순서대로 배치됨(동서남북x)
		Panel p = new Panel(); 
		p.setLayout(new GridLayout(1, 2, 10, 0)); // 균등한 레이아웃(행열배치)으로 새로 설정
		p.setBackground(new Color(151,225,181)); // 패널색 변경
		p.add(newBtn);
		p.add(exitBtn);
		
		add("North", p); // 버튼 크기는 고정x(글자 길이에 따라 다르게 생성)
		
		//super("창"); --> 이런식으로 부모생성자 호출하려면 나도 생성자여야 함(지금은 초기화메소드)
		setTitle("창");
		
		setBounds(900,200,300,400); 
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AwtMain2().init();

	}

}
