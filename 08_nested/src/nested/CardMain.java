package nested;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CardMain { // ���⿡ ������� Frame������ �� Ŭ���� ��ü�� â�� ��
	private Frame frame; // ���� Frame�� ���� ��
	private CardLayout card;
	
	public CardMain() {
		frame = new Frame();	// Ŭ������ ����� ���ϰ� ���� �ʵ忡 �������, �̷��� ��������� â�� ��
		card = new CardLayout();
		
		frame.setLayout(card);	// frame�� ���̾ƿ� ����
		
		Panel[] p = new Panel[7];
		Color[] color = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.ORANGE};
		String title[] = {"����", "�ʷ�", "�Ķ�", "���", "����", "�ϴ�", "��Ȳ"};
		for(int i=0; i<p.length; i++) {
			p[i]=new Panel(); // JPanel ����
			p[i].setBackground(color[i]); // �гο� ������ ����
			
			frame.add(p[i], title[i]); // �г� �����ӿ� �ø��� + �� �гο� �̸��ο�
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
		
		frame.addWindowListener(new WindowAdapter() {	// this�� �ϸ� ������/Ŭ������ �ҷ����°��� - frame����
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	} // ������

	public static void main(String[] args) {
		new CardMain();

	} // main

} // class
