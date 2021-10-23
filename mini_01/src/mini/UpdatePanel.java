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

public class UpdatePanel extends JPanel{
	private RecipeMain recipeMain;
	private JLabel updateL, warningL, idL, pwdL, emailL;
	private JTextField idT, emailT;
	private JPasswordField pwdT;
	private RoundedButton updateBtn;
	private Icon updateImg = new ImageIcon("image/�� ���� ����.png");
	private Icon idImg = new ImageIcon("image/���̵�.png");
	private Icon pwdImg = new ImageIcon("image/��й�ȣ.png");
	private Icon mailImg = new ImageIcon("image/�̸���.png");
	
	private Icon deco1Img = new ImageIcon("image/��Ʈpink.png");              //0906  �ǿ���
	private JButton[] decoBtn;
	private MouseListener listener; 																		// �������
	
	int x = 10;                             // 0906 9�� ������ �õ� �ǿ���
	int y = 10;
	int s_x = 10;
	int s_y = 10;
	int width = 80;
	int height = 70;                    //�������
	
	public UpdatePanel(RecipeMain recipeMain) {
		
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
		
		updateL = new JLabel(updateImg);
		updateL.setBounds(100,45,180,50);
		this.add(updateL);
		
		warningL = new JLabel("* ���Ӱ� ������ ȸ�������� �Է����ּ��� *");
		warningL.setForeground(Color.RED);	
		warningL.setBounds(65, 130, 300, 20);
		this.add(warningL);
		
		idL = new JLabel(idImg);
		idT = new JTextField("",18);
		idL.setBounds(70,175,70,30);
		idT.setBounds(160,175,140,30);
		this.add(idL);
		this.add(idT);

		pwdL = new JLabel(pwdImg);
		pwdT = new JPasswordField("",18);
		pwdL.setBounds(65,235,90,30);
		pwdT.setBounds(160,230,140,30);
		this.add(pwdL);
		this.add(pwdT);
		
		emailL = new JLabel(mailImg);
		emailT = new JTextField("",18);
		emailL.setBounds(70,285,70,30);
		emailT.setBounds(160,285,140,30);
		this.add(emailL);
		this.add(emailT);

		updateBtn = new RoundedButton("���� �Ϸ�");
		updateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		updateBtn.setBounds(120,340,160,40);
		updateBtn.setBackground(new Color(253,232,248));
		this.add(updateBtn);
		updateBtn.setBorderPainted(false);
		
		this.setBackground(new Color(255,255,255));
		
		// �����Ϸ��ư ������ DB�� ������Ʈ
		updateBtn.addActionListener(recipeMain);
	} // ������
	
	public int updateMember(String pwdCheck) {
		int su = 0;
		
		su = new MemberDAO().updateMember(idT.getText(), pwdT.getText(), emailT.getText(), pwdCheck);
		return su;
	}
	
	public JTextField getIdT() {
		return idT;
	}
	
	public JTextField getEmailT() {
		return emailT;
	}
	
	public JPasswordField getPwdT() {
		return pwdT;
	}
	
}
