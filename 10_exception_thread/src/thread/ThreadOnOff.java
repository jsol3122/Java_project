package thread;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThreadOnOff extends JFrame implements Runnable {
	private JLabel label;
	private JButton btn;
	private int count;
	private boolean onoff; // ���콺 ���� ������ while�� �������ͼ� ��׶��忡�� ���� �ʵ���
	
	public ThreadOnOff() {
		label = new JLabel("0", JLabel.CENTER);
		label.setFont(new Font("���ü", Font.BOLD, 70));
		label.setForeground(Color.RED);
		btn = new JButton("������"); // �ڴ������ִ°� acion�����ʿ� ���, mouse������ �̿�
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(btn);
		
		add("Center", label);
		add("South", p);
		
		setBounds(700, 200, 300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		btn.addMouseListener(new MouseAdapter() { // �߻�޼ҵ� ���� �߻�Ŭ�����ϱ� override ���ص���
			Thread t;
			@Override
			public void mousePressed(MouseEvent e) { // �� ������ �ֱ�
				// �͸�innerŬ���� ���� this�� �͸���Ŭ������ ��Ī�ع��� BUT ������ �ܺ�Ŭ������ ��Ī�ؾ���
				// thread ���� - this�� �ܺ�Ŭ���� ��Ī�ؾ� �ϹǷ� ThreadOnOff�� this���� �˷���
				t = new Thread(ThreadOnOff.this); // thread ����
				t.start();
				System.out.println("������ t = "+t);
				onoff = true;
			}
			
			@Override
			public void mouseReleased(MouseEvent e) { // �����ٰ� ����
				t = null; // thread ����
				System.out.println("�ն��� t = "+t);
				onoff = false;
			}
		});
	} // ������
	
	@Override
	public void run() {
		while(true) { // true ��� onoff������ �־��൵ ��
			count++;
			label.setText(count+""); // ���ڸ� ���ڿ��� ��ȯ
			
			if(!onoff) break; // onoff=true�϶� ��������, �� �ݴ�(false)�϶� while�� �����
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(count>=50) count=0; // �ö󰡴� ���� �ִ� 50���� ���� - ������ �ٽ� 0���� �ʱ�ȭ
		} // while
		
	}
	
	public static void main(String[] args) {
		new ThreadOnOff();
	}

}
