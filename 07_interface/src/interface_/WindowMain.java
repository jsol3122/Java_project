package interface_;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// Frame은 BorderLayout(동서남북센터)
// 동서남북에는 한개의 component만 올라갈 수 있음 - 그래서 패널을 만들어서 버튼 여러개 올리는 것
class WindowTest extends Frame implements ActionListener, MouseListener{
	private Button newBtn, exitBtn;
	private TextArea area;
	
	public void init() {
		newBtn = new Button("새로만들기");
		exitBtn = new Button("종료");
		area = new TextArea(); // 채팅창 만들기 가능
		
		Panel p = new Panel(); // FlowLayout (가운데중심으로 순서대로 배치)
		p.add(newBtn);
		p.add(exitBtn);
		
		this.add("North", p);
		this.add("Center",area);
		
		setBounds(700, 200, 300, 400); 
		// 항상 앞에 this.가 생략된거임
		// this로 자신에서 찾고 없으면 부모, 또없으면 조부모, ...
		setVisible(true);
		
		this.addWindowListener(new WindowExit()); // windowexit클래스에서 구현부를 갖고있다고 지정 - 거기가서 구현하고 돌아옴
		this.addMouseListener(this);
		//내가(this)가 모든것을 override(구현)했으니 JVM이 사건에 맞게 호출해라
		newBtn.addActionListener(this);
		exitBtn.addActionListener(this);
	}

	// MouseListener Override
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭!");
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("마우스 in");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("마우스 out");
	}

	// ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newBtn) { // 초기화 안되는오류나면 area.setText("  ");으로 덮고나서 다시 초기화시키면 됨
			area.setText(""); // 초기화 (area의 text내용 다 지우기)
		}
		else if(e.getActionCommand()=="종료") {
			System.exit(0);
		}
	}
}

//--------------------------------------------
public class WindowMain {

	public static void main(String[] args) {
		new WindowTest().init();

	}

}
