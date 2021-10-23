package thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JFrame;

public class Clock extends JFrame implements Runnable {
	
	@Override
	public void run() {
		while(true) {
			repaint(); // paint()ȣ�� - paint()������ frame�� ������ ȣ�� �Ұ���
			try { // �ʹ� ���� thread�� ��ȯ�Ǵϱ� õõ�� ������ ������ - ����: 1/1000��
				Thread.sleep(1000); // 1000���� �����ϸ� ���ٰ� 1�ʸ��� �����϶�� ��
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		} // while - run()���� ���ѷ����� �ü���� �˾Ƽ� �����Ŵ
	} // run - thread�� �ƴ� �׳ɸ޼ҵ忡�� ���ѷ��� ������ ������ ����������
	
	public Clock() {
		
		setFont(new Font("Arial", Font.BOLD, 36));
		setForeground(Color.RED);
		setTitle("�ð�");
		setBounds(800, 200, 400, 150);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X���� ���� �޼ҵ�
		
		// thread ����
		Thread t = new Thread(this); // this=Clock (������ ���̴ϱ�)
		t.start(); // thread ���� - run()���� ������
		
	} // ������
	
	@Override
	public void paint(Graphics g) { 
		super.paint(g); // ���� �ҷ����� ����
		
		// �ð�� ��� �ð��� �޾ƿͼ� ������ ����ؾ��� -- multi-thread �̿�!
		// �׷��� main�޼ҵ��� frame���� �������� �� (�ѹ��� ������ �ð���ø�ǰ�, ������ ������ �� �� ����)
		Calendar cal = Calendar.getInstance(); // �߻�Ŭ������ new���� x
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		String time = String.format("%02d : %02d : %02d", hour, minute, second);
		// %02d�� ���� �����ϸ� 13:3:4 �� �� 13:03:04ó�� ���ڸ����� ���
		
		g.drawString(time, 100, 90);
	}

	public static void main(String[] args) {
		new Clock();
	}

	
}
