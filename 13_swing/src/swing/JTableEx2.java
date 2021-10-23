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
	private List<PersonDTO> list; // �θ�(List) = �ڽ�(ArrayList) ����� ��� �� �� ȿ����
	private DefaultTableModel model; 
	// AbstractTableModel �̰Žᵵ ���x
	// DefaultTableModel�� �߻�Ŭ���� �ƴϾ override�� �� ���� - �͸�innerŬ������ ��밡��
	private JTable table;
	private JButton addBtn, delBtn; // �׼Ǹ����� + �޼ҵ��̿�
	
	public JTableEx2() {
		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("hong", "ȫ�浿", "111", "010-123-1234"));
		list.add(new PersonDTO("conan", "�ڳ�", "333", "010-777-7777"));
		
		// Ÿ��Ʋ - vector�� �׸� �� ���� �����ؼ� ��κ� vector �̿� ( �迭�� �����Ұ��� ) 
		Vector vector = new Vector<String>();
		vector.addElement("���̵�");
		vector.addElement("�̸�");
		vector.add("��й�ȣ");
		vector.add("�ڵ���");
		
		// ( �� Ÿ��Ʋ , �� row ������ֱ�=1 or �ȸ����=0 )
		// model = new DefaultTableModel(vector, 0); --> �̷��� �߰����� ���� �⺻���õ� ����
		model = new DefaultTableModel(vector, 0) { // �͸� inner Ŭ���� �̿� ����� ����
			@Override
			public boolean isCellEditable(int r, int c) {
				return c==0 ? false : true ;
			}
		};
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table); // scroll�� ��ȸ���̶� �ʵ弱��x
		
		// ������ �Է� - ArrayList�� ���̺� �� �ֱ� ������, Vector�� �ϳ��� �־������
		for(PersonDTO dto : list) { // list�ȿ� ��� dto�����͸� vector�� �־��ִ� for��
			Vector<String> v = new Vector<String>(); // list ���ٴ� vector�ϳ� ����
			v.add(dto.getId()); // ������ vector�� dto�� �ϳ��� �ֱ�
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getPhone());
			
			model.addRow(v); // vector�� ���� �����͸� model�� �ٿ��ֱ�
		}
		
		
		addBtn = new JButton("�߰�");
		delBtn = new JButton("����");
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(addBtn);
		p.add(delBtn);
		
		// contentPane �ҷ��ͼ� �ű⿡ component���� �ø��� ��� - component���� �������� �����ϴ°� ����
		Container c = this.getContentPane(); 
		c.add(scroll);
		c.add("South", p);
		
		// ������ ��ü�� component���� �ٷ� �ø��� ��� - component���� ���� ���� �̷��� �ص� ������
		//add(scroll);
		//add("South", p);
		
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
		
		setBounds(800, 150, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	} // ������
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addBtn) insert();
		else if(e.getSource() == delBtn) delete();
	} // �׼Ǹ�����
	
	public void delete() {
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");
		if(name==null) return;
		int su = model.getRowCount();
		for(int i=0; i<model.getRowCount(); i++) { // Ÿ��Ʋ�� model�� ���� x
			if(model.getValueAt(i, 1).equals(name)) {
				// �������� �� ����
				model.removeRow(i);
				i--;
			}
		} // for
		if(su==model.getRowCount())
		JOptionPane.showMessageDialog(this, "���� �̸��Դϴ�");
		else JOptionPane.showMessageDialog(this, "���� �Ϸ�");
	} // delete

	public void insert() { 
		String id = JOptionPane.showInputDialog(this, "���̵� �Է��ϼ���");
		if(id==null) {
			JOptionPane.showMessageDialog(this, "���̵�� �ʼ��׸��Դϴ�");
			return;
		}
		for(PersonDTO dto : list) {
			if(dto.getId().equals(id)) {
				JOptionPane.showMessageDialog(this, "������� ���̵��Դϴ�");
				return;
			}
		} // for
		
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");
		String pwd = JOptionPane.showInputDialog(this, "��й�ȣ�� �Է��ϼ���");
		String phone = JOptionPane.showInputDialog(this, "�ڵ�����ȣ�� �Է��ϼ���");

		Vector<String> v = new Vector<String>(); 
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(phone);
		model.addRow(v);
		JOptionPane.showMessageDialog(this, "��� �Ϸ�");
	} // insert

//-------------------------------------------------------------------------------	
	public static void main(String[] args) {
		new JTableEx2();
	}


}
