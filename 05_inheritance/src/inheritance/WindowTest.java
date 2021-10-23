package inheritance;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;

public class WindowTest extends Frame { // Frame클래스와 그 상위클래스의 모든것 다 사용 가능!
	// 함수 걸면 나한테 일단 set~~찾고 없으면 부모클래스인 Frame에서 찾음! 없으면 그위부모, 없으면 그위 부모 ...

	public WindowTest() { 
		//setTitle("내가만든그림판"); // 제목설정
		//new Frame("내가만든그림판").setVisible(true); // 이렇게 하면 새로운 창 하나 더 만든것(visible해야 보임/안하면 안보일뿐)
		super("내가만든그림판"); //부모생성자(Frame생성자) 호출 -> 얘도 생성자니까 다른생성자 호출가능
		
		setFont(new Font("궁서체", Font.BOLD, 32));
		
		//setBackground(Color.YELLOW); // 배경색 설정 - 클래스타입 변수 Color 사용
		setBackground(new Color(151,225,181)); // 이건 일회성
		//Color클래스의 생성자 호출해서 원하는 색의 RGB값 줘서 세밀하게 색조정
		setForeground(Color.WHITE);
		
		//setSize(300,400); 창 크기 가로,세로 설정
		setBounds(900,200,300,400); // 창이 어디에서 처음 뜰지+창크기 결정
		setVisible(true); // 보여주세요~
	}
	
	@Override
	public void paint(Graphics g) { // java.window에 있지만 override되어서 자식인 여기꺼만 수행
		g.drawString("도형", 100, 80); // 위치는 만들어진 창의 왼쪽위모서리가 0,0으로 시작
		g.drawLine(100,100,250,300); // 선 시작점의 x,y축값과 끝점의 x,y축값 입력
		g.drawRect(100,300,150,80); // 사각형만들기
		//g.drawOval(100,300,150,80); // 원만들기 - 중심축 아니라 시작점 지정
		g.fillOval(100,300,150,80); // 안이 색칠된 원 만들기
	}
	
	public static void main(String[] args) {
			WindowTest wt = new WindowTest(); // 이건 일회성x / 한번만쓸거면 new부터만 써도 됨

	}
}
