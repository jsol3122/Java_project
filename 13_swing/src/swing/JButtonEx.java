package swing;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

class JButtonEx extends JFrame{
	// Icon은 인터페이스 -- new가 안되기 때문에 ImageIcon으로 대신 생성
	private Icon icon1 = new ImageIcon("image/너부리.jpg");
	private Icon icon2 = new ImageIcon("image/보노보노.png");
	private Icon icon3 = new ImageIcon("image/포로리.jpg");
	private Icon icon4 = new ImageIcon("image/피카츄.jpg");
	private JRadioButton[] jb = new JRadioButton[4];
	private ButtonGroup bg = new ButtonGroup(); // 이미지를 ButtonGroup으로 묶어줌
	
	public JButtonEx() {
		super("Test");
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(2,2));
		for(int i=0; i<4; i++) {
			// JRadioButton으로 올려야 이미지 여러개 올라감
			jb[i] = new JRadioButton(i + 1 +"번 버튼", icon1); 
			con.add(jb[i]);
			jb[i].setToolTipText(i + 1 +"번째 버튼이다. 눌러...");
			jb[i].setMnemonic(i+49);
			jb[i].setRolloverIcon(icon2);
			jb[i].setPressedIcon(icon3);
			jb[i].setSelectedIcon(icon4);
			bg.add(jb[i]);
		}
		pack(); // 이미지 크기에 따라 프레임창크기 자동결정
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JButtonEx();
	}

}
