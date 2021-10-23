package mini;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{
	private RecipeMain recipeMain;
	private JLabel loginL, idL, pwdL;
	private JTextField idT;
	private JPasswordField pwdT;
	private RoundedButton loginBtn;
	private String check;
	private String id;
	private Icon loginImg = new ImageIcon("image/�α���.png");
	private Icon idImg = new ImageIcon("image/���̵�.png");
	private Icon pwdImg = new ImageIcon("image/��й�ȣ.png");
	
	private Icon deco1Img = new ImageIcon("image/��Ʈpink.png");              //0906  �ǿ���
	private JButton[] decoBtn;
	private MouseListener listener; 																		// �������
	
	int x = 10;                             // 0906 9�� ������ �õ� �ǿ���
	int y = 10;
	int s_x = 10;
	int s_y = 10;
	int width = 80;
	int height = 70;                    //�������
	
	
	public LoginPanel(RecipeMain recipeMain) {
		
		decoBtn = new JButton[4];																	//0906 �ǿ���
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
			decoBtn[i].setToolTipText("��ưx ������ ������.......");
			decoBtn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));	//0906 �ǿ���

		}

			decoBtn[0].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 �ǿ���
			public void mouseDown(MouseEvent ev, int x, int y) {
			}
			public void mouseDragged(MouseEvent ev) {
				int tem_x = ev.getX()-(width/2);
				int tem_y = ev.getY()-(height/2);
				
				x = x+tem_x;
				y= y+tem_y;
				decoBtn[0].setBounds(x,y,width,height);
			}
		});																																	//0906 �ǿ���
			decoBtn[1].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 �ǿ���
			public void mouseDown(MouseEvent ev, int x, int y) {
			}
			public void mouseDragged(MouseEvent ev) {
				int tem_x = ev.getX()-(width/2);
				int tem_y = ev.getY()-(height/2);
				
				x = x+tem_x;
				y= y+tem_y;
				decoBtn[1].setBounds(x,y,width,height);
			}
		});																																	//0906 �ǿ���
			decoBtn[2].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 �ǿ���
			public void mouseDown(MouseEvent ev, int x, int y) {
			}
			public void mouseDragged(MouseEvent ev) {
				int tem_x = ev.getX()-(width/2);
				int tem_y = ev.getY()-(height/2);
				
				x = x+tem_x;
				y= y+tem_y;
				decoBtn[2].setBounds(x,y,width,height);
			}
		});																																	//0906 �ǿ���
			decoBtn[3].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 �ǿ���
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
		
		
		this.recipeMain = recipeMain;
		
		setLayout(null);

		loginL = new JLabel(loginImg);
		loginL.setBounds(130,45,130,50);
		this.add(loginL);

		idL = new JLabel(idImg);
		idT = new JTextField("",18);
		idL.setBounds(70,175,70,30);
		idT.setBounds(160,175,140,30);
		this.add(idL);
		this.add(idT);

		pwdL = new JLabel(pwdImg);
		pwdT = new JPasswordField("",18);
		pwdL.setBounds(65,245,90,30);
		pwdT.setBounds(160,245,140,30);
		this.add(pwdL);
		this.add(pwdT);
		
		loginBtn = new RoundedButton("�α���");
		loginBtn.setBounds(120,340,160,40);
		loginBtn.setBackground(new Color(253,232,248));
		loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(loginBtn);
		loginBtn.setBorderPainted(false);
		
		this.setBackground(Color.WHITE);
		loginBtn.addActionListener(recipeMain);
	} // ������
	
	public String getLoginCheck() {
		id = idT.getText();
		String pwd = pwdT.getText();
		check = new MemberDAO().loginMember(id, pwd);
		return check;
	}
	
	public void setId(String id) { 
		// �α��� ���� �� id ����
		// �α׾ƿ��� id null�� �޾ƿ�
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public JTextField getIdT() {
		return idT;
	}
	
	public JPasswordField getPwdT() {
		return pwdT;
	}
	
}
