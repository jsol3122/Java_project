package nested;

// POJO형식 - 클래스의 오리지널형태 [ Plain Old Java Object ]
public abstract class AbstractTest {
	String name; // default니까 같패키지 다접근o

	public String getName() {
		return name;
	}

	// interface는 어차피 추상뿐이라서 abstract 굳이 안써도 됨
	public abstract void setName(String name);
}
