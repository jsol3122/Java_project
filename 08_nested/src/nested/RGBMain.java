package nested;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RGBMain extends Frame {
	private Button redBtn, greenBtn, blueBtn;
	private DrCanvas can; // canvas 는 new생성이 x - 반드시 상속 (그러나 현재는 다중상속불가)
	
	public RGBMain (){
		redBtn = new Button("빨강");
		greenBtn = new Button("초록");
		blueBtn = new Button("파랑");
		can = new DrCanvas();
		
		Panel p = new Panel();
		p.add(redBtn);
		p.add(greenBtn);
		p.add(blueBtn);
		
		this.add("North", p);
		this.add("Center", can);
		
		setBounds(900, 150, 300, 400);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // 원하는 메소드만 갖다쓰기 가능
				System.exit(0);
			}
		});
		
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("마우스 클릭");
			}
		});
		
		redBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.RED);
			}
		});
		
		greenBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.GREEN);
			}
		});
		
		blueBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.BLUE);
			}
		});
		
	} // 생성자
	
	class DrCanvas extends Canvas {
		public DrCanvas() {
			this.setBackground(new Color(255, 200, 255));
		}
	} // inner class

	public static void main(String[] args) {
		new RGBMain();
	} // main
} // class
