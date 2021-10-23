package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerObject {
	private ServerSocket serverSocket;
	private List<ChatHandlerObject> list; // Ŭ���̾�Ʈ ������ŭ ������ Handler(IO + socket����)�� list�� ����
	
	public ChatServerObject() {
		try {
			serverSocket = new ServerSocket(9500);
			System.out.println("�����غ� �Ϸ�");
			
			list = new ArrayList<ChatHandlerObject>();
			
			// Ŭ���̾�Ʈ ���� Ȯ������ �ʾ�����, Ŭ���̾�Ʈ ���ö����� ����ä�� ������ �����ϴ� ���ѷ��� ����
			// �� Ŭ���̾�Ʈ���� ���� ���ϵ��� threadó���Ǳ� ������, ������ �����ϵ鵵 thread�� �۵��ؾ���
			while(true) { // ���������� Ŭ���̾�Ʈ������ ����ä�� ������(1:1) ����
				Socket socket = serverSocket.accept(); // accept���� ������ ���ο� socket,handler ����x
				// accept�Լ� ��ü�� Ŭ���̾�Ʈ ������ ������ ������ ���ö����� ����� = ���ѷ������� accept������ ���
				
				// handler�� socket�� �����ؾ��ϰ�, ��� Ŭ���̾�Ʈ �ִ��� �˱� ���� ����list�� ��ƾ� ��
				ChatHandlerObject handler = new ChatHandlerObject(socket, list); // ������ �����ɶ����� ���handler�� ����
				handler.start(); // thread ���� - run()
				list.add(handler); // 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatServerObject();
	}

}
