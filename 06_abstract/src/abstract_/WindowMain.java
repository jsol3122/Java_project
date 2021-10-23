package abstract_;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

public class WindowMain extends Frame {
	private Button initBtn, upBtn, downBtn, leftBtn, rightBtn;
	
	public WindowMain() {
		setTitle("이미지");
		setSize(400,400);
		setVisible(true);
		//setVisible(false);로 다음창으로 넘어가며 더이상 안쓰는 창을 닫기도 함
		
		Panel p = new Panel();
		p.setLayout(new GridLayout(1,5,5,5));
		Button initBtn = new Button("초기화");
		p.add(initBtn);
		Button leftBtn = new Button("왼쪽");
		p.add(leftBtn);
		Button upBtn = new Button("위");
		p.add(upBtn);
		Button downBtn = new Button("아래");
		p.add(downBtn);
		Button rightBtn = new Button("오른쪽");
		p.add(rightBtn);
		p.setBounds(0,0,400,70);
		add("North",p);
	}
	@Override
	public void paint(Graphics g) { 
		g.drawString("카카오 이미지", 50, 80); 
		
		//이미지 불러오기 클래스 생성 --> 추상클래스라 new안됨 / 자식클래스도x
		Toolkit t = Toolkit.getDefaultToolkit(); // 생성
		Image img = t.getImage("어피치2.gif"); // 이미지 불러오기
		
		// 이미지 그리기(이미지 갖고있는애, 그릴곳 xy좌표, 어디다그려요?=this=나
		//g.drawImage(img, 30, 120, this); 
		
		// 이미지 작게 (이미지 갖고있는애, 그릴곳 좌표, 원하는화면크기 좌표, 이미지크기 좌표(시작/끝점), 어디다그려요?)
		g.drawImage(img, 30, 120, 200, 300, 0, 0, 638, 614, this);
		
		// 이미지 거꾸로 뒤집히게 --> 이미지크기좌표의 시작점과 끝점을 바꾸면 뒤집힘!!
		//g.drawImage(img, 30, 120, 200, 300, 638, 614, 0, 0, this);
	}
	
	public static void main(String[] args) {
		new WindowMain();

	}

}
