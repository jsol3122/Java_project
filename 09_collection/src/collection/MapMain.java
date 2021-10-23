package collection;

import java.util.HashMap;
import java.util.Map;

public class MapMain {

	public static void main(String[] args) { // map은 add대신 put으로 값 넣음
		Map<String, String> map = new HashMap<String, String>(); // 인터페이스임, <key, value> 임
		
		map.put("book101", "백설공주");
		map.put("book201", "인어공주");
		map.put("book102", "백설공주"); // value 중복 허용
		map.put("book301", "피오나");
		map.put("book101", "엄지공주"); // key 중복 허용 -- 대신 앞서 설정된 값은 사라지고 새 value값이 덧씌워짐
		
		System.out.println(map.get("book102"));	// key값을 주면 해당하는 value 출력
		System.out.println(map.get("book103")); // 해당값이 없다면 에러x null값 출력
		System.out.println(map.get("book101")); // key값 중복 시 마지막 value값으로 대체 (이전 값 소멸)
		
		//iterator를 쓰면 value가 아닌 key값을 출력하기 때문에 잘 안씀
	}

}
