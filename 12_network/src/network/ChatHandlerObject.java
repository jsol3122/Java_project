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
		
		// handler���� ���IOStream�� ���� �����ؾ� ����޽����� ����� ��
		oos = new ObjectOutputStream(socket.getOutputStream()); // �����°�
		ois = new ObjectInputStream(socket.getInputStream()); // �޴°�
		
	} // ������
	
	@Override
	public void run() { // �������� ���� ó�� �޴� ���� nickName��(�� �ѹ��� ����)
		InfoDTO dto = null; // �޴� dto - ������ dto�� ����!!!!!!!!!!!!!!!!!
		String nickName = null;
		try {
			while(true) {  
				dto = (InfoDTO) ois.readObject();
				if(dto.getCommand()==Info.JOIN) {
					nickName = dto.getNickName();
					
					// ������ ��� Ŭ���̾�Ʈ���� ����޽��� ������
					InfoDTO sendDTO = new InfoDTO(); // ������ dto!!!!!!!!!!!!
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName+"�� �����Ͽ����ϴ�");
					broadcast(sendDTO);
				}else if(dto.getCommand()==Info.EXIT) { 
					break; // ���⼭ System.exit(0);�ع����� �ȵ� - ���⼭ ������ �ΰ��� �ٸ� ó�� �ʿ�
				}else if(dto.getCommand()==Info.SEND) {  // Ŭ���̾�Ʈ�� ������ �ٽ� ������
					// ������ ��� Ŭ���̾�Ʈ���� �޽��� ������
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage("[ "+nickName+" ] "+dto.getMessage());
					broadcast(sendDTO); // ��� Ŭ���̾�Ʈ���� ����
				}
			} // while
			
			// quit�������� ó�� 1 - �׸��Ѵٴ� Ŭ���̾�Ʈ���� quit�ٽ� ������ ����
			InfoDTO sendDTO = new InfoDTO();
			sendDTO.setCommand(Info.EXIT);
			oos.writeObject(sendDTO);
			oos.flush();
			
			ois.close();
			oos.close();
			socket.close();
			// quit�������� ó�� 2 - �����ִ� Ŭ���̾�Ʈ�鿡�� �������� �����ٰ� ����޽��� ����
			list.remove(this); // ���� �׸��дٰ� �� �ִ� list���� ����
			sendDTO.setCommand(Info.SEND);
			sendDTO.setMessage(nickName+"���� �����Ͽ����ϴ�");
			broadcast(sendDTO); // ������ Ŭ���̾�Ʈ�鿡�� �޽�������
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // run

	public void broadcast(InfoDTO sendDTO) {
		for(ChatHandlerObject handler : list) { // list�� ����� ���handler�� ������
			try {
				handler.oos.writeObject(sendDTO);
				handler.oos.flush();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} // for	
	} // broadcast
}
