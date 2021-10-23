package abstract_;

//상속만 하면 안되고, 재구현(override)까지 해줘야함(강제성) / 자식이 재구현 안하면 손자클래스로 강제성 전달됨(연좌제)
public class AbstractMain extends AbstractTest{ 
	
	@Override
	public void setName(String name) { // Override(재구현)안하면 추상만 건 것은 의미 없음
		this.name=name;
	}

	public static void main(String[] args) {
		//AbstractTest at = new AbstractTest(); -> 추상클래스라서 new메모리생성 불가 => 상속으로 해결
		AbstractTest at = new AbstractMain(); // 자식껄로 new생성해서 부모+자식 같이 생성하기
		at.setName("홍길동");
		System.out.println(at.getName());

	}

}
