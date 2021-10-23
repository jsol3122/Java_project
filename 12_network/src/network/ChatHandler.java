package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

// handler는 클라이언트로부터 받은 내용을 읽어와서 다시 클라이언트로 전달
public class ChatHandler extends Thread{ // handler의 thread는 IO와 socket을 포함하고 있다
	private Socket socket;
	private List<ChatHandler> list;
	private BufferedReader br;
	private PrintWriter pw;
	
	public ChatHandler(Socket socket, List<ChatHandler> list) throws IOException {
		this.socket = socket;
		this.list = list;
		
		br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 받는거
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream())); 
		
	} // 생성자
	
	@Override
	public void run() { // 서버에서 가장 처음 받는 값은 nickName임(딱 한번만 받음)
		String nickName = null;
		String line = null; // 클라이언트로부터 받은 내용
		
		try {
			nickName = br.readLine();
			broadcast(nickName+"님이 입장하였습니다"); // 받은 nickName을 모든 client들에게 발송 
			
			while(true) { 
				// 클라이언트로부터 받은 데이터 읽어내기
				line = br.readLine();
				
				// 상대가 창끄고 나갔는데 남은스레드가 돌다가 실수로 null들어올 때 있음 or 네트워크 원활x or 클라이언트가 끊자고할때 
				if(line == null || line.toLowerCase().equals("quit")) { 
					break; // 여기서 System.exit(0);해버리면 안됨 - 여기서 나가서 두가지 다른 처리 필요
				}
				
				// 클라이언트로 데이터 다시 보내기
				broadcast("[ "+nickName+" ] "+line); // 모든 클라이언트에게 전달
				
			} // while
			
			// quit들어왓을때 처리 1 - 그만한다는 클라이언트에게 quit다시 보내고 종료
			pw.println("quit");
			pw.flush();
			
			br.close();
			pw.close();
			socket.close();
			// quit들어왓을때 처리 2 - 나머지 클라이언트들에게 ㅇㅇ님이 나갔다고 퇴장메시지 전송
			list.remove(this); // 현재 그만둔다고 한 애는 list에서 지움
			broadcast(nickName+"님이 퇴장하였습니다"); // 나머지 클라이언트들에게 메시지전송
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // run

	public void broadcast(String msg) {
		for(ChatHandler handler : list) { // list에 담겨진 담당handler들 꺼내옴
			handler.pw.println(msg); // 각 담당handler에 메시지를 전송
			handler.pw.flush();
		}
		
	}
	
}
