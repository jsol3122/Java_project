package swing;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class JListEx extends JFrame{ // 기본적으로 BorderLayout
	
	public JListEx() {
		super("JList Test"); // 부모생성자 호출 - 제목설정
		
		setLayout(new FlowLayout());
		
		String[] listData = {"Hong", "Gil", "Dong", "JAVA", "JSP"}; // 리스트 안의 값들 설정
		JList<String> list1 = new JList<String>(listData);
		list1.setSelectedIndex(1); // 1번 리스트에 초점 맞춘 것을 기본설정으로 하기
		
		//DefaultListModel<String> model = new DefaultListModel<String>();
		//JList<String> list2 = new JList<String>(model);
		
		JList<String> list2 = new JList<String>(new DefaultListModel<String>());
		DefaultListModel<String> model = (DefaultListModel<String>) list2.getModel(); // 자식 = (자식)부모 형식
		model.addElement("사과");
		model.addElement("배");
		model.addElement("딸기");
		model.addElement("바나나");
		list2.setSelectedIndex(1);
		
		Vector<String> vListData = new Vector<String>();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3); // scrollbar에 list를 올렸음
		vListData.add("축구");
		vListData.add("야구");
		vListData.add("농구");
		vListData.add("배구");
		vListData.add("테니스");
		vListData.add("수영");
		vListData.add("육상");
		vListData.add("태권도");
		vListData.add("유도");
		
		class Student{ // Local inner class - 메소드 내에서만 사용 가능
			String id;
			String name;
			String department;
			
			public Student(String id, String name, String department) {
				super();
				this.id = id;
				this.name = name;
				this.department = department;
			} // 생성자
			
			@Override
			public String toString() {
				return name;
			}
		}
		
		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
		DefaultListModel<Student> model2 = (DefaultListModel<Student>) list4.getModel();
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 한 항목만 선택가능 설정
		model2.addElement(new Student("100", "홍길동", "전산과"));
		model2.addElement(new Student("200", "손오공", "건축과"));
		model2.addElement(new Student("300", "사오정", "토목과"));
		model2.addElement(new Student("400", "저팔계", "경영학"));
		list4.setSelectedIndex(1);
		
		add(list1);
		add(list2);
		add(scroll); // list3를 담고있는 scroll을 창에 띄워야 함
		add(list4);
		
		setBounds(800, 200, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new JListEx();

	}

}
