package basic;

class Person{ // 메뉴판임 - 메모리차지x / 사용하려면 new로 생성해줘야함!!
	private String name; 	// 필드. 초기화되어있기 때문에 기본적으로 쓰레기값 가지고 있음
	private int age;
	
	public void setName(String n) {
		name = n;
	}
	public void setAge(int a) {
		age = a;
	}
	public void setData(String n, int a) {
		name=n; age=a;
	}
	public void setData() {	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
//---------
public class PersonMain {

	public static void main(String[] args) {
		Person p; //객체임 (변수x)
		p = new Person(); // 메모리에 클래스(메뉴판) 생성해줌
		System.out.println("객체 p = "+p);
		System.out.println("객체 p = "+p.toString());
		p.setName("홍길동");
		p.setAge(25);
		// p.name = "홍길동";		---> Person클래스의 name과 age가 private되어있지 않을 때는 이렇게 호출
		// p.age = 25;
		System.out.println("이름 = "+p.getName()+"\t 나이 = "+p.getAge());
		System.out.println();
		
		Person p2 = new Person();
		System.out.println("객체 p2 = "+p2);
		p2.setName("코난");
		p2.setAge(13);
		System.out.println("이름 = "+p2.getName()+"\t 나이 = "+p2.getAge());
		System.out.println();
		
		Person p3 = new Person();
		p3.setData("라이언", 35);
		System.out.println("이름 = "+p3.getName()+"\t 나이 = "+p3.getAge());
		System.out.println();
		
		Person p4 = new Person();
		p3.setData();
		System.out.println("이름 = "+p4.getName()+"\t 나이 = "+p4.getAge());
		System.out.println();
		
	}
}
