package inheritance;

public class SuperTest {
	protected double weight, height;
	
	public SuperTest() {
		System.out.println("SuperTest클래스 기본생성자");
	}
	
	// 생성자 - 같은 형의 인수(매개변수)라도 double w, h; 이렇게 쓰면 안됨
	public SuperTest(double weight, double height) {
		System.out.println("SuperTest클래스 생성자");
		this.weight=weight;
		this.height=height;				
	}
	
	// getter쓰는 대신 바로 출력해버릴 수도 있음
	public void disp() { // 자식클래스에 똑같은 이름의 disp()생성가능 - 이름만 같은거지 다른거임 => Override
		System.out.println("SuperTest클래스 disp()");
		System.out.println("몸무게 = "+weight);
		System.out.println("키 = "+height);
	}
	
	
}
