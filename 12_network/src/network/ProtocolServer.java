package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtocolServer { // ������ Ŭ���̾�Ʈ�� �ִ� ������ �޾Ƹ�ĥ��, ��ü�� �޽���x
	private ServerSocket serverSocket;
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	
	public ProtocolServer() {
		try {
			serverSocket = new ServerSocket(9500); // port 9500���� �����ϱ�� �츮 ����߾���
			System.out.println("�����غ�Ϸ�"); // ���������� Ŭ���̾�Ʈ �ϴ� ��ٸ��⸸ ��
			
			// Ŭ���̾�Ʈ�� �����̶�� ���ѷ��� ������ ��
			socket = serverSocket.accept(); // Ŭ���̾�Ʈ �����ϸ� ����ä�� ���socket����
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		} catch (IOException e) {
			System.out.println("Ŭ���̾�Ʈ�� ������� �ʾҽ��ϴ�");
			e.printStackTrace();
			System.exit(0); // ���� �ȵȰŸ� �ǹ̾����ϱ� ���������
		} 
		
		String line = null;
		while(true) { // ������ Ŭ���̾�Ʈ�� �ִ� ������ �޾Ƹ�ġ�⸸ ��
			try {
				// Ŭ���̾�Ʈ�κ��� �޴� ��
				line = br.readLine(); // readLine()�� ���ٸ� ������ ���ʹ� ���а�, ���� �������� ����
				
				// Ŭ���̾�Ʈ�� ������ ��
				String[] ar = line.split(":");
				if(ar[0].equals(Protocol.ENTER)) { // "100"�� ������ �ǹ�
					bw.write(ar[1]+"�� ����\n"); // Ŭ���̾�Ʈ�� readLine�� ã�� ���Ͱ� �־��ֱ�
					bw.flush(); // ���� �� ������ buffer����ֱ�
				}else if(ar[0].equals(Protocol.EXIT)){
					bw.write(ar[1]+"�� ����\n");
					bw.flush();
					bw.close(); // �����̴ϱ� ���⼭�� �����ֱ� - Ŭ���̾�Ʈ������ �����״� ���������ʼ�!
					br.close();
					socket.close();
					System.exit(0);
				}else if(ar[0].equals(Protocol.SEND_MESSAGE)) {
					bw.write("[ "+ar[1]+" ] "+ar[2]+"\n");
					bw.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	} // ������
	
	public static void main(String[] args) {
		new ProtocolServer();
	}
}
