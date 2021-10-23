package collection;

class GenericTest<T>{  // 어떤 타입이 들어갈지 아직 안정했다는 뜻으로 T
	private T a;
	
	public void setA(T a) {
		this.a = a;
	}
	public T getA() {
		return a;
	}
}


//--------------------------------------------------------------
public class GenericMain {

	public static void main(String[] args) { // 타입은 기본형x 
		GenericTest<String> aa = new GenericTest<String>(); 
		// 실행할 때 들어갈 타입 정해주는 것
		aa.setA("홍길동");
		System.out.println(" 이름 = "+aa.getA());
		
		// aa.setA(25); - 이건 에러 / String타입으로 하기로 결정했기 때문
		
		GenericTest<Integer> bb = new GenericTest<Integer>();
		// 같은 클래스를 다른 타입으로 또잡을 수도 있음
		bb.setA(25); // 가능
		System.out.println(" 나이 = "+bb.getA());
	}
	
	

}
