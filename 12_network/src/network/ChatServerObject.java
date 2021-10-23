package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerObject {
	private ServerSocket serverSocket;
	private List<ChatHandlerObject> list; // 클라이언트 개수만큼 생성된 Handler(IO + socket포함)를 list에 담음
	
	public ChatServerObject() {
		try {
			serverSocket = new ServerSocket(9500);
			System.out.println("서버준비 완료");
			
			list = new ArrayList<ChatHandlerObject>();
			
			// 클라이언트 수가 확정되지 않았으니, 클라이언트 들어올때마다 낚아채서 담당소켓 생성하는 무한루프 돌림
			// 각 클라이언트들이 가진 소켓들이 thread처리되기 때문에, 서버의 담당소켓들도 thread로 작동해야함
			while(true) { // 서버소켓이 클라이언트접속을 낚아채서 담당소켓(1:1) 생성
				Socket socket = serverSocket.accept(); // accept값이 없으면 새로운 socket,handler 생성x
				// accept함수 자체가 클라이언트 접속이 들어오지 않으면 들어올때까지 대기함 = 무한루프여도 accept에서만 대기
				
				// handler는 socket도 포함해야하고, 몇개의 클라이언트 있는지 알기 위해 기존list도 담아야 함
				ChatHandlerObject handler = new ChatHandlerObject(socket, list); // 담당소켓 생성될때마다 담당handler도 생성
				handler.start(); // thread 실행 - run()
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
