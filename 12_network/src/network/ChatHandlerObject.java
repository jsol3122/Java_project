package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ChatHandlerObject extends Thread{
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private List<ChatHandlerObject> list;
	
	public ChatHandlerObject(Socket socket, List<ChatHandlerObject> list) throws IOException {
		this.socket = socket;
		this.list = list;
		
		// handler에서 출력IOStream을 먼저 생성해야 입장메시지가 제대로 뜸
		oos = new ObjectOutputStream(socket.getOutputStream()); // 보내는거
		ois = new ObjectInputStream(socket.getInputStream()); // 받는거
		
	} // 생성자
	
	@Override
	public void run() { // 서버에서 가장 처음 받는 값은 nickName임(딱 한번만 받음)
		InfoDTO dto = null; // 받는 dto - 보낼때 dto는 별도!!!!!!!!!!!!!!!!!
		String nickName = null;
		try {
			while(true) {  
				dto = (InfoDTO) ois.readObject();
				if(dto.getCommand()==Info.JOIN) {
					nickName = dto.getNickName();
					
					// 나포함 모든 클라이언트에게 입장메시지 보내기
					InfoDTO sendDTO = new InfoDTO(); // 보낼때 dto!!!!!!!!!!!!
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName+"님 입장하였습니다");
					broadcast(sendDTO);
				}else if(dto.getCommand()==Info.EXIT) { 
					break; // 여기서 System.exit(0);해버리면 안됨 - 여기서 나가서 두가지 다른 처리 필요
				}else if(dto.getCommand()==Info.SEND) {  // 클라이언트로 데이터 다시 보내기
					// 나포함 모든 클라이언트에게 메시지 보내기
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage("[ "+nickName+" ] "+dto.getMessage());
					broadcast(sendDTO); // 모든 클라이언트에게 전달
				}
			} // while
			
			// quit들어왓을때 처리 1 - 그만한다는 클라이언트에게 quit다시 보내고 종료
			InfoDTO sendDTO = new InfoDTO();
			sendDTO.setCommand(Info.EXIT);
			oos.writeObject(sendDTO);
			oos.flush();
			
			ois.close();
			oos.close();
			socket.close();
			// quit들어왓을때 처리 2 - 남아있는 클라이언트들에게 ㅇㅇ님이 나갔다고 퇴장메시지 전송
			list.remove(this); // 현재 그만둔다고 한 애는 list에서 지움
			sendDTO.setCommand(Info.SEND);
			sendDTO.setMessage(nickName+"님이 퇴장하였습니다");
			broadcast(sendDTO); // 나머지 클라이언트들에게 메시지전송
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // run

	public void broadcast(InfoDTO sendDTO) {
		for(ChatHandlerObject handler : list) { // list에 담겨진 담당handler들 꺼내옴
			try {
				handler.oos.writeObject(sendDTO);
				handler.oos.flush();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} // for	
	} // broadcast
}
