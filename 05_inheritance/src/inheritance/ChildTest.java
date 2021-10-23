package inheritance;


public class ChildTest extends SuperTest {
	private String name; 
	private int age;
	
	public ChildTest(String name, int age, double weight, double height) {
		super(weight, height); //내가 원하는 부모생성자 선택해서 호출 - 맨 첫줄!
		// 기본부모생성자는 자동호출임 / 원하는 부모생성자호출은 super()로 불러오기
		
		System.out.println("ChildTest클래스 생성자");
		this.name=name;
		this.age=age;
		this.weight=weight; // 부모것도 내것이기 때문에 this 가능
		this.height=height;
		
	}
	
	public void disp() { // Override
		System.out.println("ChildTest클래스 disp()");
		System.out.println("이름 = "+ name);
		System.out.println("나이 = "+age);
		System.out.println("몸무게 = "+weight);
		System.out.println("키 = "+height);
	}
 
	public static void main(String[] args) {
		ChildTest aa = new ChildTest("홍길동", 25, 72.3, 185.3);
		aa.disp(); // 부모클래스에도 disp()가 있지만 자식클래스를 먼저 찾았을때 있으니까 자식꺼 호출됨
	
		SuperTest bb = new ChildTest("코난", 13, 25.6, 158.7);
		bb.disp(); // 부모클래스만 참조했지만, Override되어있기 때문에 자식꺼부터 찾아서 호출함
	}
}
