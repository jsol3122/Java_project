package nested;

public class MemberDTO { // 사람 여러명이어도 무조건 1인분 단위
	private String name, id, pwd;

	//setter
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	//getter
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
}
