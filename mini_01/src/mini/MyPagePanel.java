package mini;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MyPagePanel extends JPanel {
   private RecipeMain recipeMain;
   private SearchPanel searchPanel;
   
   private JLabel mypageL;
   private Icon update = new ImageIcon("image/update.png"); //이미지 아이콘 생성
   private Icon delete = new ImageIcon("image/delete.png");
   private Icon write = new ImageIcon("image/write.png");
   private Icon mysearch = new ImageIcon("image/mysearch.png");
   private Icon mypageImg = new ImageIcon("image/mypage.png");
   
   private JRadioButton[] RBtn = new JRadioButton[4]; //방 4개짜리 JRadioButton 배열 생성
   private ButtonGroup group = new ButtonGroup(); //ButtonGroup 생성 
   
   public MyPagePanel(RecipeMain recipeMain, SearchPanel searchPanel) {
      this.recipeMain = recipeMain;
      this.searchPanel = searchPanel;

      mypageL = new JLabel(mypageImg);
      JPanel mypageP = new JPanel();
      mypageP.add(mypageL);
      mypageP.setBackground(Color.WHITE);
      Font font = new Font("맑은 고딕", Font.BOLD, 30);
      mypageL.setFont(font);
      
      JPanel iconP = new JPanel();
      iconP.setLayout(new GridLayout(2,2,30,30));
      iconP.setBackground(Color.WHITE);
      
      RBtn[0] = new JRadioButton("레시피 등록", write);
      RBtn[0] .setBackground(Color.WHITE);
      RBtn[0].setCursor(new Cursor(Cursor.HAND_CURSOR));
      RBtn[1] = new JRadioButton("내 레시피 보기", mysearch);
      RBtn[1].setBackground(Color.WHITE);
      RBtn[1].setCursor(new Cursor(Cursor.HAND_CURSOR));
      RBtn[2] = new JRadioButton("회원 정보수정", update);
      RBtn[2].setBackground(Color.WHITE);
      RBtn[2].setCursor(new Cursor(Cursor.HAND_CURSOR));
      RBtn[3] = new JRadioButton("회원 탈퇴", delete);
      RBtn[3].setBackground(Color.WHITE);
      RBtn[3].setCursor(new Cursor(Cursor.HAND_CURSOR));
      
      for(int i=0; i<RBtn.length; i++) {
         iconP.add(RBtn[i]);
         group.add(RBtn[i]);
         RBtn[i].setVerticalTextPosition(JRadioButton.BOTTOM);
         RBtn[i].setHorizontalTextPosition(JRadioButton.CENTER);
      }
      
      add("North", mypageP);
      add("Center", iconP);
      
      this.setBackground(Color.WHITE);
      
      for(int i=0; i<RBtn.length; i++) { //레시피 등록, 내레시피 보기, 회원 정보수정, 회원탈퇴
         RBtn[i].addActionListener(recipeMain);
      }

   } // 생성자
   
   public int idSearch(String id) { // 아이디로 검색(내 레시피 보기)
		int sw = 0;

		// DB
		RecipeDAO dao = new RecipeDAO();
		List<RecipeDTO> list = dao.idSearch(id);
		sw = 1;

		searchPanel.recipePrint(list);

		if (list.size() == 0) {
			JOptionPane.showMessageDialog(this, "검색 결과가 없습니다");
			sw = 0;
		}
		return sw;
	}

}