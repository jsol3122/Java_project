package constructor;

class ConstructorTest{
	String name=null;	
	int age=0;		
	
	public ConstructorTest() {
		System.out.println("default 생성자");
		System.out.println("this = "+this);
	}
	public ConstructorTest(String name) {
		this();
		this.name = name;
		System.out.println("this = "+this);
	}
	public ConstructorTest(int age) {
		this("코난"); // Overload된 다른 생성자를 호출 / 호출은 무조건 첫줄에 써야함
		this.age = age;
		System.out.println("this = "+this);
	}
	
}

//-------------------------------

public class ConstructorMain {

	public static void main(String[] args) {
		ConstructorTest aa = new ConstructorTest();
		System.out.println("aa = "+aa);
		System.out.println("이름 = "+aa.name+"\t 나이 = "+aa.age);
		System.out.println();
		
		ConstructorTest bb = new ConstructorTest("홍길동");
		System.out.println("bb = "+bb);
		System.out.println("이름 = "+bb.name+"\t 나이 = "+bb.age);
		System.out.println();
		
		ConstructorTest cc = new ConstructorTest(25);
		System.out.println("cc = "+cc);
		System.out.println("이름 = "+cc.name+"\t 나이 = "+cc.age);
		System.out.println();
	}

}
