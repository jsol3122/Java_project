package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProtocolClient {
	private Socket socket; // IO�� ���� ���� (�ڵ��� ����)
	private BufferedReader br, keyboard;
	private BufferedWriter bw;
	
	public ProtocolClient() {
		try {
			socket = new Socket("192.168.219.188", 9500); // ���ϻ��� - ���� ip�� port��ȣ�̿�
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			keyboard = new BufferedReader(new InputStreamReader(System.in));
		} catch (UnknownHostException e) {
			System.out.println("������ ã�� �� �����ϴ�"); // �߸��� ���� ����
			e.printStackTrace();
			System.exit(0); // ���� ���ϴϱ� �׳� ������ѹ�����
		} catch (IOException e) {
			System.out.println("������ ������ �� �����ϴ�"); // ���������� ���ߴµ� ���������
			e.printStackTrace();
			System.exit(0); // ���� ���ϴϱ� �׳� ������ѹ�����
		} 
		
		String msg = null;
		String line = null;
		while(true) { // ��ȭ�� ���� ������ ������ ��ӵ�
			try {
				// ������ ������ �� - ������ ���� �޾Ƹ��� ��
				System.out.print("�Է� : "); // "300:angel:�޽���" or "100:angel"�� ���� ����
				msg = keyboard.readLine();
				
				bw.write(msg+"\n"); // ������ ������ - "100:angel" or "300:angel:�ȳ�"�� ���� ������
				// ���� msg�� readLine���� ���� �� ���͸� ã�������� �б⶧����, ���� ������ ������ã���� ��ǻ�� ����
				bw.flush(); // buffer����ֱ� - ������־�� ���������Ͱ� ��
				
				// �������� �ٽ� �޴� �� - TCP�� ������ �ʼ�
				line = br.readLine(); // "angel�� ����" or "[angel] �ȳ�" �� ���� ����
				System.out.println(line);
				
				String[] ar = msg.split(":");
				if(ar[0].equals("200")) { // ���� ���ڰ� �����ϱ�
					br.close();
					bw.close();
					socket.close();
					keyboard.close(); // close()�� ���ʿ��� �Ͼ�� ��
					System.exit(0); // ������ �����ֱ�
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	} // ������
	
	public static void main(String[] args) {
		new ProtocolClient();
	}
}
