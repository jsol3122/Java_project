package abstract_;

// POJO형식 (Plain Old Java Object 형식의 약자)
// 특별히 다른거에 상속받지 않고 기본Object상속만 기본으로 설정돼있고, private으로 필드잡고 set/get있는 단순클래스
public abstract class AbstractTest { // 추상을 가진 클래스라는 뜻
	String name; // private같은 거 아예 안쓰면 default임

	public String getName() {
		return name;
	}

	//추상메소드 - 추상을 걸었으나 현실적으로는 없고 만들어질거라고 선언(구현=override필수)
	public abstract void setName(String name); 
	
} //class
	

