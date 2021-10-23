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
	private Racer[] racer; // canvas임 , 말이 몇마리 뛸건지 입력받아 배열로 그때그때 설정
	
	public RunRace(int count) {
		Scanner scan = new Scanner(System.in);
		this.count = count;
		JPanel southP = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btn = new JButton("시작");
		southP.add(btn);
		add("South", southP);
		
		// panel은 기본적으로 flowlayout - 현재는 행렬배치 필요하므로 gridlayout설정
		JPanel centerP = new JPanel(new GridLayout(count, 1)); 
		racer = new Racer[count]; // 배열 생성 - 클래스는 아직x
		String horseName = null;
		for(int i=0; i<count; i++) { // 스레드 생성 - racer자체는 스레드는 아님
			System.out.print("말 이름 입력 : ");
			horseName = scan.next();
			racer[i] = new Racer(horseName); // 여러개의 캔버스가 각각 들어감 
			centerP.add(racer[i]);
		}
		add("Center", centerP);	
		
		btn.addActionListener(this);
		
		setBounds(800, 150, 600, 400);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	} // 생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {
		btn.setEnabled(false); // 버튼 한번 눌렀으면 다신 못누르게 비활성화
		
		Thread[] t = new Thread[count]; // 배열만 생성
		for(int i=0; i<count; i++) {
			t[i] = new Thread(racer[i]); // Racer로 스레드 생성 
			
			int num = (int)(Math.random()*10)+1; // 1~10 난수발생해서 우선순위 랜덤설정
			t[i].setPriority(num);
			
			t[i].start(); // Racer의 run()에서 시작
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("말마리 수 입력 : ");
		int count = scan.nextInt();
		
		new RunRace(count);
	} // main
}
