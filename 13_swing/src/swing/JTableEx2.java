package swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableEx2 extends JFrame implements ActionListener {
	private List<PersonDTO> list; // 부모(List) = 자식(ArrayList) 관계로 잡는 게 더 효율적
	private DefaultTableModel model; 
	// AbstractTableModel 이거써도 상관x
	// DefaultTableModel는 추상클래스 아니어서 override할 것 없음 - 익명inner클래스도 사용가능
	private JTable table;
	private JButton addBtn, delBtn; // 액션리스너 + 메소드이용
	
	public JTableEx2() {
		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("hong", "홍길동", "111", "010-123-1234"));
		list.add(new PersonDTO("conan", "코난", "333", "010-777-7777"));
		
		// 타이틀 - vector는 항목 수 수정 가능해서 대부분 vector 이용 ( 배열은 수정불가능 ) 
		Vector vector = new Vector<String>();
		vector.addElement("아이디");
		vector.addElement("이름");
		vector.add("비밀번호");
		vector.add("핸드폰");
		
		// ( 들어갈 타이틀 , 빈 row 만들어주기=1 or 안만들기=0 )
		// model = new DefaultTableModel(vector, 0); --> 이렇게 추가설정 없이 기본세팅도 가능
		model = new DefaultTableModel(vector, 0) { // 익명 inner 클래스 이용 방법도 가능
			@Override
			public boolean isCellEditable(int r, int c) {
				return c==0 ? false : true ;
			}
		};
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table); // scroll은 일회용이라 필드선언x
		
		// 데이터 입력 - ArrayList는 테이블에 못 넣기 때문에, Vector로 하나씩 넣어줘야함
		for(PersonDTO dto : list) { // list안에 담긴 dto데이터를 vector에 넣어주는 for문
			Vector<String> v = new Vector<String>(); // list 한줄당 vector하나 생성
			v.add(dto.getId()); // 각각의 vector에 dto값 하나씩 넣기
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getPhone());
			
			model.addRow(v); // vector로 담은 데이터를 model에 붙여주기
		}
		
		
		addBtn = new JButton("추가");
		delBtn = new JButton("삭제");
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(addBtn);
		p.add(delBtn);
		
		// contentPane 불러와서 거기에 component들을 올리는 방법 - component들이 많아지면 구분하는게 편함
		Container c = this.getContentPane(); 
		c.add(scroll);
		c.add("South", p);
		
		// 프레임 자체에 component들을 바로 올리는 방법 - component들이 적을 때는 이렇게 해도 괜찮음
		//add(scroll);
		//add("South", p);
		
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
		
		setBounds(800, 150, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	} // 생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addBtn) insert();
		else if(e.getSource() == delBtn) delete();
	} // 액션리스너
	
	public void delete() {
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요");
		if(name==null) return;
		int su = model.getRowCount();
		for(int i=0; i<model.getRowCount(); i++) { // 타이틀은 model에 포함 x
			if(model.getValueAt(i, 1).equals(name)) {
				// 동명이인 다 삭제
				model.removeRow(i);
				i--;
			}
		} // for
		if(su==model.getRowCount())
		JOptionPane.showMessageDialog(this, "없는 이름입니다");
		else JOptionPane.showMessageDialog(this, "삭제 완료");
	} // delete

	public void insert() { 
		String id = JOptionPane.showInputDialog(this, "아이디를 입력하세요");
		if(id==null) {
			JOptionPane.showMessageDialog(this, "아이디는 필수항목입니다");
			return;
		}
		for(PersonDTO dto : list) {
			if(dto.getId().equals(id)) {
				JOptionPane.showMessageDialog(this, "사용중인 아이디입니다");
				return;
			}
		} // for
		
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요");
		String pwd = JOptionPane.showInputDialog(this, "비밀번호를 입력하세요");
		String phone = JOptionPane.showInputDialog(this, "핸드폰번호를 입력하세요");

		Vector<String> v = new Vector<String>(); 
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(phone);
		model.addRow(v);
		JOptionPane.showMessageDialog(this, "등록 완료");
	} // insert

//-------------------------------------------------------------------------------	
	public static void main(String[] args) {
		new JTableEx2();
	}


}
