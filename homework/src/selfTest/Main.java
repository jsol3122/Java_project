package selfTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener{

	public Main() {
		JButton b = new JButton("��ư");
		
		setSize(300,300);
		setVisible(true);
		add(b);
		b.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
		
		new Main();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "��ư") {
			System.out.println(e.getActionCommand());
		}
		
	}

}
