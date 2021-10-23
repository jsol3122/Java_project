package mini;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SearchPanel extends JPanel{
   private RecipeMain recipeMain;
   private LoginPanel loginPanel;
   private List<RecipeDTO> list;
   
   private JLabel mypageL, recipeNameL, categoryL, idL;
   private JPanel centerP, searchP;
   private JLabel imgL;
   private JScrollPane scroll;
   private Icon searchImg = new ImageIcon("image/검색 결과.png");
   
   public Object imbBtn;
	private Icon deco1Img = new ImageIcon("image/하트pink.png");              //0906  권영민
	private JButton[] decoBtn;
	private MouseListener listener; 																		// 여기까지
	
	int x = 10;                             // 0906 9시 마지막 시도 권영민
	int y = 10;
	int s_x = 10;
	int s_y = 10;
	int width = 80;
	int height = 70;                    //여기까지
   
   public SearchPanel(RecipeMain recipeMain, LoginPanel loginPanel) {
      
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
      
      mypageL = new JLabel(searchImg);
      mypageL.setBounds(110,20,150,40);
      this.add(mypageL);
      
      centerP = new JPanel(); // 검색 결과 패널이 붙을 전체 패널
      
      centerP.setBackground(new Color(251, 169, 134));
      centerP.setLayout(new GridLayout(0, 1));
      
      //JScrollPane scroll = new JScrollPane(centerP);
      scroll = new JScrollPane(centerP);
      this.add(scroll);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      scroll.getVerticalScrollBar().setUnitIncrement(16); // 스크롤 속도조절
      scroll.setBounds(20, 100, 340, 350);

      this.setBackground(Color.WHITE);

   } // 생성자

   private void add(List<JPanel> panelList) {
      searchP = new JPanel();// 검색 결과의 사진 및 텍스트가 붙을 패널
      searchP.setLayout(null);

      centerP.add(searchP);
      searchP.setPreferredSize(new Dimension(100, 150));
      searchP.setBorder(new TitledBorder(new LineBorder(new Color(253, 232, 248), 1)));
      searchP.setBackground(Color.WHITE);

      recipeNameL = new JLabel("");
      recipeNameL.setBounds(130, 15, 150, 50);
      recipeNameL.setFont(new Font("고딕체", Font.BOLD, 20));
      recipeNameL.setCursor(new Cursor(Cursor.HAND_CURSOR));
      searchP.add(recipeNameL);

      categoryL = new JLabel("");
      categoryL.setBounds(130, 65, 40, 40);
      searchP.add(categoryL);

      idL = new JLabel("");
      idL.setBounds(180, 65, 100, 40);
      searchP.add(idL);
     
      imgL = new JLabel();
      searchP.add(imgL);
      imgL.setBounds(10, 15, 100, 100);

      recipeNameL.addMouseListener(recipeMain);
   } //add()

   public void recipePrint(List<RecipeDTO> list) { // 레시피 출력
      this.list = list;

      scroll.getVerticalScrollBar().setValue(0); // 스크롤 맨위고정
      if(centerP != null) centerP.removeAll();
      for(int i=0; i<list.size(); i++) {
    	 List<JPanel> PanelList = new ArrayList<JPanel>();
         this.add(PanelList);
         
         recipeNameL.setText(list.get(i).getRecipeName());
         categoryL.setText(list.get(i).getCategory());
         idL.setText(list.get(i).getId());
         ImageIcon icon = new ImageIcon("image/"+list.get(i).getRecipeImg());
         Image img = icon.getImage();
         Image imgResize = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
         imgL.setIcon(new ImageIcon(imgResize));
      }//for
      
   }// recipePrint(List<RecipeDTO> list)
}