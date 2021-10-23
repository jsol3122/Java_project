package swing;

public class PersonDTO {
	private String id;
	private String name;
	private String pwd;
	private String phone;
	
	public PersonDTO(String id, String name, String pwd, String phone) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
	} // »ý¼ºÀÚ

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
