package calculator_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame implements ActionListener {
	StringBuffer dispBuffer = new StringBuffer(); 
	StringBuffer buffer = new StringBuffer(); 
	private String num[]= {"7","8","9","/","4","5","6","*","1","2","��","C","3","-",".","0","=","+"};
	private JButton btn[]= new JButton[18];
	private JLabel dispL, inputL;
	private double result=0; // ó����, �߰������ ����
	private char op=0; 
	private DecimalFormat df = new DecimalFormat("#,###.#######");
	
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
		
		setTitle("���� ����");
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
		
		if(	e.getActionCommand()=="0" ||
			e.getActionCommand()=="1" ||
			e.getActionCommand()=="2" ||
			e.getActionCommand()=="3" ||
			e.getActionCommand()=="4" ||
			e.getActionCommand()=="5" ||
			e.getActionCommand()=="6" ||
			e.getActionCommand()=="7" ||
			e.getActionCommand()=="8" ||
			e.getActionCommand()=="9") {	// ���� �Է� 
			if(dispBuffer.length()==0 && e.getActionCommand()=="0") return; // ó�� 0�� ������ ����
		inputL.setText("");
		dispBuffer.append(e.getActionCommand());
		buffer.append(e.getActionCommand());
		dispL.setText(dispBuffer.toString());
		inputL.setText(buffer.toString());
		
		}else if(e.getActionCommand()=="C") {	// C�� ������� 
			buffer.delete(0, buffer.length());
			dispBuffer.delete(0, dispBuffer.length());
			result=op=0;
			dispL.setText("");
			inputL.setText("0");
			
		}else if(e.getActionCommand()=="��") {	// ��� �ѱ��� ����� 
			if(buffer.length()>0) {
				dispBuffer.deleteCharAt(dispBuffer.length()-1);
				dispL.setText(dispBuffer.toString());
				buffer.deleteCharAt(buffer.length()-1);
				inputL.setText(buffer.toString());
			} // else if(buffer.length()==0)�϶� 0���� setText�϶�� �ϸ� deleteCharAt�Ƚᵵ��
			
		}else if(e.getActionCommand()==".") {// . ������ �߰� or ������ ��� / . �� �Ѱ��� ��� 
			if(buffer.indexOf(".")==-1) {
				dispBuffer.append(e.getActionCommand());
				buffer.append(e.getActionCommand());
				dispL.setText(dispBuffer.toString());
				inputL.setText(buffer.toString());
			}
		}else if(e.getActionCommand()=="+" ||
				 e.getActionCommand()=="-" ||
				 e.getActionCommand()=="*" ||
				 e.getActionCommand()=="/" ||
				 e.getActionCommand()=="=") {	// +-*/= ������ ó�� --------------------------------------------
			if(op==0 && buffer.length()>0) { // ù �������� ��
				result = Double.parseDouble(buffer.toString());
				dispBuffer.append(e.getActionCommand());
				dispL.setText(dispBuffer.toString());
				op = dispBuffer.charAt(dispBuffer.length()-1);
				buffer.delete(0, buffer.length());
				
			}else if(op!=0 && buffer.length()>0) { // ������ �̹� ���� ��
				if(op=='+') {
				result += Double.parseDouble(buffer.toString());
				buffer.delete(0, buffer.length());
				inputL.setText("");
				dispBuffer.append(e.getActionCommand());
				dispL.setText(dispBuffer.toString());
				op = dispBuffer.charAt(dispBuffer.length()-1);
				buffer.append(result);
				inputL.setText(df.format(result).toString());
				buffer.delete(0, buffer.length());
					if(e.getActionCommand()=="=") { // = �� �� ó��
						result=op=0;
						dispBuffer.delete(0, dispBuffer.length());
						dispL.setText(dispBuffer.toString());
					}
				} // + ����
				else if(op=='-') {
				result -= Double.parseDouble(buffer.toString());
				buffer.delete(0, buffer.length());
				inputL.setText("");
				dispBuffer.append(e.getActionCommand());
				dispL.setText(dispBuffer.toString());
				op = dispBuffer.charAt(dispBuffer.length()-1);
				buffer.append(result);
				inputL.setText(df.format(result).toString());
				buffer.delete(0, buffer.length());
					if(e.getActionCommand()=="=") { // = �� �� ó��
						result=op=0;
						dispBuffer.delete(0, dispBuffer.length());
						dispL.setText(dispBuffer.toString());
					}
				} // - ����
				else if(op=='*') {
				result *= Double.parseDouble(buffer.toString());
				buffer.delete(0, buffer.length());
				inputL.setText("");
				dispBuffer.append(e.getActionCommand());
				dispL.setText(dispBuffer.toString());
				op = dispBuffer.charAt(dispBuffer.length()-1);
				buffer.append(result);
				inputL.setText(df.format(result).toString());
				buffer.delete(0, buffer.length());
					if(e.getActionCommand()=="=") { // = �� �� ó��
						result=op=0;
						dispBuffer.delete(0, dispBuffer.length());
						dispL.setText(dispBuffer.toString());
					}
				} // * ����
				else if(op=='/') {
				result /= Double.parseDouble(buffer.toString());
				buffer.delete(0, buffer.length());
				inputL.setText("");
				dispBuffer.append(e.getActionCommand());
				dispL.setText(dispBuffer.toString());
				op = dispBuffer.charAt(dispBuffer.length()-1);
				buffer.append(result);
				inputL.setText(df.format(result).toString());
				buffer.delete(0, buffer.length());
					if(e.getActionCommand()=="=") { // = �� �� ó��
						result=op=0;
						dispBuffer.delete(0, dispBuffer.length());
						dispL.setText(dispBuffer.toString());
					}
				} // / ����
			} 
		
		}// ������ ��
	}// actionEvent

	public static void main(String[] args) {
		new Calculator().init();
	} // main
}
