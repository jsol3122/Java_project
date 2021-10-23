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

public class MemberMain extends Frame { // frame����ϰų� or new Frame��Ƽ� ���ų� �� �� �ϳ��� ����! (�Ѵ��ϸ� ��ȿ��)
	private CardLayout card;
	private Button hBtn, wBtn, lBtn;
	
	public MemberMain() {
		card = new CardLayout();
		
		hBtn = new Button("Ȩ");
		wBtn = new Button("ȸ������");
		lBtn = new Button("�α���");
		
		Panel p = new Panel();
		p.add(hBtn);
		p.add(wBtn);
		p.add(lBtn);
		
		Panel can = new Panel();
		can.setBackground(Color.BLACK);
		can.setLayout(card);
		
		can.add("1", new HomePanel()); // �̷��� ���� �гη� ����� �����ڸ� �ҷ����� �ϸ� private�̾ ��
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
		
		// �̺�Ʈ
		this.addWindowListener(new WindowAdapter() { // x ���� ���� - inner class
		@Override
		public void windowClosing(WindowEvent e) { 
			System.exit(0);
			}
		});
	} // ������
	
//-----------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new MemberMain();
	} // main

}
