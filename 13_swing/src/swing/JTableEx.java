package swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

class JTableModel extends AbstractTableModel { // AbstractTableModel�� �߻�Ŭ����

	// ���� Object��ü���̱� ������ ���� �������鵵 Integer������ �־�� ������, AutoBoxingó���Ͽ� int���־ �Ǵ� ��
	// JDK9���ʹ� Wrapper Class�� �����ڰ� ������� AutoBoxing�� - �⺻���ᵵ �ڵ����� ��ü������ ��
	// -- ������ 1234��� new Integer(1111) �̷� �������� ��ü������ؾ� ����
	Object[][] data = {{"Nari", "����ġ", 1234, "����ģ��"},
					   {"One", "������", 1111, "������"},
				   	   {"tow", "������", 2222, "�Ϳ�����"},
					   {"three", "�ƶ�ġ", 3333, "���Ƹ� ģ��"}};
	
	String[] name = {"���̵�", "�̸�", "��й�ȣ", "����"}; // �ʵ��
	// but, �迭�� ������, �׸��� ���� ������ ���� ��� ���� - ��κ� vector�� ����
	
	@Override
	public int getRowCount() { // ���� ����
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return name.length;
	}

	@Override
	public Object getValueAt(int r, int c) { // data�� ��������
		return data[r][c];
	}
	
	@Override
	public void setValueAt(Object ob, int r, int c) { // data�� �־��ֱ�
		data[r][c] = ob;
	}
	
	@Override
	public String getColumnName(int c) { // Ư�� column �̸�(�ʵ��=Ÿ��Ʋ)������
		return name[c];
	}
	
	@Override
	public boolean isCellEditable(int r, int c) { // �� ���� ���� ���� ����
		// return true; -- ���� ���� ����
		
		// Ư�� ���� ���������ϵ��� ���� �ɱ�
		return c==0 ? false : true ; // 0��° column�� ���� �Ұ��� ����
	}
}
//----------------------------------------------------
public class JTableEx extends JFrame {
	JTable table;
	JTableModel model;
	
	public JTableEx() {
		model = new JTableModel();
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table); // ���̺��� ��ũ�� ���� �ø�
		
		add(scroll); // ���̺��� ������ ��ũ�� ��ü�� â�� ����
		
		setBounds(800, 150, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JTableEx();

	}

}
