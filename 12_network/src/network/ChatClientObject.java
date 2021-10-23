package network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClientObject extends JFrame implements ActionListener, Runnable {
	private JTextArea output;
	private JTextField input;
	private JButton sendBtn;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private List<ChatHandlerObject> list;
		
	public ChatClientObject() {
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
				InfoDTO dto = new InfoDTO();
				dto.setCommand(Info.EXIT);
				
				try {
					oos.writeObject(dto); // �������� ���´ٰ� ���ϱ�
					oos.flush(); // buffer����
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			}
		});
		
		sendBtn.addActionListener(this);
		input.addActionListener(this); // ����ĥ�� �ԷµǱ�
	}
	
	public void service() {
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
			ois = new ObjectInputStream(socket.getInputStream()); // �޴°�
			oos = new ObjectOutputStream(socket.getOutputStream()); // �����°�
			
			// �г����� ������ ������ - ó���� ���ѹ��� ����
			InfoDTO dto = new InfoDTO();
			dto.setNickName(nickName);
			dto.setCommand(Info.JOIN);
			oos.writeObject(dto); // pw�� �⺻���� \n�� �����ϴ� �޼ҵ� ����
			oos.flush(); // buffer ����
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
		InfoDTO dto = null;
		while(true) { // ���� â���� �������� ��� ���ο� ��ȭ���� �޾Ƽ� ����ؾ� �ϴϱ�
			try {
				dto = (InfoDTO) ois.readObject(); // �����κ��� InfoDTO�� �Ѿ��
				 // ��밡 â���� �����µ� ���������尡 ���ٰ� �Ǽ��� null���� �� ���� or ��Ʈ��ũ ��Ȱx or ���� ���ڰ��Ѱ� ����ö�
				if(dto.getCommand()==Info.EXIT) {
					oos.close();
					ois.close();
					socket.close();
					System.exit(0); // ��뼭�� �������� �츮�� ����
				}else if(dto.getCommand()==Info.SEND) { // ��ü�� ������ �������� ���� ������
					output.append(dto.getMessage()+"\n");
					int pos = output.getText().length();
					output.setCaretPosition(pos); // ��ũ�ѹ� �ڵ����� ��������
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // ������ ������ ��
		// JTextField ���� ������ �����ͼ� ������ ������ buffer ����� ��!! JTextField �ʱ�ȭ
		String line = input.getText();
		InfoDTO dto = new InfoDTO();
		if(line.toLowerCase().equals("quit")) 
			dto.setCommand(Info.EXIT);
		else {
			dto.setCommand(Info.SEND);
			dto.setMessage(line);
		}
		try {			
			oos.writeObject(dto);
			oos.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		input.setText("");
	}
	
//------------------------------------------------------------------------------
	public static void main(String[] args) {
		new ChatClientObject().service();
	}

}
