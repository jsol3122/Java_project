package mini;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class DetailPanel extends JPanel{
   private RecipeMain recipeMain;
   private LoginPanel loginPanel;

   private JTextArea DetailTA;
   private JLabel categoryL, idL, recipeNameL, can;
   private JTextField categoryT, idT, recipeNameT;
   private RoundedButton updateBtn, deleteBtn;
   private JScrollPane scroll;
   private Image img;
   private String detailId, detailName;
   
   private Icon deco1Img = new ImageIcon("image/하트pink.png");              //0906  권영민
	private JButton[] decoBtn;
	private MouseListener listener; 																		// 여기까지
	
	int x = 10;                             // 0906 9시 마지막 시도 권영민
	int y = 10;
	int s_x = 10;
	int s_y = 10;
	int width = 80;
	int height = 70;                    //여기까지
   
   
   public DetailPanel(RecipeMain recipeMain, LoginPanel loginPanel) { //생성자
      
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
	   
	   
	  this.recipeMain = recipeMain;
      this.loginPanel = loginPanel;
      
      this.setLayout(null);
      
      //제목 라벨
      categoryL = new JLabel("카테고리 ");
      categoryT = new JTextField();
      categoryL.setBounds(11,10,70,20);
      categoryT.setBounds(70,10,80,20);
      categoryT.setEditable(false);
      this.add(categoryL);
      this.add(categoryT);
      
      //아이디
      idL = new JLabel("ID ");
      idT = new JTextField();
      idL.setBounds(255,10,50,20);
      idT.setBounds(290,10,80,20);
      idT.setEditable(false);
      this.add(idL);
      this.add(idT);
      
      //요리이름
      recipeNameL = new JLabel("요리 이름 ");
      recipeNameT = new JTextField();
      recipeNameL.setBounds(10,35,60,30);
      recipeNameT.setBounds(70,35,300,30);
      recipeNameT.setEditable(false);
      this.add(recipeNameL);
      this.add(recipeNameT);
     
      //이미지
      can = new JLabel();
      can.setBounds(15,75,355,170);
      this.add(can);
      
      //스크롤 레시피
      DetailTA = new JTextArea();
      scroll = new JScrollPane(DetailTA);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      int pos = DetailTA.getText().length();
      DetailTA.setCaretPosition(pos);
      scroll.setBounds(15,255,355,200);
      DetailTA.setEditable(false);
      this.add(scroll);
      
      updateBtn = new RoundedButton("수정");
      deleteBtn = new RoundedButton("삭제");
      updateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
      deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
      updateBtn.setBackground(new Color(253,232,248));
      deleteBtn.setBackground(new Color(253,232,248));
      updateBtn.setBounds(230,458,70,30);
      deleteBtn.setBounds(305,458,70,30);
      this.add(updateBtn);
      this.add(deleteBtn);
      
      this.setBackground(Color.WHITE);
   
      //이벤트
      updateBtn.addActionListener(recipeMain);
      deleteBtn.addActionListener(recipeMain);

   }//DetailPanel
   
   public int recipeDelete() {
	   int su = 0;
	   // 여기서 로그인한 아이디정보 vs 현재 서치결과의 아이디정보 일치해야 삭제가능!!!!!!!
	   if(detailId.equals(loginPanel.getId())) 
		   su = new RecipeDAO().recipeDelete(loginPanel.getId(), recipeNameT.getText());
	   return su;
   }

   public void detailPrint(String recipeName) {
	   scroll.getVerticalScrollBar().setValue(0); // 스크롤 맨위고정
		
	   RecipeDAO dao = new RecipeDAO();
	   RecipeDTO dto = dao.detailSearch(recipeName);
		
	   categoryT.setText(dto.getCategory());
	   idT.setText(dto.getId());
	   recipeNameT.setText(dto.getRecipeName());
	   DetailTA.setText(dto.getRecipeDetail());
		
	   ImageIcon imgFile = new ImageIcon("image/"+dto.getRecipeImg());
	   img = imgFile.getImage(); 
	   Image imgResize = img.getScaledInstance(355, 170, Image.SCALE_SMOOTH);
	   can.setIcon(new ImageIcon(imgResize));
	   
	   detailId = dto.getId(); // 레시피수정삭제용
	   detailName = dto.getRecipeName(); // 레시피 수정용
   }

   public String getDetailId() {
	   return detailId;
   }
   public String getDetailName() {
	   return detailName;
   }
   
}