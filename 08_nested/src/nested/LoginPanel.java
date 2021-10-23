package nested;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginPanel extends Panel implements ActionListener {
	//public Panel loginp; -- ���⼭ �г� ���� ����� ������ ��ü�� �̿�����(Panel���������)
	private Label l1, l2, l3;
	private TextField t1, t2;
	private Button b1, b2;

	public LoginPanel(){
		setLayout(null);
		
		l1 = new Label(" ���̵�");
		l2 = new Label("��й�ȣ");
		//l3 = new Label("");
		t1 = new TextField();
		t2 = new TextField();
		b1 = new Button("�α���");
		b2 = new Button("�ٽ��ۼ�");
		
		l1.setBounds(80, 50, 50, 30);
		l2.setBounds(80, 150, 50, 30);
		//l3.setBounds(165, 250, 200, 30); // �α��� ���� or ����
		t1.setBounds(150, 50, 150, 30);
		t2.setBounds(150, 150, 150, 30);
		b1.setBounds(100, 350, 90, 40);
		b2.setBounds(200, 350, 90, 40);
		
		Font f1 = new Font("�������", 1, 20); // �۲� ũ��
		
		t1.setFont(f1); // ������ �۲��� ����
		t2.setFont(f1);

		add(l1);
		add(l2);
		//add(l3);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		
		setBackground(Color.YELLOW);

		// ��ư �̺�Ʈ ----------------------------------
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	} // ������
	
	@Override
	public void actionPerformed(ActionEvent e) { // ��ư�̺�Ʈ - �α����� dto���� �Ⱦ�
		if(e.getSource()==b2) { // �ٽ��ۼ� - b2
			t1.setText("");
			t2.setText("");
		}
		else if(e.getSource()==b1) { // �α��� - b1
			String id = t1.getText();
			String pwd = t2.getText();
			
			MemberDAO dao = new MemberDAO();
			String name = dao.selectMember(id, pwd); // �α��� ����or���� return�޾Ƽ� �󺧿� ���
			
			if(name == null) JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�");
			// l3.setText(name); -- �󺧿� �ȶ��� �˾����̾�α׷� ������� ����
			else JOptionPane.showMessageDialog(null, name+"���� �α����ϼ̽��ϴ�");
		}
	} // actionPerformed
}// class
