package basic;

public class MemberDTO { //클래스는 항상 1인분 단위, (Data Transfer Object=MemberVO(Value Object), 1인분기준 데이터 잡기
						 //데이터 저장만 하기
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
