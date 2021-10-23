package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionMain2 {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>(); // 추상클래스 아니므로 new가능
		// ArrayList참조해서 new하면 get()쓸 수 있음 - iterator 안써도 됨

		list.add("호랑이");
		list.add("사자");
		list.add("호랑이"); // 중복허용, 순서
		//list.add(25);
		//list.add(43.8);
		list.add("기린");
		list.add("코끼리");
		
		Iterator it = list.iterator(); // collection안에 지정자 인터페이스 생성
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		// iterator는 자체 출력함수가 없는경우 많이 사용 + 삭제 시에는 필수
		
		System.out.println("-------------------------------");
		
		for(int i=0; i<list.size(); i++) { // list로 바로 생성했다면 iterator 안쓰고 get으로 출력가능
			System.out.println(list.get(i));
		}
		
		System.out.println("-------------------------------");
		
		for(String data : list) { // 확장for문으로 출력해도 됨 - 가장 많이사용
			System.out.println(data);
		}
		
	}

}
