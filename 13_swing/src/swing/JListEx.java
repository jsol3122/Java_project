package swing;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class JListEx extends JFrame{ // �⺻������ BorderLayout
	
	public JListEx() {
		super("JList Test"); // �θ������ ȣ�� - ������
		
		setLayout(new FlowLayout());
		
		String[] listData = {"Hong", "Gil", "Dong", "JAVA", "JSP"}; // ����Ʈ ���� ���� ����
		JList<String> list1 = new JList<String>(listData);
		list1.setSelectedIndex(1); // 1�� ����Ʈ�� ���� ���� ���� �⺻�������� �ϱ�
		
		//DefaultListModel<String> model = new DefaultListModel<String>();
		//JList<String> list2 = new JList<String>(model);
		
		JList<String> list2 = new JList<String>(new DefaultListModel<String>());
		DefaultListModel<String> model = (DefaultListModel<String>) list2.getModel(); // �ڽ� = (�ڽ�)�θ� ����
		model.addElement("���");
		model.addElement("��");
		model.addElement("����");
		model.addElement("�ٳ���");
		list2.setSelectedIndex(1);
		
		Vector<String> vListData = new Vector<String>();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3); // scrollbar�� list�� �÷���
		vListData.add("�౸");
		vListData.add("�߱�");
		vListData.add("��");
		vListData.add("�豸");
		vListData.add("�״Ͻ�");
		vListData.add("����");
		vListData.add("����");
		vListData.add("�±ǵ�");
		vListData.add("����");
		
		class Student{ // Local inner class - �޼ҵ� �������� ��� ����
			String id;
			String name;
			String department;
			
			public Student(String id, String name, String department) {
				super();
				this.id = id;
				this.name = name;
				this.department = department;
			} // ������
			
			@Override
			public String toString() {
				return name;
			}
		}
		
		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
		DefaultListModel<Student> model2 = (DefaultListModel<Student>) list4.getModel();
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // �� �׸� ���ð��� ����
		model2.addElement(new Student("100", "ȫ�浿", "�����"));
		model2.addElement(new Student("200", "�տ���", "�����"));
		model2.addElement(new Student("300", "�����", "����"));
		model2.addElement(new Student("400", "���Ȱ�", "�濵��"));
		list4.setSelectedIndex(1);
		
		add(list1);
		add(list2);
		add(scroll); // list3�� ����ִ� scroll�� â�� ����� ��
		add(list4);
		
		setBounds(800, 200, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new JListEx();

	}

}
