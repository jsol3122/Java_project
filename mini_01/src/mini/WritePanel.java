package mini;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class WritePanel extends JPanel implements ActionListener{
	private RecipeMain recipeMain;
	private JLabel writeL, nameL, idL, idCheckL, pwdL, emailL, emailNumL, emailCheckL;
	private JTextField nameT, idT, emailT, emailNumT;
	private JPasswordField pwdT;
	private JButton idCheckBtn, emailCheckBtn, emailNumBtn, writeBtn, deco1Btn, deco2Btn, deco3Btn, deco4Btn;
	boolean idCheck;
	boolean emailCheck;
	int emailNum;
	private Icon writeImg = new ImageIcon("image/회원가입.png");
	private Icon nameImg = new ImageIcon("image/이름.png");
	private Icon idImg = new ImageIcon("image/아이디.png");
	private Icon pwdImg = new ImageIcon("image/비밀번호.png");
	private Icon mailImg = new ImageIcon("image/이메일.png");
	private Icon emailNumImg = new ImageIcon("image/인증번호.png");
	private Icon deco1Img = new ImageIcon("image/하트pink.png");
	private JButton[] decoBtn;
	private MouseListener listener; 																		// 여기까지
	
	int x = 10;                             // 0906 9시 마지막 시도 권영민
	int y = 10;
	int s_x = 10;
	int s_y = 10;
	int width = 80;
	int height = 70;                    //여기까지
	
	public WritePanel(RecipeMain recipeMain) {
		this.recipeMain = recipeMain;
		
		this.setLayout(null);
		
		decoBtn = new JButton[4];																	//0906 권영민
		decoBtn[0] = new JButton(deco1Img);
		decoBtn[1] = new JButton(deco1Img);
		decoBtn[2] = new JButton(deco1Img);
		decoBtn[3] = new JButton(deco1Img);
		for(int i = 0; i<4; i++) {
			decoBtn[i] = new JButton(deco1Img);
			decoBtn[i].setBounds(((int)(Math.random()*300)+20)+20, (int)(Math.random()*400)+20, 80, 70);
			this.add(decoBtn[i]);
			decoBtn[i].setBorderPainted(false);
			decoBtn[i].setContentAreaFilled(false);
			decoBtn[i].setToolTipText("버튼x 누르지 마세요.......");
			decoBtn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));	//0906 권영민

		}

			decoBtn[0].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 권영민
			public void mouseDown(MouseEvent ev, int x, int y) {
			}
			public void mouseDragged(MouseEvent ev) {
				int tem_x = ev.getX()-(width/2);
				int tem_y = ev.getY()-(height/2);
				
				x = x+tem_x;
				y= y+tem_y;
				decoBtn[0].setBounds(x,y,width,height);
			}
		});																																	//0906 권영민
			decoBtn[1].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 권영민
			public void mouseDown(MouseEvent ev, int x, int y) {
			}
			public void mouseDragged(MouseEvent ev) {
				int tem_x = ev.getX()-(width/2);
				int tem_y = ev.getY()-(height/2);
				
				x = x+tem_x;
				y= y+tem_y;
				decoBtn[1].setBounds(x,y,width,height);
			}
		});																																	//0906 권영민
			decoBtn[2].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 권영민
			public void mouseDown(MouseEvent ev, int x, int y) {
			}
			public void mouseDragged(MouseEvent ev) {
				int tem_x = ev.getX()-(width/2);
				int tem_y = ev.getY()-(height/2);
				
				x = x+tem_x;
				y= y+tem_y;
				decoBtn[2].setBounds(x,y,width,height);
			}
		});																																	//0906 권영민
			decoBtn[3].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 권영민
			public void mouseDown(MouseEvent ev, int x, int y) {
			}
			public void mouseDragged(MouseEvent ev) {
				int tem_x = ev.getX()-(width/2);
				int tem_y = ev.getY()-(height/2);
				
				x = x+tem_x;
				y= y+tem_y;
				decoBtn[3].setBounds(x,y,width,height);
			}
		});			
		
		writeL = new JLabel(writeImg);
		writeL.setBounds(130,45,130,50);
		this.add(writeL);
		
		nameL = new JLabel(nameImg);
		nameT = new JTextField("",18);
		nameL.setBounds(30,135,50,30);
		nameT.setBounds(110,135,140,30);
		this.add(nameL);
		this.add(nameT);
		
		idL = new JLabel(idImg);
		idT = new JTextField("",18);
		idCheckBtn = new RoundedButton("중복 체크");
		idCheckBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		idCheckBtn.setBorderPainted(false);
		idL.setBounds(20,175,70,30);
		idT.setBounds(110,175,140,30);
		idCheckBtn.setBounds(260,175,110,30);
		idCheckBtn.setBackground(new Color(253,232,248));
		this.add(idL);
		this.add(idT);
		this.add(idCheckBtn);
		
		idCheckL = new JLabel("");
		idCheckL.setBounds(120,200,140,30);
		this.add(idCheckL);
		
		pwdL = new JLabel(pwdImg);
		pwdT = new JPasswordField("",18);
		pwdL.setBounds(15,245,90,30);
		pwdT.setBounds(110,245,140,30);
		this.add(pwdL);
		this.add(pwdT);
		
		emailL = new JLabel(mailImg);
		emailT = new JTextField("",18);
		emailCheckBtn = new RoundedButton("인증번호");
		emailCheckBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		emailCheckBtn.setBackground(new Color(253,232,248));
		emailL.setBounds(20,285,70,30);
		emailT.setBounds(110,285,140,30);
		emailCheckBtn.setBounds(260,285,110,30);
		this.add(emailL);
		this.add(emailT);
		this.add(emailCheckBtn);

		emailCheckBtn.setBorderPainted(false);
		
		emailNumL = new JLabel(emailNumImg);
		emailNumT = new JTextField("",18);
		emailNumBtn = new RoundedButton("인증 확인");
		emailNumBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		emailNumBtn.setBackground(new Color(253,232,248));
		emailNumL.setBounds(20,325,80,30);
		emailNumT.setBounds(110,325,140,30);
		emailNumBtn.setBounds(260,325,110,30);
		emailNumBtn.setBorderPainted(false);
		this.add(emailNumL);
		this.add(emailNumT);
		this.add(emailNumBtn);

		emailCheckL = new JLabel("");
		emailCheckL.setBounds(120,350,150,30);
		this.add(emailCheckL);
		
		writeBtn = new RoundedButton("회원가입");
		writeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		writeBtn.setBorderPainted(false);
		writeBtn.setBounds(120,400,160,40);
		writeBtn.setBackground(new Color(253,232,248));
		this.add(writeBtn);
		
		this.setBackground(Color.WHITE);
	
		// 이벤트
		writeBtn.addActionListener(recipeMain);
		idCheckBtn.addActionListener(this);
		emailCheckBtn.addActionListener(this);
		emailNumBtn.addActionListener(this);
		decoBtn[0].addActionListener(this);
	} // 생성자

	@Override
	public void actionPerformed(ActionEvent e) {
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		if(e.getSource() == idCheckBtn) { // id중복체크
			if(idT.getText().length()==0) 
				JOptionPane.showMessageDialog(this, "아이디를 입력해주세요");
			else {
				String name = dao.checkId(idT.getText());
				if(name != null) {
					idCheckL.setText("사용할 수 없는 ID입니다");
					idT.setText("");
				}else {
					idCheckL.setText("사용 가능한 ID입니다");
					idCheck = true;
					
					if(emailCheck==true) { // db등록
						dto.setId(idT.getText());
						dto.setName(nameT.getText());
						dto.setEmail(emailT.getText());
						dto.setPwd(pwdT.getText());
						dto.setCheckNum(emailNumT.getText());
						
						dao.insertMember(dto);
					}
				}
			}
		}else if(e.getSource() == emailCheckBtn) { // 인증번호 발송
			if(emailT.getText().indexOf("@") != -1) { // 이메일 형식 체크
				EmailCheck emailCheck = new EmailCheck(emailT.getText());
				emailNum = emailCheck.getEmailNum();
				JOptionPane.showMessageDialog(null, "인증번호가 메일로 발송되었습니다");
			}else JOptionPane.showMessageDialog(null, "잘못된 이메일 형식입니다");
		}else if(e.getSource() == emailNumBtn) { // 인증번호 확인
			if(emailNumT.getText().equals(emailNum+"")) {
				emailCheckL.setText("인증번호 확인되었습니다");
				emailCheck = true;
				
				if(idCheck==true) { // db등록
					dto.setId(idT.getText());
					dto.setName(nameT.getText());
					dto.setEmail(emailT.getText());
					dto.setPwd(pwdT.getText());
					dto.setCheckNum(emailNumT.getText());
					
					dao.insertMember(dto);
				}
			}else {
				emailCheckL.setText("인증번호가 틀립니다");
				emailNumT.setText("");
			}
		}
	} // 액션리스너
	
	private void addComponent(Container container, Component c, int x , int y, int width, int height) {       //0906 권영민
		c.setBounds(x,y,width,height);
		container.add(c);
		
	}
	
	private void jButton1_actionPerformed(ActionEvent e) {
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception ex) {
			System.out.println("failed loading L&F:");
			System.out.println(ex);
		}
	}     			
	
	
	
// getter ------------------------------------------
	public boolean getIdCheck() {
		return idCheck;
	}
	
	public boolean getEmailCheck() {
		return emailCheck;
	}
	
	public JTextField getNameT() {
		return nameT;
	}
	
	public JTextField getIdT() {
		return idT;
	}
	
	public JTextField getEmailT() {
		return emailT;
	}
	
	public JTextField getEmailNumT() {
		return emailNumT;
	}
	
	public JPasswordField getPwdT() {
		return pwdT;
	}
	
}













