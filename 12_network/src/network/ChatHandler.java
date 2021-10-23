package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

// handler�� Ŭ���̾�Ʈ�κ��� ���� ������ �о�ͼ� �ٽ� Ŭ���̾�Ʈ�� ����
public class ChatHandler extends Thread{ // handler�� thread�� IO�� socket�� �����ϰ� �ִ�
	private Socket socket;
	private List<ChatHandler> list;
	private BufferedReader br;
	private PrintWriter pw;
	
	public ChatHandler(Socket socket, List<ChatHandler> list) throws IOException {
		this.socket = socket;
		this.list = list;
		
		br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // �޴°�
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream())); 
		
	} // ������
	
	@Override
	public void run() { // �������� ���� ó�� �޴� ���� nickName��(�� �ѹ��� ����)
		String nickName = null;
		String line = null; // Ŭ���̾�Ʈ�κ��� ���� ����
		
		try {
			nickName = br.readLine();
			broadcast(nickName+"���� �����Ͽ����ϴ�"); // ���� nickName�� ��� client�鿡�� �߼� 
			
			while(true) { 
				// Ŭ���̾�Ʈ�κ��� ���� ������ �о��
				line = br.readLine();
				
				// ��밡 â���� �����µ� ���������尡 ���ٰ� �Ǽ��� null���� �� ���� or ��Ʈ��ũ ��Ȱx or Ŭ���̾�Ʈ�� ���ڰ��Ҷ� 
				if(line == null || line.toLowerCase().equals("quit")) { 
					break; // ���⼭ System.exit(0);�ع����� �ȵ� - ���⼭ ������ �ΰ��� �ٸ� ó�� �ʿ�
				}
				
				// Ŭ���̾�Ʈ�� ������ �ٽ� ������
				broadcast("[ "+nickName+" ] "+line); // ��� Ŭ���̾�Ʈ���� ����
				
			} // while
			
			// quit�������� ó�� 1 - �׸��Ѵٴ� Ŭ���̾�Ʈ���� quit�ٽ� ������ ����
			pw.println("quit");
			pw.flush();
			
			br.close();
			pw.close();
			socket.close();
			// quit�������� ó�� 2 - ������ Ŭ���̾�Ʈ�鿡�� �������� �����ٰ� ����޽��� ����
			list.remove(this); // ���� �׸��дٰ� �� �ִ� list���� ����
			broadcast(nickName+"���� �����Ͽ����ϴ�"); // ������ Ŭ���̾�Ʈ�鿡�� �޽�������
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // run

	public void broadcast(String msg) {
		for(ChatHandler handler : list) { // list�� ����� ���handler�� ������
			handler.pw.println(msg); // �� ���handler�� �޽����� ����
			handler.pw.flush();
		}
		
	}
	
}
