package collection;

import java.util.ArrayList;

public class PersonMain {
	
	public ArrayList<PersonDTO> init() { // 안의 generic까지 자료형에 포함임 - 구현부
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("라이언", 30);
		PersonDTO cc = new PersonDTO("어피치", 28);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		return list; // 주소값을 list에 담아놓은 것
		// python은 return값 여러개 가능 - java는 1개밖에 못보내니까 collection으로 묶어주기
	} // init()

	public static void main(String[] args) {
		PersonMain pm = new PersonMain(); // static아니니까 생성
		ArrayList<PersonDTO> list = pm.init(); 
		// return값 받고 돌아옴 
		// 받아온 list의 주소값 보관 필요(다시 새 list에 보관 - init의 list와 별개임)
		System.out.println("list = "+list); //  주소값을 받은 것이므로 주소값출력
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("이름 = "+list.get(i).getName()+
								"\t나이 = "+list.get(i).getAge()); 
			// getter이용해서 안의 값 가져와서 출력 가능
		}
		System.out.println();
		
		for(PersonDTO dto : list) { // 확장for문 이용출력 - 더 편함
			System.out.println("이름 = "+dto.getName()+"\t나이 = "+dto.getAge());
		}
		System.out.println();
		
	}

}
