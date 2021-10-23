package network;

import java.io.Serializable;

enum Info{ // 상수화 잡기
	JOIN, EXIT, SEND
}

public class InfoDTO implements Serializable{
	private String nickName;
	private String message;
	private Info command;
	
	// setter, getter
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Info getCommand() {
		return command;
	}
	public void setCommand(Info command) {
		this.command = command;
	}
}
