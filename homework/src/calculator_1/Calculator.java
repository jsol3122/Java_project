package calculator_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame{
	private String num[]= {"7","8","9","/","4","5","6","*","1","2","←","C","3","-",".","0","=","+"};
	private JButton btn[]= new JButton[18];
	private JLabel dispL, inputL;
	
	public void init() {
		
		dispL = new JLabel("disp 영역");
		inputL = new JLabel("input 영역");
		dispL.setHorizontalAlignment(JLabel.RIGHT);
		inputL.setHorizontalAlignment(JLabel.RIGHT);
		
		// 버튼 18개 만들기
		for(int i=0; i<btn.length; i++) { 
			btn[i]=new JButton(num[i]);
		}
		
		setTitle("하나도 안간단 계산기");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // x눌러서 종료
		setLayout(null);
		setResizable(false);
		
		
		JPanel p = new JPanel(); // 계산값 출력 레이블
		p.setLayout(new GridLayout(2, 1, 10, 5)); 
		p.add(dispL);
		p.add(inputL);
		p.setBounds(5,5,400,120);
		dispL.setOpaque(true); 
		dispL.setBackground(new Color(157,218,244));
		inputL.setOpaque(true); 
		inputL.setBackground(new Color(157,218,244));
		
		add(p);
		
		JPanel p2 = new JPanel(); // <- , C 버튼
		p2.setLayout(new GridLayout(1, 2, 5, 5)); 
		p2.add(btn[10]);
		p2.add(btn[11]);
		p2.setBounds(5,130,400,80);
		btn[10].setBackground(new Color(255,255,255));
		btn[11].setBackground(new Color(255,255,255));
		btn[10].setFont(new Font("굴림체", Font.BOLD, 15));
		btn[11].setFont(new Font("굴림체", Font.BOLD, 15));
		add(p2);
		
		JPanel p3 = new JPanel(); // 4*4 숫자&연산자 버튼
		p3.setLayout(new GridLayout(4, 4, 5, 5)); 
			for(int i=0; i<10; i++) {
				p3.add(btn[i]);
				btn[i].setBackground(new Color(255,255,255));
				btn[i].setFont(new Font("굴림체", Font.BOLD, 15));
			}
			for(int i=12; i<btn.length; i++) {
				p3.add(btn[i]);
				btn[i].setBackground(new Color(255,255,255));
				btn[i].setFont(new Font("굴림체", Font.BOLD, 15));
			}
		p3.setBounds(5,215,400,330);
		add(p3);
		
		setBounds(700, 200,423,585); // 창이 어디에서 처음 뜰지+창크기 결정
		setVisible(true);
	}

	public static void main(String[] args) {
		new Calculator().init();

	}
}
