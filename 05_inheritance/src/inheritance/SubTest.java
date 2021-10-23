package inheritance;

public class SubTest extends SuperTest { // SuperTest(부모)의 자식클래스임을 설정해줌
	// 상속된 관계가 있을 경우 일단 자식클래스부터 검색하고 수행한 후 부모클래스를 찾으러 감
	// 부모클래스의 기본생성자 필요 - 기본생성자 자동호출하려면 클래스안에 생성자 0개여야 함
	// 지금은 생성자(double,double) 있어서 자동으로 안만들어지니까 기본생성자 없다고 에러뜸
	// 
	private String name; // private걸면 상속 안되고 나만 씀
	private int age;

	public SubTest(String name, int age, double weight, double height) {
		System.out.println("SubTest클래스 생성자");
		this.name=name;
		this.age=age;
		this.weight=weight; // 부모것도 내것이기 때문에 this 가능
		this.height=height;
		// super.weight=weight; 로 하면 부모 것을 바로 갖고오는 것
		// this쓰는것과 super쓰는것 결과는 동일하지만 this가 더 범용성있음
	}
	
	public void output() {
		System.out.println("SubTest클래스 output()");
		System.out.println("이름 = "+ name);
		System.out.println("나이 = "+age);
		System.out.println("몸무게 = "+weight);
		System.out.println("키 = "+height);
	}
	public static void main(String[] args) {
		SubTest aa = new SubTest("홍길동", 25, 72.3, 185.3); 
		// 자식클래스로 new설정하면 자식+부모 메모리 같이 생성 = 생성자도 두개 호출
		aa.output();
		System.out.println("--------------------------");
		aa.disp(); // 우선 내 클래스 안에서 찾고 없으면 부모(SuperTest)로 찾으러 감
		System.out.println("--------------------------");
		
		SuperTest bb = new SubTest("코난", 13, 25.6, 158.7);
		// bb.output();  --> 불가능 : SuperTest만 참조하기 때문 // 생성자는 부모/자식 둘다 생성됨
		// 부모는 자식클래스를 참조할 수 있다! 중요하고 많이 씀
		bb.disp();
	}

}
