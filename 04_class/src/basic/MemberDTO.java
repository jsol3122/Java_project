package basic;

public class MemberDTO { //Ŭ������ �׻� 1�κ� ����, (Data Transfer Object=MemberVO(Value Object), 1�κб��� ������ ���
						 //������ ���常 �ϱ�
	private String name, cellphone, address;
	private int age;
	
	public void setName(String name) {
		this.name=name;}
	public void setAge(int age) {
		this.age=age;}
	public void setCellphone(String cellphone) {
		this.cellphone=cellphone;}
	public void setAddress(String address) {
		this.address=address;}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getCellphone() {
		return cellphone;
	}
	public String getAddress() {
		return address;
	}
}
