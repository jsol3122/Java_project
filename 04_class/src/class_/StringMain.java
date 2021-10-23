package class_;

public class StringMain {

	public static void main(String[] args) {
		String a = "apple";
		String b = "apple";
		
		if(a==b) System.out.println("a와 b의 참조값은 같다");
		else System.out.println("a와 b의 참조값은 다르다");
		
		if(a.equals(b)) System.out.println("a와 b의 문자열은 같다");
		else System.out.println("a와 b의 문자열은 다르다");
		System.out.println();
		
		String c = new String("apple");
		String d = new String("apple");
		if(c==d) System.out.println("c와 d의 참조값은 같다");
		else System.out.println("c와 d의 참조값은 다르다");
		
		if(c.equals(d)) System.out.println("c와 d의 문자열은 같다");
		else System.out.println("c와 d의 문자열은 다르다");
		System.out.println();
		
		String e = "오늘 날짜는 "+1991+7+16; 
		System.out.println("e = "+e);
		System.out.println("문자열 크기 = "+e.length());  // 14개
		
		System.out.println("첫번째 문자 = "+e.charAt(0));
		System.out.println("두번째 문자 = "+e.charAt(1));
		System.out.println("마지막 문자 = "+e.charAt(13));
		
		System.out.println("부분 문자열 추출 = "+e.substring(7));
		System.out.println("부분 문자열 추출 = "+e.substring(7, 11));  // 1991뽑기 - 7번위치부터 11번 "이전"까지 뽑아옴
		
		System.out.println("대문자 변경 = "+"Hello".toUpperCase());		// 대소문자 섞여있어도 싹다 대문자/소문자로 정렬
		System.out.println("소문자 변경 = "+"Hello".toLowerCase());
		
		System.out.println("문자열 검색 = "+e.indexOf("짜"));	//4
		System.out.println("문자열 검색 = "+e.indexOf("날짜"));	//3
		System.out.println("문자열 검색 = "+e.indexOf("개바부"));	//-1은 찾는 글자가 없다는 뜻
		System.out.println("문자열 검색 = "+e.indexOf("1"));	// 찾는 문자열이 여러개라면 맨 앞에 것을 출력 = 0번문자부터 검색함
		System.out.println("문자열 검색 = "+e.indexOf("1", 8));	// 8번째 문자열부터 "1"을 찾으라고 조건 걸음(맨 앞부터 검색x)
		
		System.out.println("문자열 치환 = "+e.replace("날짜", "일자"));
		/* 이렇게 하면 "오늘 날짜는 " / "오늘 날짜는 1991" / "오늘 날짜는 19917" / "오늘 날짜는 1991716" 메모리 4개가 잡힘 - 수정이 안되니까 
		JVM에 삭제시 Garbage Collector(휴지통)으로 보냄 - 바로 삭제x
		Garbage Collector가 실행되면 컴퓨터가 잠깐 멈춤 - 휴지통비우기하는것
		 */
	}

}





