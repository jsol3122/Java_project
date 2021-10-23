package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProtocolClient {
	private Socket socket; // IO를 갖고 있음 (핸드폰 역할)
	private BufferedReader br, keyboard;
	private BufferedWriter bw;
	
	public ProtocolClient() {
		try {
			socket = new Socket("192.168.219.188", 9500); // 소켓생성 - 각자 ip와 port번호이용
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			keyboard = new BufferedReader(new InputStreamReader(System.in));
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다"); // 잘못된 서버 지정
			e.printStackTrace();
			System.exit(0); // 연결 못하니까 그냥 종료시켜버리기
		} catch (IOException e) {
			System.out.println("서버와 연결할 수 없습니다"); // 서버지정은 잘했는데 응답없을떄
			e.printStackTrace();
			System.exit(0); // 연결 못하니까 그냥 종료시켜버리기
		} 
		
		String msg = null;
		String line = null;
		while(true) { // 대화는 끊기 전까지 무한히 계속됨
			try {
				// 서버로 보내는 쪽 - 서버는 그저 메아리일 뿐
				System.out.print("입력 : "); // "300:angel:메시지" or "100:angel"과 같은 형식
				msg = keyboard.readLine();
				
				bw.write(msg+"\n"); // 서버로 보내기 - "100:angel" or "300:angel:안녕"과 같이 보내짐
				// 보낸 msg를 readLine으로 읽을 때 엔터를 찾을때까지 읽기때문에, 엔터 없으면 영원히찾느라 컴퓨터 망함
				bw.flush(); // buffer비워주기 - 비워져있어야 다음데이터가 들어감
				
				// 서버에서 다시 받는 쪽 - TCP는 응답이 필수
				line = br.readLine(); // "angel님 입장" or "[angel] 안녕" 과 같이 들어옴
				System.out.println(line);
				
				String[] ar = msg.split(":");
				if(ar[0].equals("200")) { // 내가 끊자고 했으니까
					br.close();
					bw.close();
					socket.close();
					keyboard.close(); // close()는 양쪽에서 일어나야 함
					System.exit(0); // 완전히 끊어주기
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	} // 생성자
	
	public static void main(String[] args) {
		new ProtocolClient();
	}
}
