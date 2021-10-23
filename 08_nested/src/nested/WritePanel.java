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
	//public Panel writep; -- 각각 패널 안잡고 panel상속했으니 생성자로 쓰기
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
			
			l1 = new Label("  이름");
			l2 = new Label(" 아이디");
			l3 = new Label("비밀번호");
			t1 = new TextField();
			t2 = new TextField();
			t3 = new TextField(); // swing에서는 pwd를 **로 출력할 수 있음(보안목적)
			b1 = new Button("등록");
			b2 = new Button("다시작성");
			
			l1.setBounds(80, 50, 50, 30);
			l2.setBounds(80, 150, 50, 30);
			l3.setBounds(80, 250, 50, 30);
			t1.setBounds(150, 50, 150, 30);
			t2.setBounds(150, 150, 150, 30);
			t3.setBounds(150, 250, 150, 30);
			b1.setBounds(100, 350, 90, 40);
			b2.setBounds(200, 350, 90, 40);
			
			Font f1 = new Font("맑은고딕", 1, 20); // 글꼴 크기
			
			t1.setFont(f1); // 설정한 글꼴을 적용
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
		
			// 버튼 이벤트 ----------------------------------
			b1.addActionListener(this);
			b2.addActionListener(this);
			
		} // 생성자
		
		@Override
		public void actionPerformed(ActionEvent e) { // 익명inner로 해도 됨
			MemberDTO dto = new MemberDTO();
			if(e.getSource()==b2) { // 다시작성
				t1.setText("");
				t2.setText("");
				t3.setText("");
			}
			else if(e.getSource()==b1) { // 등록 dao 호출
				dto.setName(t1.getText());
				dto.setId(t2.getText());
				dto.setPwd(t3.getText());
				
				// DAO를 new 생성해서, dao.insertMember(name, id, pwd); 해서 보내기
				// name,id,pwd를 하나씩 보내지 않고, DTO의 setter에 넣어서 dao.insertMember(dto);로 보내는게 더 효율적
				MemberDAO dao = new MemberDAO();
				int su = dao.insertMember(dto); // return값 받아주기
				
				// dialog는 컨테이너이기 때문에 혼자 팝업 가능 - component는 불가능
				JOptionPane.showMessageDialog(null, "회원가입 되었습니다");
			} 
		} // 액션리스너
} // class
