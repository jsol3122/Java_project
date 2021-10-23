package nested;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CardMain { // 여기에 상속으로 Frame잡으면 이 클래스 자체가 창이 됨
	private Frame frame; // 따로 Frame을 잡은 것
	private CardLayout card;
	
	public CardMain() {
		frame = new Frame();	// 클래스에 상속을 안하고 따로 필드에 잡았으면, 이렇게 생성해줘야 창이 뜸
		card = new CardLayout();
		
		frame.setLayout(card);	// frame의 레이아웃 설정
		
		Panel[] p = new Panel[7];
		Color[] color = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.ORANGE};
		String title[] = {"빨강", "초록", "파랑", "노랑", "보라", "하늘", "주황"};
		for(int i=0; i<p.length; i++) {
			p[i]=new Panel(); // JPanel 생성
			p[i].setBackground(color[i]); // 패널에 바탕색 설정
			
			frame.add(p[i], title[i]); // 패널 프레임에 올리기 + 각 패널에 이름부여
		}
		
		for(int i=0; i<p.length; i++) {
			p[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					card.next(frame);
				}
			});
		} // for
		
		frame.setBounds(800, 150, 200, 200);
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {	// this로 하면 생성자/클래스가 불러오는거임 - frame지정
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	} // 생성자

	public static void main(String[] args) {
		new CardMain();

	} // main

} // class
