package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtocolServer { // 서버는 클라이언트가 주는 내용을 메아리칠뿐, 자체적 메시지x
	private ServerSocket serverSocket;
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	
	public ProtocolServer() {
		try {
			serverSocket = new ServerSocket(9500); // port 9500으로 통일하기로 우리 약속했었음
			System.out.println("서버준비완료"); // 서버소켓은 클라이언트 일단 기다리기만 함
			
			// 클라이언트가 여럿이라면 무한루프 돌려야 함
			socket = serverSocket.accept(); // 클라이언트 접속하면 낚아채서 담당socket생성
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		} catch (IOException e) {
			System.out.println("클라이언트와 연결되지 않았습니다");
			e.printStackTrace();
			System.exit(0); // 연결 안된거면 의미없으니까 끊어버리기
		} 
		
		String line = null;
		while(true) { // 서버는 클라이언트가 주는 내용을 메아리치기만 함
			try {
				// 클라이언트로부터 받는 쪽
				line = br.readLine(); // readLine()은 한줄만 읽으며 엔터는 안읽고, 엔터 전까지만 읽음
				
				// 클라이언트로 보내는 쪽
				String[] ar = line.split(":");
				if(ar[0].equals(Protocol.ENTER)) { // "100"과 동일한 의미
					bw.write(ar[1]+"님 입장\n"); // 클라이언트의 readLine이 찾을 엔터값 넣어주기
					bw.flush(); // 다음 값 들어오게 buffer비워주기
				}else if(ar[0].equals(Protocol.EXIT)){
					bw.write(ar[1]+"님 퇴장\n");
					bw.flush();
					bw.close(); // 퇴장이니까 여기서도 끊어주기 - 클라이언트에서도 끊을테니 양방향끊기필수!
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
	} // 생성자
	
	public static void main(String[] args) {
		new ProtocolServer();
	}
}
