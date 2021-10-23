package collection;

public class PersonDTO implements Comparable<PersonDTO>{ // sort 기준을 나이로 설정 - 건드리지 말것
	private String name;
	private int age;

	public PersonDTO(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(PersonDTO dto) { // 누구를 기준으로 비교할건지 쓰는 곳
		// 오름차순
		// if(this.age < dto.age) return -1;
		// else if(this.age == dto.age) return 0;
		// else return 1;
		
		// 내림차순
		if(this.age > dto.age) return -1;
		else if(this.age == dto.age) return 0;
		else return 1;
	}
	
	@Override
	public String toString() {
		// return super.toString(); - 기본적으로 Object의 string형인 주소값 형태 출력
		return name+" / "+age; // 주소값 대신 override해서 이 값 출력시킴
	}

}
