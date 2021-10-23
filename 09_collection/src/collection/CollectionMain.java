package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain {

	public static void main(String[] args) {
		Collection coll = new ArrayList(); // 대신 implement해주는 클래스
		// collection이 부모클래스로서 상속한것처럼 작동함
		// coll.get(인덱스번호); 로 값을 가져올 수 있으나, get()메소드가 ArrayList에 있고 Collection(부모)를 참조중이라 쓸 수 없음
		
		coll.add("호랑이");
		coll.add("사자");
		coll.add("호랑이"); // 중복허용, 순서
		coll.add(25);
		coll.add(43.8);
		coll.add("기린");
		coll.add("코끼리");
		
		Iterator it = coll.iterator(); // collection안에 지정자 인터페이스 생성
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
