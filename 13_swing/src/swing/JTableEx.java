package swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

class JTableModel extends AbstractTableModel { // AbstractTableModel은 추상클래스

	// 원래 Object객체형이기 때문에 안의 정수값들도 Integer형으로 넣어야 하지만, AutoBoxing처리하여 int형넣어도 되는 것
	// JDK9부터는 Wrapper Class의 생성자가 사라지고 AutoBoxing됨 - 기본형써도 자동으로 객체형으로 들어감
	// -- 원래는 1234대신 new Integer(1111) 이런 형식으로 객체형사용해야 했음
	Object[][] data = {{"Nari", "마루치", 1234, "옆집친구"},
					   {"One", "오윤아", 1111, "예쁜이"},
				   	   {"tow", "오윤서", 2222, "귀염둥이"},
					   {"three", "아라치", 3333, "동아리 친구"}};
	
	String[] name = {"아이디", "이름", "비밀번호", "구분"}; // 필드명
	// but, 배열로 잡으면, 항목의 수를 수정할 수가 없어서 불편 - 대부분 vector로 잡음
	
	@Override
	public int getRowCount() { // 행의 개수
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return name.length;
	}

	@Override
	public Object getValueAt(int r, int c) { // data값 꺼내오기
		return data[r][c];
	}
	
	@Override
	public void setValueAt(Object ob, int r, int c) { // data값 넣어주기
		data[r][c] = ob;
	}
	
	@Override
	public String getColumnName(int c) { // 특정 column 이름(필드명=타이틀)꺼내기
		return name[c];
	}
	
	@Override
	public boolean isCellEditable(int r, int c) { // 셀 수정 가능 여부 결정
		// return true; -- 전부 수정 가능
		
		// 특정 셀만 수정가능하도록 조건 걸기
		return c==0 ? false : true ; // 0번째 column은 수정 불가능 조건
	}
}
//----------------------------------------------------
public class JTableEx extends JFrame {
	JTable table;
	JTableModel model;
	
	public JTableEx() {
		model = new JTableModel();
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table); // 테이블을 스크롤 위에 올림
		
		add(scroll); // 테이블을 포함한 스크롤 자체를 창에 띄우기
		
		setBounds(800, 150, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JTableEx();

	}

}
