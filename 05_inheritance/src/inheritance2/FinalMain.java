package inheritance2;

public class FinalMain {
	public final String FRUIT = "사과"; // static은 아니므로 객체생성필요
	public final String FRUIT2;
	
	public static final String ANIMAL = "호랑이";
	public static final String ANIMAL2;
	
	static { // static이라면 static영역으로 초기화 (생성자 불가능)
		ANIMAL2 = "기린";
	}
	public FinalMain() { // static아니라면 생성자로 초기화
		FRUIT2 = "딸기"; 
	}

	public static void main(String[] args) {
		final int AGE = 25; // final안쓰면 대문자로 써도 그냥 변수임
		// AGE = 30; --> final이기때문에 변경 불가로 에러뜸
		System.out.println("AGE = "+AGE);
		
		final int AGE2; // 초기값을 선언시에 안줘도 바로다음에 주면 ㄱㅊ(C언어에선 선언시 초기값 안주면 에러)
		AGE2 = 30;
		System.out.println("AGE2 = "+AGE2);
		
		FinalMain aa = new FinalMain();
		System.out.println("FRUIT = "+aa.FRUIT); // static아니라서 new생성해서 불러오기
		System.out.println("FRUIT2 = "+aa.FRUIT2);
		
		System.out.println("ANIMAL = "+FinalMain.ANIMAL); // static은 new생성 안해도됨
		System.out.println("ANIMAL2 = "+FinalMain.ANIMAL2);
	}

}
