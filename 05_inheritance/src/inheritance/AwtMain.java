package inheritance;

import java.awt.Button;
import java.awt.Frame;

// Frame은 BorderLayout으로 구역이 기본으로 잡혀있음(동서남북)
public class AwtMain extends Frame {
	private Button northBtn, southBtn, eastBtn, westBtn, centerBtn; //클래스형은 기본값 null
	// NullPointerException : new생성을 안해서 기본값인 null값만 있어서 에러
	
	public void init() { // 생성자 대신 초기화메소드 잡기 - static아님
		// 버튼생성 - 버튼의 크기는 고정x(창크기 줄였다 키웠다 하면 변동)
		northBtn = new Button("북쪽");
		southBtn = new Button("남쪽");
		eastBtn = new Button("동쪽");
		westBtn = new Button("서쪽");
		centerBtn = new Button("중앙");
		
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
		AwtMain am = new AwtMain();
		am.init();
		
		//new AwtMain().init();  --> 이렇게 하면 일회용 클래스생성+생성자호출+init호출
	}

}
