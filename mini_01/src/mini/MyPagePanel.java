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
   private Icon update = new ImageIcon("image/update.png"); //�̹��� ������ ����
   private Icon delete = new ImageIcon("image/delete.png");
   private Icon write = new ImageIcon("image/write.png");
   private Icon mysearch = new ImageIcon("image/mysearch.png");
   private Icon mypageImg = new ImageIcon("image/mypage.png");
   
   private JRadioButton[] RBtn = new JRadioButton[4]; //�� 4��¥�� JRadioButton �迭 ����
   private ButtonGroup group = new ButtonGroup(); //ButtonGroup ���� 
   
   public MyPagePanel(RecipeMain recipeMain, SearchPanel searchPanel) {
      this.recipeMain = recipeMain;
      this.searchPanel = searchPanel;

      mypageL = new JLabel(mypageImg);
      JPanel mypageP = new JPanel();
      mypageP.add(mypageL);
      mypageP.setBackground(Color.WHITE);
      Font font = new Font("���� ���", Font.BOLD, 30);
      mypageL.setFont(font);
      
      JPanel iconP = new JPanel();
      iconP.setLayout(new GridLayout(2,2,30,30));
      iconP.setBackground(Color.WHITE);
      
      RBtn[0] = new JRadioButton("������ ���", write);
      RBtn[0] .setBackground(Color.WHITE);
      RBtn[0].setCursor(new Cursor(Cursor.HAND_CURSOR));
      RBtn[1] = new JRadioButton("�� ������ ����", mysearch);
      RBtn[1].setBackground(Color.WHITE);
      RBtn[1].setCursor(new Cursor(Cursor.HAND_CURSOR));
      RBtn[2] = new JRadioButton("ȸ�� ��������", update);
      RBtn[2].setBackground(Color.WHITE);
      RBtn[2].setCursor(new Cursor(Cursor.HAND_CURSOR));
      RBtn[3] = new JRadioButton("ȸ�� Ż��", delete);
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
      
      for(int i=0; i<RBtn.length; i++) { //������ ���, �������� ����, ȸ�� ��������, ȸ��Ż��
         RBtn[i].addActionListener(recipeMain);
      }

   } // ������
   
   public int idSearch(String id) { // ���̵�� �˻�(�� ������ ����)
		int sw = 0;

		// DB
		RecipeDAO dao = new RecipeDAO();
		List<RecipeDTO> list = dao.idSearch(id);
		sw = 1;

		searchPanel.recipePrint(list);

		if (list.size() == 0) {
			JOptionPane.showMessageDialog(this, "�˻� ����� �����ϴ�");
			sw = 0;
		}
		return sw;
	}

}