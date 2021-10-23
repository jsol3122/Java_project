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
   private Icon kor = new ImageIcon("image/kor.png"); //�̹��� ������ ����
   private Icon west = new ImageIcon("image/west.png");
   private Icon chn = new ImageIcon("image/chn.png");
   private Icon jpn = new ImageIcon("image/jpn.png");
   private JRadioButton[] RBtn = new JRadioButton[4]; //�� 4��¥�� JRadioButton �迭 ����
   private ButtonGroup group = new ButtonGroup(); //ButtonGroup ���� 
   
   public HomePanel(RecipeMain recipeMain, SearchPanel searchPanel) { //������
      this.recipeMain = recipeMain;
      this.searchPanel = searchPanel;
      
      //JTextField ����
      searchT = new JTextField("", 25);
      searchT.setPreferredSize(new Dimension(0,30)); //�ʺ� ���� ����
      
      //JButton ����
      searchBtn = new RoundedButton("�˻�");
      searchBtn.setBackground(new Color(253,232,248));
      searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
      
      //JLabel ����
      blankL1 = new JLabel();
      blankL1.setBackground(new Color(255,255,255));
      blankL2 = new JLabel();
      blankL2.setBackground(new Color(255,255,255));
      blankL1.setPreferredSize(new Dimension(400,20));
      blankL2.setPreferredSize(new Dimension(400,20));
      
      //JPanel ���� - �˻� â, ��ư
      searchP = new JPanel();
      searchP.add(searchT);
      searchP.add(searchBtn);
      searchP.setBackground(new Color(255,255,255));
      searchP.setOpaque(false);
      
      //JPanel ���� - �ѽ�, ���, �߽�, �Ͻ� ��ư
      iconP = new JPanel();
      iconP.setBackground(new Color(255,255,255));
      iconP.setLayout(new GridLayout(2,2,30,30));
      iconP.setOpaque(false);	
            
      RBtn[0] = new JRadioButton("�ѽ�", kor); //�̸�, ������
      RBtn[0].setBackground(new Color(255,255,255));
      RBtn[0].setFont(new Font("12�Ե���Ʈ�ູBold ",Font.PLAIN,12));
      RBtn[0].setOpaque(false);	
      RBtn[0].setCursor(new Cursor(Cursor.HAND_CURSOR));
      RBtn[1] = new JRadioButton("���", west);
      RBtn[1].setBackground(new Color(255,255,255));
      RBtn[1].setFont(new Font("CookieRun",Font.PLAIN,12));
      RBtn[1].setOpaque(false);	
      RBtn[1].setCursor(new Cursor(Cursor.HAND_CURSOR));
      RBtn[2] = new JRadioButton("�߽�", chn);
      RBtn[2].setBackground(new Color(255,255,255));
      RBtn[2].setFont(new Font("CookieRun",Font.PLAIN,12));
      RBtn[2].setOpaque(false);	
      RBtn[2].setCursor(new Cursor(Cursor.HAND_CURSOR));
      RBtn[3] = new JRadioButton("�Ͻ�", jpn);
      RBtn[3].setBackground(new Color(255,255,255));
      RBtn[3].setFont(new Font("CookieRun",Font.PLAIN,12));
      RBtn[3].setOpaque(false);	
      RBtn[3].setCursor(new Cursor(Cursor.HAND_CURSOR));

      for(int i=0; i<RBtn.length; i++) {
         iconP.add(RBtn[i]); //�гο� ��ư���̱�
         group.add(RBtn[i]); //��ư�׷� ����
         RBtn[i].setVerticalTextPosition(JRadioButton.BOTTOM); //��ư�̸� �Ʒ���
         RBtn[i].setHorizontalTextPosition(JRadioButton.CENTER);//��ư�̸� ���
      }
      
      //JPanel�� FlowLayout, �⺻������ �������
      add(blankL1);
      add(searchP);
      add(blankL2);
      add(iconP);
            
      this.setBackground(new Color(255,255,255));
      setVisible(true);
      
      //�̺�Ʈ
      searchBtn.addActionListener(recipeMain); //�˻� ��ư
      
      //�ѽ�, ���, �߽�, �Ͻ� ��ư
      RBtn[0].addActionListener(recipeMain);
      RBtn[1].addActionListener(recipeMain);
      RBtn[2].addActionListener(recipeMain);
      RBtn[3].addActionListener(recipeMain);

   }//HomePanel()
   
   public int recipeNameSearch() { //�����Ǹ� �˻� (�˻�â)
      String recipeName = searchT.getText();
      int sw = 0; //�˻��Ǹ� 1��
      
      if(recipeName==null || recipeName.length()==0) {
         JOptionPane.showMessageDialog(this, "�˻��� ������ �Է��ϼ���");
         sw = 0;
      }else{   
         //DB
         RecipeDAO dao = new RecipeDAO();
         List<RecipeDTO> list = dao.recipeNameSearch(recipeName); //���ϰ� list ����
         sw = 1;
         
         searchPanel.recipePrint(list);
         
         if(list.size() == 0) {
            JOptionPane.showMessageDialog(this, "�����Ǹ� �˻� ����� �����ϴ�");
            sw = 0;
         }
      }
      searchT.setText(""); //�ʱ�ȭ   
      return sw;
   }//recipeNameSearch()

   public int categorySearch(String category) { //ī�װ� �˻� 
	  int sw = 0; //�˻��Ǹ� 1��

	  //DB
	  RecipeDAO dao = new RecipeDAO();
	  List<RecipeDTO> list = dao.categorySearch(category);
	  sw = 1; 
    
	  searchPanel.recipePrint(list);
	       
	  if(list.size() == 0) {
	     JOptionPane.showMessageDialog(this, "�˻� ����� �����ϴ�");
	     sw = 0;
	  }

	  return sw;
   }//categorySearch(String category)
   
   public JTextField getSearchT() {
	   return searchT;
   }
   
}

