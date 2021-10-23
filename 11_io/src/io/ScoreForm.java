package io;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ScoreForm extends JFrame implements ActionListener{
	private JLabel hakL, nameL, korL, engL, mathL;
	private JTextField hakT, nameT, korT, engT, mathT;
	private JButton inputBtn, printBtn, serchBtn, rankBtn, saveBtn, loadBtn;
	private DefaultTableModel model;
	private JTable table;
	private Score score;
	
	public ScoreForm() {
		
		JPanel p = new JPanel(); // ���� �г�
		p.setLayout(new GridLayout(5, 1, 5, 20));
		// �г� 5�� ( ���� ��+�ؽ�Ʈ�ʵ� ������ �Ѱ��� �гη� ���� )
		
		JPanel hakP = new JPanel();
		hakL = new JLabel("�й�");
		hakT = new JTextField("", 22); // �ؽ�Ʈ�ʵ� ũ�� ����
		hakP.add(hakL);
		hakP.add(hakT);
		JPanel nameP = new JPanel();
		nameL = new JLabel("�̸�");
		nameT = new JTextField("", 22);
		nameP.add(nameL);
		nameP.add(nameT);
		JPanel korP = new JPanel();
		korL = new JLabel("����");
		korT = new JTextField("", 22);
		korP.add(korL);
		korP.add(korT);
		JPanel engP = new JPanel();
		engL = new JLabel("����");
		engT = new JTextField("", 22);
		engP.add(engL);
		engP.add(engT);
		JPanel mathP = new JPanel();
		mathL = new JLabel("����");
		mathT = new JTextField("", 22);
		mathP.add(mathL);
		mathP.add(mathT);
		
		p.add(hakP);
		p.add(nameP);
		p.add(korP);
		p.add(engP);
		p.add(mathP);
		
		Vector<String> vector = new Vector<String>();
		vector.addElement("�й�");
		vector.addElement("�̸�");
		vector.addElement("����");
		vector.addElement("����");
		vector.addElement("����");
		vector.addElement("����");
		vector.addElement("���");
		
		model = new DefaultTableModel(vector, 0);		
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		score = new ScoreImpl(); // ���յ� ���� ��� - �ڽ�Ŭ���� ������� ���
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1, 6, 5, 5));
		inputBtn = new JButton("�Է�");
		printBtn = new JButton("���");
		serchBtn = new JButton("�й��˻�");
		rankBtn = new JButton("����");
		saveBtn = new JButton("��������");
		loadBtn = new JButton("�����б�");
		p2.add(inputBtn);
		p2.add(printBtn);
		p2.add(serchBtn);
		p2.add(rankBtn);
		p2.add(saveBtn);
		p2.add(loadBtn);
		
		Container c = this.getContentPane();
		c.add(p, "West");
		c.add(scroll, "Center");
		c.add(p2, "South");
		
		setBounds(800, 150, 700, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		event(); // �̺�Ʈ�� ���� �޼ҵ� ���� ȣ���ص� �� - ������ �Ȱǵ帮�ڴ�
	}
	
	public void event() {
		inputBtn.addActionListener(this);
		printBtn.addActionListener(this);
		serchBtn.addActionListener(this);
		rankBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		loadBtn.addActionListener(this);
	} // event()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inputBtn) {
			input();
			//score.print(model); - �Էµ� ������ ����ϱ� ���� model�ּҰ������� ó���Ϸ� ��
		}else if(e.getSource() == printBtn) {
			score.print(model);
		}else if(e.getSource() == serchBtn) {
			score.search(model);
		}else if(e.getSource() == rankBtn) {
			score.tot_desc(); // �������� ��������
			score.print(model);
		}else if(e.getSource() == saveBtn) {
			score.save();
		}else if(e.getSource() == loadBtn) {
			score.load();
			score.print(model);
		}
		
	} // �׼Ǹ�����

	public void input() {
		// �̹��� ��ҹ�ư�� ���� ������ null�� ������ �ʰ� ������ ����
		String hak = hakT.getText(); // �Է� ���ϰ� ��ư������ null �ƴ϶� ""�Էµ�
		if(hak.equals("")) { // hak.length()==0 �� ��쵵 �Է� ���� ���
			JOptionPane.showMessageDialog(this, "�й��� �Է��ϼ���");
			return;
		}
		String name = nameT.getText();
		int kor = Integer.parseInt(korT.getText());
		int eng = Integer.parseInt(engT.getText());
		int math = Integer.parseInt(mathT.getText());
		
		int tot = kor + eng + math;
		double avg = tot/3.;
		
		ScoreDTO dto = new ScoreDTO();
		dto.setHak(hak);
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMath(math);
		dto.setTot(tot);
		dto.setAvg(avg);
		
		// ù��°��� - ScoreDTO�� list�� ��Ƽ� JTable�� �Ѹ��� ���Ͽ� ����
		score.input(dto);
		
		// �ι�°��� - ScoreDTO�� ������ ScoreDAO���� DB�� �Է� (list ����Ƶ���)
		
		// ���� ������ �Է� �Ŀ� �ؽ�Ʈ�ʵ��� ���ڸ� �� ���������
		hakT.setText("");
		nameT.setText("");
		korT.setText("");
		engT.setText("");
		mathT.setText("");
		
	} // input()

}
