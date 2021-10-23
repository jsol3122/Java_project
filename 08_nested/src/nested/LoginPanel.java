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
	//public Panel loginp; -- 여기서 패널 따로 안잡고 생성자 자체로 이용하자(Panel상속했으니)
	private Label l1, l2, l3;
	private TextField t1, t2;
	private Button b1, b2;

	public LoginPanel(){
		setLayout(null);
		
		l1 = new Label(" 아이디");
		l2 = new Label("비밀번호");
		//l3 = new Label("");
		t1 = new TextField();
		t2 = new TextField();
		b1 = new Button("로그인");
		b2 = new Button("다시작성");
		
		l1.setBounds(80, 50, 50, 30);
		l2.setBounds(80, 150, 50, 30);
		//l3.setBounds(165, 250, 200, 30); // 로그인 성공 or 실패
		t1.setBounds(150, 50, 150, 30);
		t2.setBounds(150, 150, 150, 30);
		b1.setBounds(100, 350, 90, 40);
		b2.setBounds(200, 350, 90, 40);
		
		Font f1 = new Font("맑은고딕", 1, 20); // 글꼴 크기
		
		t1.setFont(f1); // 설정한 글꼴을 적용
		t2.setFont(f1);

		add(l1);
		add(l2);
		//add(l3);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		
		setBackground(Color.YELLOW);

		// 버튼 이벤트 ----------------------------------
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	} // 생성자
	
	@Override
	public void actionPerformed(ActionEvent e) { // 버튼이벤트 - 로그인은 dto거의 안씀
		if(e.getSource()==b2) { // 다시작성 - b2
			t1.setText("");
			t2.setText("");
		}
		else if(e.getSource()==b1) { // 로그인 - b1
			String id = t1.getText();
			String pwd = t2.getText();
			
			MemberDAO dao = new MemberDAO();
			String name = dao.selectMember(id, pwd); // 로그인 성공or실패 return받아서 라벨에 출력
			
			if(name == null) JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀립니다");
			// l3.setText(name); -- 라벨에 안띄우고 팝업다이얼로그로 만들수도 있음
			else JOptionPane.showMessageDialog(null, name+"님이 로그인하셨습니다");
		}
	} // actionPerformed
}// class
