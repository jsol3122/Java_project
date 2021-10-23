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
		output.setFont(new Font("돋움체", Font.BOLD, 16));
		output.setEditable(false); // 여기는 직접입력이 안되고 채팅내용 받아서 출력만 되도록
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // 세로스크롤바 항상출력
		input = new JTextField(); // 창크기 커지면 같이 커지도록 하려면, 얘가 올라가있는 패널의 레이아웃 바꿔주기
		sendBtn = new JButton("보내기");
		
		JPanel p = new JPanel(new BorderLayout()); // 패널 기본설정인 flowlayout은 가운데정렬이라 화면에 꽉차지 않음 - border이용
		p.add(input, "Center"); // 가장 넓은 center에 넣어서 화면 커져도 같이 커지도록
		p.add(sendBtn, "East"); // 오른쪽에 작게 고정이어야 하니까 east로 잡기
		
		Container c = getContentPane();
		
		c.add(scroll, "Center");
		c.add(p, "South");
		
		setBounds(800, 150, 300, 300);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE); - 나혼자 걍 끊으면 상대서버 에러나니까 바로 못끊게 하기		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				pw.println("quit"); // 서버에게 끊는다고 말하기
				pw.flush(); // buffer비우기
			}
		});
		
		sendBtn.addActionListener(this);
		input.addActionListener(this); // 엔터칠때 입력되기
	}
	
	public void service() {
		// 서버ip   -- 방법 1
//		String serverIP = JOptionPane.showInputDialog(this, "서버IP를 입력하세요", "서버IP",
//													JOptionPane.INFORMATION_MESSAGE);
		
		// 서버ip   -- 방법 2 ( 디폴트로 앞부분은 잡아주고 마지막 세자리만 넣도록 )
		String serverIP = JOptionPane.showInputDialog(this, "서버IP를 입력하세요", "192.168.0.");
		if(serverIP == null || serverIP.length() == 0) { // 들어가서 바로취소 or 공란으로 확인누를 경우
			System.out.println("서버IP가 입력되지 않았습니다");
			System.exit(0);
		}
		String nickName = JOptionPane.showInputDialog(this, "닉네임을 입력하세요", "닉네임",
													JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length() == 0) { // 닉네임 안쓰거나 바로취소하면 게스트로 설정
			nickName = "guest";
		}
		
		try {
			// 소켓 생성
			socket = new Socket(serverIP, 9500);  // 포트번호는 9500으로 통일하도록 약속했음
			
			// IO
			br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 받는거
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream())); // 보내는거
			
			// 닉네임을 서버로 보내기 - 처음에 딱한번만 보냄
			pw.println(nickName); // pw는 기본으로 \n을 포함하는 메소드 있음
			pw.flush(); // buffer 비우기
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다"); // 잘못된 서버 지정
			e.printStackTrace();
			System.exit(0); 
		} catch (IOException e) {
			System.out.println("서버와 연결할 수 없습니다"); // 서버지정은 잘했는데 응답없을떄
			e.printStackTrace();
			System.exit(0); 
		}
		
		// Thread 생성
		Thread t = new Thread(this);
		t.start(); // thread 실행 - run() 찾으러 감
	} // service()
	
	@Override
	public void run() { // 서버에서 받는 쪽 - 나의 action과 무관하게 대화내용은 계속 받아서 작동하며 출력되어야 하니까
		String line = null;
		while(true) { // 내가 창끄기 전까지는 계속 새로운 대화내용 받아서 출력해야 하니까
			try {
				line = br.readLine();
				 // 상대가 창끄고 나갔는데 남은스레드가 돌다가 실수로 null들어올 때 있음 or 네트워크 원활x or 내가 끊자고한거 응답올때
				if(line == null || line.toLowerCase().equals("quit")) {
					br.close();
					pw.close();
					socket.close();
					System.exit(0); // 상대서버 끊겼으니 우리도 끊기
				}
				output.append(line+"\n"); // 제대로 들어온 값은 출력해주기 + readLine()은 엔터값 없으니까
				int pos = output.getText().length();
				output.setCaretPosition(pos); // 스크롤바 자동으로 내려가기
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // 서버로 보내는 쪽
		// JTextField 안의 내용을 가져와서 서버로 보내고 buffer 비워준 후!! JTextField 초기화
		pw.println(input.getText());
		pw.flush();
		input.setText("");
	}
	
//------------------------------------------------------------------------------
	public static void main(String[] args) {
		new ChatClient().service();
	}

}
