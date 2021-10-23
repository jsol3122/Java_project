package class_;

public class StaticMain {
	private int a; // 필드, 인스턴스변수 / 구역 벗어나면 소멸 / 원래 this.변수명 형식임(this생략가능)
	// new로 생성할때마다 heap영역에 새로운 a값 생성
	
	private static int b; // 필드, 클래스변수 / 원래 클래스명.변수명 형식임(클래스명 생략가능)
	// 구역 상관없이 계속 static영역에 생존해서 메모리에 한번만 생성한거 계속씀 // 공유변수 - 모든객체가 공유
	
	public StaticMain() {	// new 할때마다 초기화 수행
		System.out.println("기본 생성자");
		a=3;
	}
	static {	// 딱 한번만 초기화 수행
		System.out.println("static 영역");
		b=3;
	}
	
	public void calc() {
		a++;
		b++;
	}
	
	public void disp() {
		System.out.println("a = "+this.a+"\t b = "+StaticMain.b); // static은 this값이 없음
	}
	public static void output() {
		System.out.println("static method ");
		//System.out.println("a = "+this.a+"\t b = "+StaticMain.b);
			// 윗줄은 static영역이기 때문에 this를 쓰면 에러남 (static아닌 인스턴스변수에 대한것이라도 this자체가 안됨)
	}
	
	public static void main(String[] args) {
		StaticMain st = new StaticMain(); // 생성자 자동호출되며 static이 아닌 a변수가 heap메모리에 생성됨
										// 그리고 생성자 안의 기능을 수행
		st.calc();	// a는 생성자에서 3값 줬고 b는 값 안줬으니가 계산완료하면 a=4 b=1 됨
		st.disp();	// 출력 " a=4 b=1 "
		System.out.println();
		
		StaticMain st2 = new StaticMain(); //새로 생성자 호출되며 static이 아닌 새로운 a변수가 heap메모리에 생성됨
		st2.calc();	// a는 다시생성된 별개의 값이라 다시 값 3 잡고, b는 아까 있던 값 static영역에서 소멸안해서 +1하면 a=4 b=2 됨
		st2.disp();	// 출력 " a=4 b=2 "
		System.out.println();
		
		StaticMain st3 = new StaticMain();	//추가로 또 생성자 호출되며 static이 아닌 새로운 a변수가 heap메모리에 생성됨
		st3.calc();	// a는 다시생성된 별개의 값이라 다시 값 3 잡고, b는 아까 있던 값 static영역에서 소멸안해서 +1하면 a=4 b=3 됨
		st3.disp();	// 출력 " a=4 b=3 "
		System.out.println();
		
		// static 메소드 호출
		StaticMain.output(); // 클래스명으로 바로 접근 가능  --> 클래스명.메소드()로 바로 호출
		output(); // class StaticMain 안이니까 --> output(); 이렇게만 불러도 호출가능
		st.output(); // 객체를 만들어놨다면 --> st.output();으로 객체명으로도 호출 가능
		
	}

} // class StaticMain
