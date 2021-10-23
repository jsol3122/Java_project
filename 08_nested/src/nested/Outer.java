package nested;

public class Outer {
	private String name;
	
	public void output() {
		//System.out.println("이름 = "+name+"\t나이 = "+age); -- 내부클래스 바로 접근 불가능
		System.out.println("이름 = "+this.name+"\t나이 = "+new Inner().age); //객체생성해서 접근
	}
	
	class Inner{  // member inner
		private int age;
		
		public void disp() {
			System.out.println("이름 = "+Outer.this.name+"\t나이 = "+this.age);
		}
	}
	
	public static void main(String[] args) {
		Outer ou = new Outer();	// Inner클래스와 별개이므로 Outer클래스 메모리만 생성
		ou.name = "홍길동";
		ou.output();
		
		Outer.Inner in = ou.new Inner(); // new 할 때 내부클래스임을 알려줘야 함
		in.age = 25;
		in.disp();  // 외부클래스의 필드 가져다 쓸 수 있음
		
		Outer.Inner in2 = ou.new Inner();
		in2.age = 30;
		in2.disp();
		
		Outer.Inner in3 = new Outer().new Inner(); // 강제로 새 outer객체 만들어서 거기에 새로생성
		in3.age = 35;
		in3.disp();
		// in3.name(); --이건 불가능 / 내부클래스가 외부꺼 가져다쓰는건 클래스 안에서만 가능 
	}
}
