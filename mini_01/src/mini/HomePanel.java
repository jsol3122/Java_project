package mini;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class HomePanel extends JPanel {
   private RecipeMain recipeMain;
   private SearchPanel searchPanel;
   
   private JTextField searchT;
   private RoundedButton searchBtn;
   private JLabel blankL1, blankL2;
   private JPanel searchP, iconP;
   private Icon kor = new ImageIcon("image/kor.png"); //이미지 아이콘 생성
   private Icon west = new ImageIcon("image/west.png");
   private Icon chn = new ImageIcon("image/chn.png");
   private Icon jpn = new ImageIcon("image/jpn.png");
   private JRadioButton[] RBtn = new JRadioButton[4]; //방 4개짜리 JRadioButton 배열 생성
   private ButtonGroup group = new ButtonGroup(); //ButtonGroup 생성 
   
   public HomePanel(RecipeMain recipeMain, SearchPanel searchPanel) { //생성자
      this.recipeMain = recipeMain;
      this.searchPanel = searchPanel;
      
      //JTextField 생성
      searchT = new JTextField("", 25);
      searchT.setPreferredSize(new Dimension(0,30)); //너비 높이 조절
      
      //JButton 생성
      searchBtn = new RoundedButton("검색");
      searchBtn.setBackground(new Color(253,232,248));
      searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
      
      //JLabel 생성
      blankL1 = new JLabel();
      blankL1.setBackground(new Color(255,255,255));
      blankL2 = new JLabel();
      blankL2.setBackground(new Color(255,255,255));
      blankL1.setPreferredSize(new Dimension(400,20));
      blankL2.setPreferredSize(new Dimension(400,20));
      
      //JPanel 생성 - 검색 창, 버튼
      searchP = new JPanel();
      searchP.add(searchT);
      searchP.add(searchBtn);
      searchP.setBackground(new Color(255,255,255));
      searchP.setOpaque(false);
      
      //JPanel 생성 - 한식, 양식, 중식, 일식 버튼
      iconP = new JPanel();
      iconP.setBackground(new Color(255,255,255));
      iconP.setLayout(new GridLayout(2,2,30,30));
      iconP.setOpaque(false);	
            
      RBtn[0] = new JRadioButton("한식", kor); //이름, 아이콘
      RBtn[0].setBackground(new Color(255,255,255));
      RBtn[0].setFont(new Font("12롯데마트행복Bold ",Font.PLAIN,12));
      RBtn[0].setOpaque(false);	
      RBtn[0].setCursor(new Cursor(Cursor.HAND_CURSOR));
      RBtn[1] = new JRadioButton("양식", west);
      RBtn[1].setBackground(new Color(255,255,255));
      RBtn[1].setFont(new Font("CookieRun",Font.PLAIN,12));
      RBtn[1].setOpaque(false);	
      RBtn[1].setCursor(new Cursor(Cursor.HAND_CURSOR));
      RBtn[2] = new JRadioButton("중식", chn);
      RBtn[2].setBackground(new Color(255,255,255));
      RBtn[2].setFont(new Font("CookieRun",Font.PLAIN,12));
      RBtn[2].setOpaque(false);	
      RBtn[2].setCursor(new Cursor(Cursor.HAND_CURSOR));
      RBtn[3] = new JRadioButton("일식", jpn);
      RBtn[3].setBackground(new Color(255,255,255));
      RBtn[3].setFont(new Font("CookieRun",Font.PLAIN,12));
      RBtn[3].setOpaque(false);	
      RBtn[3].setCursor(new Cursor(Cursor.HAND_CURSOR));

      for(int i=0; i<RBtn.length; i++) {
         iconP.add(RBtn[i]); //패널에 버튼붙이기
         group.add(RBtn[i]); //버튼그룹 묶기
         RBtn[i].setVerticalTextPosition(JRadioButton.BOTTOM); //버튼이름 아래로
         RBtn[i].setHorizontalTextPosition(JRadioButton.CENTER);//버튼이름 가운데
      }
      
      //JPanel은 FlowLayout, 기본적으로 가운데정렬
      add(blankL1);
      add(searchP);
      add(blankL2);
      add(iconP);
            
      this.setBackground(new Color(255,255,255));
      setVisible(true);
      
      //이벤트
      searchBtn.addActionListener(recipeMain); //검색 버튼
      
      //한식, 양식, 중식, 일식 버튼
      RBtn[0].addActionListener(recipeMain);
      RBtn[1].addActionListener(recipeMain);
      RBtn[2].addActionListener(recipeMain);
      RBtn[3].addActionListener(recipeMain);

   }//HomePanel()
   
   public int recipeNameSearch() { //레시피명 검색 (검색창)
      String recipeName = searchT.getText();
      int sw = 0; //검색되면 1로
      
      if(recipeName==null || recipeName.length()==0) {
         JOptionPane.showMessageDialog(this, "검색할 내용을 입력하세요");
         sw = 0;
      }else{   
         //DB
         RecipeDAO dao = new RecipeDAO();
         List<RecipeDTO> list = dao.recipeNameSearch(recipeName); //리턴값 list 저장
         sw = 1;
         
         searchPanel.recipePrint(list);
         
         if(list.size() == 0) {
            JOptionPane.showMessageDialog(this, "레시피명 검색 결과가 없습니다");
            sw = 0;
         }
      }
      searchT.setText(""); //초기화   
      return sw;
   }//recipeNameSearch()

   public int categorySearch(String category) { //카테고리 검색 
	  int sw = 0; //검색되면 1로

	  //DB
	  RecipeDAO dao = new RecipeDAO();
	  List<RecipeDTO> list = dao.categorySearch(category);
	  sw = 1; 
    
	  searchPanel.recipePrint(list);
	       
	  if(list.size() == 0) {
	     JOptionPane.showMessageDialog(this, "검색 결과가 없습니다");
	     sw = 0;
	  }

	  return sw;
   }//categorySearch(String category)
   
   public JTextField getSearchT() {
	   return searchT;
   }
   
}

