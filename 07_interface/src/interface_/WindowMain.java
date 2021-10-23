package interface_;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// Frame�� BorderLayout(�������ϼ���)
// �������Ͽ��� �Ѱ��� component�� �ö� �� ���� - �׷��� �г��� ���� ��ư ������ �ø��� ��
class WindowTest extends Frame implements ActionListener, MouseListener{
	private Button newBtn, exitBtn;
	private TextArea area;
	
	public void init() {
		newBtn = new Button("���θ����");
		exitBtn = new Button("����");
		area = new TextArea(); // ä��â ����� ����
		
		Panel p = new Panel(); // FlowLayout (����߽����� ������� ��ġ)
		p.add(newBtn);
		p.add(exitBtn);
		
		this.add("North", p);
		this.add("Center",area);
		
		setBounds(700, 200, 300, 400); 
		// �׻� �տ� this.�� �����Ȱ���
		// this�� �ڽſ��� ã�� ������ �θ�, �Ǿ����� ���θ�, ...
		setVisible(true);
		
		this.addWindowListener(new WindowExit()); // windowexitŬ�������� �����θ� �����ִٰ� ���� - �űⰡ�� �����ϰ� ���ƿ�
		this.addMouseListener(this);
		//����(this)�� ������ override(����)������ JVM�� ��ǿ� �°� ȣ���ض�
		newBtn.addActionListener(this);
		exitBtn.addActionListener(this);
	}

	// MouseListener Override
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("���콺 Ŭ��!");
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("���콺 in");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("���콺 out");
	}

	// ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newBtn) { // �ʱ�ȭ �ȵǴ¿������� area.setText("  ");���� ������ �ٽ� �ʱ�ȭ��Ű�� ��
			area.setText(""); // �ʱ�ȭ (area�� text���� �� �����)
		}
		else if(e.getActionCommand()=="����") {
			System.exit(0);
		}
	}
}

//--------------------------------------------
public class WindowMain {

	public static void main(String[] args) {
		new WindowTest().init();

	}

}
