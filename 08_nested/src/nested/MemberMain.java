package nested;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MemberMain extends Frame { // frame상속하거나 or new Frame잡아서 쓰거나 둘 중 하나만 쓰기! (둘다하면 비효율)
	private CardLayout card;
	private Button hBtn, wBtn, lBtn;
	
	public MemberMain() {
		card = new CardLayout();
		
		hBtn = new Button("홈");
		wBtn = new Button("회원가입");
		lBtn = new Button("로그인");
		
		Panel p = new Panel();
		p.add(hBtn);
		p.add(wBtn);
		p.add(lBtn);
		
		Panel can = new Panel();
		can.setBackground(Color.BLACK);
		can.setLayout(card);
		
		can.add("1", new HomePanel()); // 이렇게 각각 패널로 안잡고 생성자만 불러오게 하면 private이어도 됨
		can.add("2", new WritePanel());
		can.add("3", new LoginPanel());
		
		hBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(can, "1");
			}
		});
		wBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(can, "2");
			}
		});
		lBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(can, "3");
			}
		});
		
		add("North", p);
		add("Center", can);
		
		setBounds(800, 150, 400, 500);
		setResizable(false);
		setVisible(true);
		
		// 이벤트
		this.addWindowListener(new WindowAdapter() { // x 눌러 종료 - inner class
		@Override
		public void windowClosing(WindowEvent e) { 
			System.exit(0);
			}
		});
	} // 생성자
	
//-----------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new MemberMain();
	} // main

}
