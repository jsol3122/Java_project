package calculator_2;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame implements ActionListener {
	StringBuffer buffer = new StringBuffer(); 
	StringBuffer dispBuffer = new StringBuffer(); 
	private String num[]= {"7","8","9","/","4","5","6","*","1","2","��","C","3","-",".","0","=","+"};
	private JButton btn[]= new JButton[18];
	private JLabel dispL, inputL;
	
	public void init() { // ��ü�г��� center�� �ϳ� ��� �� �ȿ� �г�7���� �־ ��
		
		dispL = new JLabel("");
		inputL = new JLabel("0");
		dispL.setHorizontalAlignment(JLabel.RIGHT);
		inputL.setHorizontalAlignment(JLabel.RIGHT);
		
		// ��ư 18�� �����
		for(int i=0; i<btn.length; i++) { 
			btn[i]=new JButton(num[i]);
			btn[i].addActionListener(this);
		}
		
		setTitle("�ϳ��� �Ȱ��� ����");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // x������ ����
		setLayout(null);
		setResizable(false); // â ũ������ �ȵǰ� ���Ƶ�
		
		
		JPanel p = new JPanel(); // ��갪 ��� ���̺�
		p.setLayout(new GridLayout(2, 1, 10, 5)); 
		p.add(dispL);
		p.add(inputL);
		p.setBounds(5,5,400,120);
		dispL.setOpaque(true); 
		dispL.setBackground(new Color(157,218,244));
		inputL.setOpaque(true); 
		inputL.setBackground(new Color(157,218,244));
		dispL.setFont(new Font("����ü", Font.BOLD, 15));
		inputL.setFont(new Font("����ü", Font.BOLD, 15));
		
		add(p);
		
		JPanel p2 = new JPanel(); // <- , C ��ư
		p2.setLayout(new GridLayout(1, 2, 5, 5)); 
		p2.add(btn[10]);
		p2.add(btn[11]);
		p2.setBounds(5,130,400,80);
		btn[10].setBackground(new Color(255,255,255));
		btn[11].setBackground(new Color(255,255,255));
		btn[10].setFont(new Font("����ü", Font.BOLD, 15));
		btn[11].setFont(new Font("����ü", Font.BOLD, 15));
		add(p2);
		
		JPanel p3 = new JPanel(); // 4*4 ����&������ ��ư
		p3.setLayout(new GridLayout(4, 4, 5, 5)); 
			for(int i=0; i<10; i++) {
				p3.add(btn[i]);
				btn[i].setBackground(new Color(255,255,255));
				btn[i].setFont(new Font("����ü", Font.BOLD, 15));
			}
			for(int i=12; i<btn.length; i++) {
				p3.add(btn[i]);
				btn[i].setBackground(new Color(255,255,255));
				btn[i].setFont(new Font("����ü", Font.BOLD, 15));
			}
		p3.setBounds(5,215,400,330);
		add(p3);
			
		setBounds(900,200,425,587); // â�� ��𿡼� ó�� ����+âũ�� ����
		setVisible(true);
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//inputL.setText("0");
		for(int i=0; i<btn.length; i++) {
			if(e.getSource()==btn[i]) {	// ���� �Է�
		buffer.append(btn[i].getText());
		inputL.setText(buffer.toString());
			}else if(e.getActionCommand()=="C") {	// C�� �������
				buffer.delete(0, buffer.length());
				inputL.setText("0");
			}else if(e.getActionCommand()=="��") {	// ��� �ѱ��� �����
				if(buffer.length()>0) {
					buffer.deleteCharAt(buffer.length()-1);
					inputL.setText(buffer.toString());
					break;
				} // else if(buffer.length()==0)�϶� 0���� setText�϶�� �ϸ� deleteCharAt�Ƚᵵ��
			}else if(e.getActionCommand()=="0") {	// 0�϶� 0�������ʱ�
				if(buffer.length()==0) {
					inputL.setText("0");
					return;
				}
			}else if(e.getActionCommand()==".") {	// . ������ �߰� or ������ ��� / . �� �Ѱ��� ���
				if(buffer.indexOf(".")>=0) {
					inputL.setText(buffer.toString());
					return;
				}
			}
		}
	}// actionEvent

	public static void main(String[] args) {
		new Calculator().init();
	} // main
}
		