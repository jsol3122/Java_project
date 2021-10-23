package nested;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class WritePanel extends Panel implements ActionListener {
	//public Panel writep; -- ���� �г� ����� panel��������� �����ڷ� ����
	private Label l1, l2, l3;
	private TextField t1, t2, t3;
	private Button b1, b2;
	
	private Connection conn;
	private PreparedStatement ps;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String username="c##java";
	private String password="bit";
		
		public WritePanel(){
			setLayout(null);
			
			l1 = new Label("  �̸�");
			l2 = new Label(" ���̵�");
			l3 = new Label("��й�ȣ");
			t1 = new TextField();
			t2 = new TextField();
			t3 = new TextField(); // swing������ pwd�� **�� ����� �� ����(���ȸ���)
			b1 = new Button("���");
			b2 = new Button("�ٽ��ۼ�");
			
			l1.setBounds(80, 50, 50, 30);
			l2.setBounds(80, 150, 50, 30);
			l3.setBounds(80, 250, 50, 30);
			t1.setBounds(150, 50, 150, 30);
			t2.setBounds(150, 150, 150, 30);
			t3.setBounds(150, 250, 150, 30);
			b1.setBounds(100, 350, 90, 40);
			b2.setBounds(200, 350, 90, 40);
			
			Font f1 = new Font("�������", 1, 20); // �۲� ũ��
			
			t1.setFont(f1); // ������ �۲��� ����
			t2.setFont(f1);
			t3.setFont(f1);
			
			add(l1);
			add(l2);
			add(l3);
			add(t1);
			add(t2);
			add(t3);
			add(b1);
			add(b2);
			
			setBackground(Color.BLUE);
		
			// ��ư �̺�Ʈ ----------------------------------
			b1.addActionListener(this);
			b2.addActionListener(this);
			
		} // ������
		
		@Override
		public void actionPerformed(ActionEvent e) { // �͸�inner�� �ص� ��
			MemberDTO dto = new MemberDTO();
			if(e.getSource()==b2) { // �ٽ��ۼ�
				t1.setText("");
				t2.setText("");
				t3.setText("");
			}
			else if(e.getSource()==b1) { // ��� dao ȣ��
				dto.setName(t1.getText());
				dto.setId(t2.getText());
				dto.setPwd(t3.getText());
				
				// DAO�� new �����ؼ�, dao.insertMember(name, id, pwd); �ؼ� ������
				// name,id,pwd�� �ϳ��� ������ �ʰ�, DTO�� setter�� �־ dao.insertMember(dto);�� �����°� �� ȿ����
				MemberDAO dao = new MemberDAO();
				int su = dao.insertMember(dto); // return�� �޾��ֱ�
				
				// dialog�� �����̳��̱� ������ ȥ�� �˾� ���� - component�� �Ұ���
				JOptionPane.showMessageDialog(null, "ȸ������ �Ǿ����ϴ�");
			} 
		} // �׼Ǹ�����
} // class
