package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMain {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>(); // 일정한 규칙 없이 무작위로 출력(순서x)
		
		set.add("호랑이");
		set.add("사자");
		set.add("호랑이"); // 중복허용x(한번만 출력), 순서x
		set.add("기린");
		set.add("코끼리");
		
		Iterator<String> it = set.iterator(); // 생성
		
		for(String data : set) { // 자체 출력함수 x
			System.out.println(data);
		}

	}

}
