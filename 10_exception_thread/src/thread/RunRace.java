package thread;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RunRace extends JFrame implements ActionListener{
	private int count;
	private JButton btn;
	private Racer[] racer; // canvas�� , ���� ��� �۰��� �Է¹޾� �迭�� �׶��׶� ����
	
	public RunRace(int count) {
		Scanner scan = new Scanner(System.in);
		this.count = count;
		JPanel southP = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btn = new JButton("����");
		southP.add(btn);
		add("South", southP);
		
		// panel�� �⺻������ flowlayout - ����� ��Ĺ�ġ �ʿ��ϹǷ� gridlayout����
		JPanel centerP = new JPanel(new GridLayout(count, 1)); 
		racer = new Racer[count]; // �迭 ���� - Ŭ������ ����x
		String horseName = null;
		for(int i=0; i<count; i++) { // ������ ���� - racer��ü�� ������� �ƴ�
			System.out.print("�� �̸� �Է� : ");
			horseName = scan.next();
			racer[i] = new Racer(horseName); // �������� ĵ������ ���� �� 
			centerP.add(racer[i]);
		}
		add("Center", centerP);	
		
		btn.addActionListener(this);
		
		setBounds(800, 150, 600, 400);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	} // ������
	
	@Override
	public void actionPerformed(ActionEvent e) {
		btn.setEnabled(false); // ��ư �ѹ� �������� �ٽ� �������� ��Ȱ��ȭ
		
		Thread[] t = new Thread[count]; // �迭�� ����
		for(int i=0; i<count; i++) {
			t[i] = new Thread(racer[i]); // Racer�� ������ ���� 
			
			int num = (int)(Math.random()*10)+1; // 1~10 �����߻��ؼ� �켱���� ��������
			t[i].setPriority(num);
			
			t[i].start(); // Racer�� run()���� ����
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �� �Է� : ");
		int count = scan.nextInt();
		
		new RunRace(count);
	} // main
}
