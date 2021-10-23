package collection;

class GenericTest2<T>{  // 어떤 타입이 들어갈지 아직 안정했다는 뜻으로 T
	private T a;
	
	public GenericTest2(T a) { // generic이라 맨날 String으로 고정 아니니까 T형으로
		this.a = a;
	} // 생성자
	
	public void setA(T a) {
		this.a = a;
	}
	public T getA() {
		return a;
	}
}


//--------------------------------------------------------------
public class GenericMain2 {

	public static void main(String[] args) {
		GenericTest2<?> aa = new GenericTest2<String>("홍길동");
		// 이렇게 ?잡으면 String으로 설정했지만, 클래스 내부에서는 Object타입처럼 실행됨
		// BUT, ?를 이용하면 setter로는 데이터입력 불가능 / 생성자 통한 입력만 가능
		String name = (String)aa.getA();
		// 클래스 내부에서 Object타입처럼 실행되고 있으므로, String타입으로 casting
		System.out.println("이름 = "+name);
		
		GenericTest2<?> bb = new GenericTest2<Integer>(25);
		int age = (Integer)bb.getA(); 
		// int형을 Integer(객체형)으로 형변환해서 받아도 ㅇㅋ - AutoUnboxing
		System.out.println("나이 = "+age);
	}

}
