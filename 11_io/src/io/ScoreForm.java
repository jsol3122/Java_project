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
		
		JPanel p = new JPanel(); // 왼쪽 패널
		p.setLayout(new GridLayout(5, 1, 5, 20));
		// 패널 5개 ( 각각 라벨+텍스트필드 모음을 한개의 패널로 잡음 )
		
		JPanel hakP = new JPanel();
		hakL = new JLabel("학번");
		hakT = new JTextField("", 22); // 텍스트필드 크기 설정
		hakP.add(hakL);
		hakP.add(hakT);
		JPanel nameP = new JPanel();
		nameL = new JLabel("이름");
		nameT = new JTextField("", 22);
		nameP.add(nameL);
		nameP.add(nameT);
		JPanel korP = new JPanel();
		korL = new JLabel("국어");
		korT = new JTextField("", 22);
		korP.add(korL);
		korP.add(korT);
		JPanel engP = new JPanel();
		engL = new JLabel("영어");
		engT = new JTextField("", 22);
		engP.add(engL);
		engP.add(engT);
		JPanel mathP = new JPanel();
		mathL = new JLabel("수학");
		mathT = new JTextField("", 22);
		mathP.add(mathL);
		mathP.add(mathT);
		
		p.add(hakP);
		p.add(nameP);
		p.add(korP);
		p.add(engP);
		p.add(mathP);
		
		Vector<String> vector = new Vector<String>();
		vector.addElement("학번");
		vector.addElement("이름");
		vector.addElement("국어");
		vector.addElement("영어");
		vector.addElement("수학");
		vector.addElement("총점");
		vector.addElement("평균");
		
		model = new DefaultTableModel(vector, 0);		
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		score = new ScoreImpl(); // 결합도 낮춘 방식 - 자식클래스 많은경우 대비
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1, 6, 5, 5));
		inputBtn = new JButton("입력");
		printBtn = new JButton("출력");
		serchBtn = new JButton("학번검색");
		rankBtn = new JButton("순위");
		saveBtn = new JButton("파일저장");
		loadBtn = new JButton("파일읽기");
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
		
		event(); // 이벤트를 따로 메소드 만들어서 호출해도 됨 - 생성자 안건드리겠다
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
			//score.print(model); - 입력된 정보를 출력하기 위해 model주소값가지고 처리하러 감
		}else if(e.getSource() == printBtn) {
			score.print(model);
		}else if(e.getSource() == serchBtn) {
			score.search(model);
		}else if(e.getSource() == rankBtn) {
			score.tot_desc(); // 총점으로 내림차순
			score.print(model);
		}else if(e.getSource() == saveBtn) {
			score.save();
		}else if(e.getSource() == loadBtn) {
			score.load();
			score.print(model);
		}
		
	} // 액션리스너

	public void input() {
		// 이번엔 취소버튼이 없기 때문에 null값 들어오지 않고 공백이 들어옴
		String hak = hakT.getText(); // 입력 안하고 버튼누르면 null 아니라 ""입력됨
		if(hak.equals("")) { // hak.length()==0 인 경우도 입력 안한 경우
			JOptionPane.showMessageDialog(this, "학번을 입력하세요");
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
		
		// 첫번째방법 - ScoreDTO를 list에 담아서 JTable에 뿌리고 파일에 보관
		score.input(dto);
		
		// 두번째방법 - ScoreDTO를 가지고 ScoreDAO에서 DB에 입력 (list 안잡아도됨)
		
		// 받은 데이터 입력 후엔 텍스트필드의 글자를 다 지워줘야함
		hakT.setText("");
		nameT.setText("");
		korT.setText("");
		engT.setText("");
		mathT.setText("");
		
	} // input()

}
