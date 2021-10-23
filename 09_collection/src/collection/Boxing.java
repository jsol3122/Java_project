package collection;

public class Boxing {
	public static void main(String[] args) {
		int a = 25; // 기본형
		// double b = a; -- 같은형이 아니지만, 같은 기본형이고 double형이 더 크니까 가능
		double b = (double)a/3;  // (double)은 강제형변환 / 3->3.0은 자동형변환
		
		String c = "25";
		// int d = (int)c; -- 객체형을 기본형으로 형변환 불가능
		int d = Integer.parseInt(c); // 같은 객체형으로 형변환 캐스팅
		
		int e = 5;
		Integer f = e; // AutoBoxing(객체화) -- 같은 정수형이니까 허용
		// Integer f = new Integer(e); -- 예전엔 AutoBoxing안돼서 이렇게 해줬음
		
		Integer g = 5;
		int h = g; // UnAutoBoxing (=AutoUnboxing)
		// int h = g.intValue(); -- 예전엔 AutoUnboxing안돼서 이렇게 했음
	}

}
