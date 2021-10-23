package interface_;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener, WindowListener{
	private JLabel idL, pwdL;
	private JTextField idT;
	private JPasswordField pwdT; // ��ȣ�� �Ⱥ������ؼ� textfield�ϸ� �ȵ�
	private JButton loginBtn, resetBtn;
	
	
	public Login() {
		this.setLayout(null);
		
		idL = new JLabel("���̵�");
		pwdL = new JLabel("��й�ȣ");
		idT = new JTextField();
		pwdT = new JPasswordField();
		loginBtn = new JButton("�α���");
		resetBtn = new JButton("�ٽ��ۼ�");
		
		idL.setLocation(100,30);
		idL.setSize(80,40);
		pwdL.setLocation(100,80);
		pwdL.setSize(80,40);
		
		idT.setLocation(200,30);
		idT.setSize(100,40);
		pwdT.setLocation(200,80);
		pwdT.setSize(100,40);
		
		loginBtn.setLocation(90,150);
		loginBtn.setSize(100,30);
		resetBtn.setLocation(200,150);
		resetBtn.setSize(100,30);
		
		this.add(idL);
		this.add(pwdL);
		this.add(idT);
		this.add(pwdT);
		this.add(loginBtn);
		this.add(resetBtn);
		
		setBounds(700, 100, 400, 250);
		setVisible(true);
		
		resetBtn.addActionListener(this);
		loginBtn.addActionListener(this);
		this.addWindowListener(this);
	} //������ 
	
	@Override
	public void actionPerformed(ActionEvent e) { // ��ư �ϳ��� �����ʿ��������� if�ʿ����
			if(e.getSource()==loginBtn) {
				String id = idT.getText();
				String pwd = pwdT.getText();
				new LoginResult(id, pwd);
			}else if(e.getSource()==resetBtn) {
				idT.setText("");
				pwdT.setText("");
			}
	}
	
	// windowListener
	@Override
	public void windowOpened(WindowEvent e) {	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("���α׷� ����");
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {	}

	@Override
	public void windowIconified(WindowEvent e) {	}

	@Override
	public void windowDeiconified(WindowEvent e) {	}

	@Override
	public void windowActivated(WindowEvent e) { }

	@Override
	public void windowDeactivated(WindowEvent e) {	}
	
	public static void main(String[] args) {
		new Login();
	} // main
}
