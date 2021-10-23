package nested;

public class AbstractMain {

	public static void main(String[] args) {
		AbstractTest at = new AbstractTest() { // 추상에 익명 inner class를 new 시켜서 간접적으로 new 생성하기
			
			@Override
			public void setName(String name) {}
		};
		InterA in = new InterA() { // 인터페이스에 익명 inner class를 new 시켜서 간접적으로 new 생성하기

			@Override
			public void aa() {} // 추상메소드있는 추상클래스 - override 필수!!

			@Override
			public void bb() {}
		};
		
		AbstractExam ae = new AbstractExam() {
			// override 해도되고 안해도됨 - 추상메소드 없는 추상클래스
		};
	}


}
