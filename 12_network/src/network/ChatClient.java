package network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClient extends JFrame implements ActionListener, Runnable{
	private JTextArea output;
	private JTextField input;
	private JButton sendBtn;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
		
	public ChatClient() {
		output = new JTextArea();
		output.setFont(new Font("����ü", Font.BOLD, 16));
		output.setEditable(false); // ����� �����Է��� �ȵǰ� ä�ó��� �޾Ƽ� ��¸� �ǵ���
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // ���ν�ũ�ѹ� �׻����
		input = new JTextField(); // âũ�� Ŀ���� ���� Ŀ������ �Ϸ���, �갡 �ö��ִ� �г��� ���̾ƿ� �ٲ��ֱ�
		sendBtn = new JButton("������");
		
		JPanel p = new JPanel(new BorderLayout()); // �г� �⺻������ flowlayout�� ��������̶� ȭ�鿡 ������ ���� - border�̿�
		p.add(input, "Center"); // ���� ���� center�� �־ ȭ�� Ŀ���� ���� Ŀ������
		p.add(sendBtn, "East"); // �����ʿ� �۰� �����̾�� �ϴϱ� east�� ���
		
		Container c = getContentPane();
		
		c.add(scroll, "Center");
		c.add(p, "South");
		
		setBounds(800, 150, 300, 300);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE); - ��ȥ�� �� ������ ��뼭�� �������ϱ� �ٷ� ������ �ϱ�		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				pw.println("quit"); // �������� ���´ٰ� ���ϱ�
				pw.flush(); // buffer����
			}
		});
		
		sendBtn.addActionListener(this);
		input.addActionListener(this); // ����ĥ�� �ԷµǱ�
	}
	
	public void service() {
		// ����ip   -- ��� 1
//		String serverIP = JOptionPane.showInputDialog(this, "����IP�� �Է��ϼ���", "����IP",
//													JOptionPane.INFORMATION_MESSAGE);
		
		// ����ip   -- ��� 2 ( ����Ʈ�� �պκ��� ����ְ� ������ ���ڸ��� �ֵ��� )
		String serverIP = JOptionPane.showInputDialog(this, "����IP�� �Է��ϼ���", "192.168.0.");
		if(serverIP == null || serverIP.length() == 0) { // ���� �ٷ���� or �������� Ȯ�δ��� ���
			System.out.println("����IP�� �Էµ��� �ʾҽ��ϴ�");
			System.exit(0);
		}
		String nickName = JOptionPane.showInputDialog(this, "�г����� �Է��ϼ���", "�г���",
													JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length() == 0) { // �г��� �Ⱦ��ų� �ٷ�����ϸ� �Խ�Ʈ�� ����
			nickName = "guest";
		}
		
		try {
			// ���� ����
			socket = new Socket(serverIP, 9500);  // ��Ʈ��ȣ�� 9500���� �����ϵ��� �������
			
			// IO
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // �޴°�
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream())); // �����°�
			
			// �г����� ������ ������ - ó���� ���ѹ��� ����
			pw.println(nickName); // pw�� �⺻���� \n�� �����ϴ� �޼ҵ� ����
			pw.flush(); // buffer ����
		} catch (UnknownHostException e) {
			System.out.println("������ ã�� �� �����ϴ�"); // �߸��� ���� ����
			e.printStackTrace();
			System.exit(0); 
		} catch (IOException e) {
			System.out.println("������ ������ �� �����ϴ�"); // ���������� ���ߴµ� ���������
			e.printStackTrace();
			System.exit(0); 
		}
		
		// Thread ����
		Thread t = new Thread(this);
		t.start(); // thread ���� - run() ã���� ��
	} // service()
	
	@Override
	public void run() { // �������� �޴� �� - ���� action�� �����ϰ� ��ȭ������ ��� �޾Ƽ� �۵��ϸ� ��µǾ�� �ϴϱ�
		String line = null;
		while(true) { // ���� â���� �������� ��� ���ο� ��ȭ���� �޾Ƽ� ����ؾ� �ϴϱ�
			try {
				line = br.readLine();
				 // ��밡 â���� �����µ� ���������尡 ���ٰ� �Ǽ��� null���� �� ���� or ��Ʈ��ũ ��Ȱx or ���� ���ڰ��Ѱ� ����ö�
				if(line == null || line.toLowerCase().equals("quit")) {
					br.close();
					pw.close();
					socket.close();
					System.exit(0); // ��뼭�� �������� �츮�� ����
				}
				output.append(line+"\n"); // ����� ���� ���� ������ֱ� + readLine()�� ���Ͱ� �����ϱ�
				int pos = output.getText().length();
				output.setCaretPosition(pos); // ��ũ�ѹ� �ڵ����� ��������
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // ������ ������ ��
		// JTextField ���� ������ �����ͼ� ������ ������ buffer ����� ��!! JTextField �ʱ�ȭ
		pw.println(input.getText());
		pw.flush();
		input.setText("");
	}
	
//------------------------------------------------------------------------------
	public static void main(String[] args) {
		new ChatClient().service();
	}

}
