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

public class DeletePanel extends JPanel{
   private RecipeMain recipeMain;
   private JLabel deleteL, nameL, idL, pwdL;
   private JTextField nameT, idT;
   private JPasswordField pwdT;
   private RoundedButton deleteBtn;
   private Icon deleteImg = new ImageIcon("image/È¸¿øÅ»Åð.png");
   private Icon nameImg = new ImageIcon("image/ÀÌ¸§.png");
   private Icon idImg = new ImageIcon("image/¾ÆÀÌµð.png");
   private Icon pwdImg = new ImageIcon("image/ºñ¹Ð¹øÈ£.png");
   
   private Icon deco1Img = new ImageIcon("image/ÇÏÆ®pink.png");              //0906  ±Ç¿µ¹Î
   private JButton[] decoBtn;
   private MouseListener listener; 
   
	int x = 10;                             // 0906 9½Ã ¸¶Áö¸· ½Ãµµ ±Ç¿µ¹Î
	int y = 10;
	int s_x = 10;
	int s_y = 10;
	int width = 80;
	int height = 70;                    //¿©±â±îÁö
   
   
   public DeletePanel(RecipeMain recipeMain) {
	   
	    decoBtn = new JButton[4];																	//0906 ±Ç¿µ¹Î
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
			decoBtn[i].setToolTipText("¹öÆ°x ´©¸£Áö ¸¶¼¼¿ä.......");
			decoBtn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));	//0906 ±Ç¿µ¹Î

		}

			decoBtn[0].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 ±Ç¿µ¹Î
			public void mouseDown(MouseEvent ev, int x, int y) {
			}
			public void mouseDragged(MouseEvent ev) {
				int tem_x = ev.getX()-(width/2);
				int tem_y = ev.getY()-(height/2);
				
				x = x+tem_x;
				y= y+tem_y;
				decoBtn[0].setBounds(x,y,width,height);
			}
		});																																	//0906 ±Ç¿µ¹Î
			decoBtn[1].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 ±Ç¿µ¹Î
			public void mouseDown(MouseEvent ev, int x, int y) {
			}
			public void mouseDragged(MouseEvent ev) {
				int tem_x = ev.getX()-(width/2);
				int tem_y = ev.getY()-(height/2);
				
				x = x+tem_x;
				y= y+tem_y;
				decoBtn[1].setBounds(x,y,width,height);
			}
		});																																	//0906 ±Ç¿µ¹Î
			decoBtn[2].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 ±Ç¿µ¹Î
			public void mouseDown(MouseEvent ev, int x, int y) {
			}
			public void mouseDragged(MouseEvent ev) {
				int tem_x = ev.getX()-(width/2);
				int tem_y = ev.getY()-(height/2);
				
				x = x+tem_x;
				y= y+tem_y;
				decoBtn[2].setBounds(x,y,width,height);
			}
		});																																	//0906 ±Ç¿µ¹Î
			decoBtn[3].addMouseMotionListener(new MouseMotionAdapter() {   // 0906 ±Ç¿µ¹Î
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
      
      deleteL = new JLabel(deleteImg);
      deleteL.setBounds(100,45,180,50);
      this.add(deleteL);
    
      nameL = new JLabel(nameImg);
      nameT = new JTextField("",18);
      nameL.setBounds(75,175,70,30);
      nameT.setBounds(160,175,140,30);
      this.add(nameL);
      this.add(nameT);

      idL = new JLabel(idImg);
      idT = new JTextField("",18);
      idL.setBounds(60,230,90,30);
      idT.setBounds(160,230,140,30);
      this.add(idL);
      this.add(idT);

      pwdL = new JLabel(pwdImg);
      pwdT = new JPasswordField("",18);
      pwdL.setBounds(65,285,90,30);
      pwdT.setBounds(160,285,140,30);
      this.add(pwdL);
      this.add(pwdT);

      deleteBtn = new RoundedButton("Å»Åð ¿Ï·á");
      deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
      deleteBtn.setBounds(120,340,160,40);
      deleteBtn.setBackground(new Color(253,232,248));
      this.add(deleteBtn);
      deleteBtn.setBorderPainted(false);
		
      this.setBackground(new Color(255,255,255));

      deleteBtn.addActionListener(recipeMain);
   } // »ý¼ºÀÚ
   
   public int deleteMember(String pwdCheck) {
	   int su = 0;
	   
	   su = new MemberDAO().deleteMember(pwdCheck);
	   return su;
   }
   
   public JTextField getNameT() {
	   return nameT;
   }
   
   public JTextField getIdT() {
	   return idT;
   }
	
   public JPasswordField getPwdT() {
	   return pwdT;
   }
   
}