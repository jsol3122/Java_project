package nested;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

public class HomePanel extends Panel {
	//public Panel homep; -- ���� �г� ����� panel��������� �����ڷ� ����
	
	public HomePanel(){
		setBackground(Color.RED);
	}
	@Override
	
	public void paint(Graphics g) { // �̹��� ��
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("img/kakao.gif");
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}
