package mini;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RecipeWritePanel extends JPanel{
   protected static final String ERROR_MESSAGE = null;
   private RecipeMain recipeMain;
   private LoginPanel loginPanel;
   
   private JLabel recipeWriteL, recipeNameL, idL, idL1,
               categoryL, recipedetailL, imgL, imgL1;
   private JTextArea recipedatailTA;
   private JTextField recipeNameT, imgT;
   private RoundedButton addBtn, imgBtn;
   private JComboBox<String> categoryC;
   private Icon recipeWriteImg = new ImageIcon("image/레시피 등록.png");
   
   private Icon deco1Img = new ImageIcon("image/하트pink.png");              //0906  권영민
	private JButton[] decoBtn;
	private MouseListener listener; 																		// 여기까지
	
	int x = 10;                             // 0906 9시 마지막 시도 권영민
	int y = 10;
	int s_x = 10;
	int s_y = 10;
	int width = 80;
	int height = 70;                    //여기까지
   
   public RecipeWritePanel(RecipeMain recipeMain, LoginPanel loginPanel) { //생성자
      
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
      
      setLayout(null);
      
      recipeWriteL = new JLabel(recipeWriteImg);
      recipeWriteL.setBounds(95,8,190,50);
      this.add(recipeWriteL);
      
      recipeNameL = new JLabel("레시피 이름 ");
      recipeNameT = new JTextField();
      recipeNameL.setBounds(15,80,90,30);
      recipeNameT.setBounds(95,80,150,30);
      this.add(recipeNameL);
      this.add(recipeNameT);
      
      idL = new JLabel("");
      idL1 = new JLabel("");  
      idL.setBounds(70,115,90,30);
      idL1.setBounds(120,115,90,30);
      this.add(idL);
      this.add(idL1);
      
      categoryL = new JLabel("     카테고리    ");
      String[] citems = {"한식", "중식", "양식", "일식"};
      categoryC = new JComboBox<String>(citems);   
      categoryL.setBounds(15,150,90,30);
      categoryC.setBounds(95,150,90,30);
      this.add(categoryL);
      this.add(categoryC);
    
      imgL = new JLabel("이미지 첨부  ");
      imgT = new JTextField();
      imgL1 = new JLabel("※ 파일명.확장자(필수)");
      imgBtn = new RoundedButton("열기");
      imgBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
      imgBtn.setBackground(new Color(253,232,248));
      imgL.setBounds(15,190,90,30);
      imgT.setBounds(95,190,150,30);
      imgL1.setBounds(95,215,150,30);
      imgBtn.setBounds(260,190,70,30);
      this.add(imgL);
      this.add(imgT);
      this.add(imgL1);
      this.add(imgBtn);
      
      recipedetailL = new JLabel("    요리 순서  ");
      recipedatailTA = new JTextArea();
      JScrollPane scroll = new JScrollPane(recipedatailTA);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      recipedetailL.setBounds(15,240,90,30);
      scroll.setBounds(10,270,362,180);
      this.add(recipedetailL);
      this.add(scroll);

      addBtn = new RoundedButton("등록");
      addBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
      addBtn.setBackground(new Color(253,232,248));
      this.add(addBtn);
      addBtn.setBounds(310,455,60,30);
      
      this.setBackground(Color.WHITE);
      
      //이벤트
      addBtn.addActionListener(recipeMain); 
   }
   
   public void lbupdate() {
	   if(loginPanel.getId() != null) {
    	  idL1.setText(loginPanel.getId()); 
	   }
   }
      
   public int recipeWrite() {   
	  int sw = 0;
      
      String recipeName = recipeNameT.getText();
      if(recipeName.equals("")) {
         JOptionPane.showMessageDialog(this, "레시피 이름을 입력해주세요.");
         return sw;
      }
      String id   = idL1.getText();
      String category = categoryC.getSelectedItem().toString();
      String recipeDetail = recipedatailTA.getText();
      if(recipeDetail.equals("")) {
         JOptionPane.showMessageDialog(this, "요리 순서를 입력해주세요.");
         return sw;
      }
      String recipeImg = imgT.getText();
      if(recipeImg.equals("")) {
         JOptionPane.showMessageDialog(this, "이미지 첨부 해주세요.");
         return sw;
      }
      
      RecipeDTO dto = new RecipeDTO();
      dto.setRecipeName(recipeName);
      dto.setId(id);
      dto.setCategory(category);
      dto.setRecipeDetail(recipeDetail);
      dto.setRecipeImg(recipeImg);
       
      RecipeDAO dao = new RecipeDAO(); 
      dao.recipeWrite(dto);
      sw = 1; //DB 보내면
       
       //초기화
      recipeNameT.setText("");
      categoryC.setSelectedIndex(0);
      recipedatailTA.setText("");
      imgT.setText("");
      
      return sw;
   }
   
   public JTextField getRecipeNameT() {
	   return recipeNameT;
   }
   
   public JTextField getImgT() {
	   return imgT;
   }

   public JTextArea getRecipedatailTA() {
	   return recipedatailTA;
   }

}