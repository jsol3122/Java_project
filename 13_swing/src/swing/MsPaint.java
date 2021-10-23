package swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MsPaint extends JFrame implements ActionListener{
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect, pen;
	private JComboBox<String> combo;
	private JButton draw;
	private DrCanvas can;
	private int x1_temp, y1_temp;
	private Graphics g;
	private Vector<Integer> vector = new Vector<Integer>();
	private List<ShapeDTO> list;
	
	public MsPaint() { //ArrayList 만들기
		super("미니 그림판");
		
		JPanel p1 = new JPanel(); // 윗줄 전체패널
		
		// 텍스트필드에 기본값 설정해야함 - 시작하자마자 paint호출하기때문에 값 없으면 오류뜸
		JPanel x1p = new JPanel();
		x1L = new JLabel("x1");
		x1T = new JTextField("0", 5); // 따로 패널잡을 필요 없이, 크기만 줘도 적용됨
		x1p.add(x1L);
		x1p.add(x1T);
		
		JPanel y1p = new JPanel();
		y1L = new JLabel("y1");
		y1T = new JTextField("0", 5); // 
		y1p.add(y1L);
		y1p.add(y1T);
		
		JPanel x2p = new JPanel();
		x2L = new JLabel("x2");
		x2T = new JTextField("0", 5);
		x2p.add(x2L);
		x2p.add(x2T);
		
		JPanel y2p = new JPanel();
		y2L = new JLabel("y2");
		y2T = new JTextField("0", 5);
		y2p.add(y2L);
		y2p.add(y2T);
		
		JPanel z1p = new JPanel();
		z1L = new JLabel("z1");
		z1T = new JTextField("50", 5);
		z1p.add(z1L);
		z1p.add(z1T);
		
		JPanel z2p = new JPanel();
		z2L = new JLabel("z2");
		z2T = new JTextField("50", 5);
		z2p.add(z2L);
		z2p.add(z2T);
		
		fill = new JCheckBox("채우기");

		p1.add(x1p);
		p1.add(y1p);
		p1.add(x2p);
		p1.add(y2p);
		p1.add(z1p);
		p1.add(z2p);
		p1.add(fill);
		
		can = new DrCanvas(this); // MsPaint값을 DrCanvas에 전달 (좌표값 필요하니까)		
		
		list = new ArrayList<ShapeDTO>();
		
		JPanel p2 = new JPanel(); // 아랫줄 패널
		line = new JRadioButton("선"); 
		circle = new JRadioButton("원");
		rect = new JRadioButton("사각형", true); // 사각형선택된 상태로 팝업되도록
		roundRect = new JRadioButton("둥근사각형");
		pen = new JRadioButton("연필");
		
		// JRadioButton은 그룹으로 묶으면 한개씩만 선택되도록 설정
		ButtonGroup group = new ButtonGroup(); 
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);
		
		// 색깔 인덱스번호는 0번~
		String[] color = {"빨강", "초록", "파랑", "하늘", "보라"}; // 콤보박스 안 항목 설정
		combo = new JComboBox<String>(color);
		// -- 콤보박스 안 항목 설정 방법 2 --
		// DefaultComboBoxModel<String> cmb = new DefaultComboBoxModel<String>();
		// cmb.addElement("빨강");
		// combo.setModel(cmb);
		
		draw = new JButton("그리기");
		p2.add(line);
		p2.add(circle);
		p2.add(rect);
		p2.add(roundRect);
		p2.add(pen);
		p2.add(combo);
		p2.add(draw);
		
		// Container 위가 아닌, JFrame 자체에 component들을 올려도 됨
		Container c = this.getContentPane();
		c.add(p1, "North");
		c.add(can, "Center");
		c.add(p2, "South");
		
		setBounds(800, 150, 700, 550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		draw.addActionListener(this);
		
		can.addMouseListener(new MouseAdapter() { 
			@Override
			public void mousePressed(MouseEvent e) {
				if(pen.isSelected()) {
					x1_temp = e.getX();
					y1_temp = e.getY();
					x1T.setText(e.getX()+"");
					y1T.setText(e.getY()+"");
					vector.add(e.getX());
					vector.add(e.getY());
				}else {				
				 x1T.setText(e.getX()+""); // getX()는 int형
				 y1T.setText(e.getY()+"");
				}
			} // mousePressed
			
			
			// 마우스가 release될 때 그렸던 도형의 정보를 dto 생성해서 저장 + list에 담기
			@Override
			public void mouseReleased(MouseEvent e) {
				int x1 = Integer.parseInt(x1T.getText());
				int y1 = Integer.parseInt(y1T.getText());
				if(x1 == e.getX() && y1 == e.getY()) return; // 제자리에서 누르기만 한건 저장x
				
				ShapeDTO dto = new ShapeDTO();
				dto.setX1(Integer.parseInt(x1T.getText()));
				dto.setX2(Integer.parseInt(x2T.getText()));
				dto.setY1(Integer.parseInt(y1T.getText()));
				dto.setY2(Integer.parseInt(y2T.getText()));
				dto.setZ1(Integer.parseInt(z1T.getText()));
				dto.setZ2(Integer.parseInt(z2T.getText()));
				dto.setFill(fill.isSelected());
				
				// 도형
				if(line.isSelected()) dto.setShape(Shape.LINE);
				else if(circle.isSelected()) dto.setShape(Shape.CIRCLE);
				else if(rect.isSelected()) dto.setShape(Shape.RECT);
				else if(roundRect.isSelected()) dto.setShape(Shape.ROUNDRECT);
				else if(pen.isSelected()) dto.setShape(Shape.PEN);
				
				dto.setColor(combo.getSelectedIndex());
				dto.setVector(vector);
				
				list.add(dto);
				
			} // mouseReleased
		});
		
		can.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				/*
				if(pen.isSelected()) {
					g = can.getGraphics();
					
					switch(combo.getSelectedIndex()) { // setForeground쓰면 repaint되어서 깜빡거림
					case 0 :g.setColor(Color.RED); break;
					case 1 :g.setColor(Color.GREEN); break;
					case 2 :g.setColor(Color.BLUE); break;
					case 3 :g.setColor(Color.CYAN); break;
					case 4 :g.setColor(Color.MAGENTA); break;
					}
					
					g.drawLine(x1_temp, y1_temp, e.getX(), e.getY());
					x1_temp = e.getX();
					y1_temp = e.getY();
					vector.add(e.getX());
					vector.add(e.getY());	
				}else {
				x2T.setText(e.getX()+"");
				y2T.setText(e.getY()+"");
				can.repaint(); // repaint할때마다 update()와 paint()를 계속해서 호출
				}
				*/
				
				//  --  이렇게 해도 됨 ( 선생님 방법 )
				x2T.setText(e.getX()+"");
				y2T.setText(e.getY()+"");
				can.repaint();
				
				if(pen.isSelected()) { //펜
	                ShapeDTO dto = new ShapeDTO();
	                
	                //좌표
	                dto.setX1(Integer.parseInt(x1T.getText()));
	                dto.setY1(Integer.parseInt(y1T.getText()));
	                dto.setX2(Integer.parseInt(x2T.getText()));
	                dto.setY2(Integer.parseInt(y2T.getText()));
	                
	                //색
	                dto.setColor(combo.getSelectedIndex());
	                
	                //도형
	                dto.setShape(Shape.PEN);
	                
	                list.add(dto);
	                
	                x1T.setText(x2T.getText());
	                y1T.setText(y2T.getText());
             	}//if
		
			}
		});
		
		
	} // 생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {
		can.repaint(); // 그냥 repaint()하면 프레임을 다시그림 (도형들은 canvas위에 있으니까)
	}
	
	// getter -- MsPaint 값들이 private이라 캔버스클래스에 바로 전달할 수 없으니까
	public JTextField getX1T(){
		return x1T;
	}
	
	public JTextField getX2T(){
		return x2T;
	}
	
	public JTextField getY1T(){
		return y1T;
	}
	
	public JTextField getY2T(){
		return y2T;
	}
	
	public JTextField getZ1T(){
		return z1T;
	}
	
	public JTextField getZ2T(){
		return z2T;
	}
	
	public int getX1_temp() {
		return x1_temp;
	}
	
	public int getY1_temp() {
		return y1_temp;
	}
	
	public JCheckBox getFill() {
		return fill;
	}
	
	public JComboBox<String> getCombo() {
		return combo;
	}
	
	public JRadioButton getLine() {
		return line;
	}
	
	public JRadioButton getCircle() {
		return circle;
	}
	
	public JRadioButton getRect() {
		return rect;
	}
	
	public JRadioButton getRoundRect() {
		return roundRect;
	}
	
	public JRadioButton getPen() {
		return pen;
	}
	
	public List<ShapeDTO> getList(){ 
		return list;
	}
	
	//-------------------------------------------------------
	public static void main(String[] args) {
		new MsPaint();
	}


}
