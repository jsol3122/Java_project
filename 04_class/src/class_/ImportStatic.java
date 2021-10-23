package class_;

import static java.lang.Math.random; 
import static java.lang.Math.pow; // 같은 static.Math안에 있어도 함수마다 import 해야 인식
//import static java.lang.Math.*;  // 이렇게 와일드카드(*) 걸면 java.lang.Math안의 모든함수 import거는것
import static java.lang.System.out; // 이렇게 import걸어놓으면 System.out.print에서 System 생략가능

import java.util.Random; // static 함수만 import static이 가능

public class ImportStatic {

	public static void main(String[] args) {
		out.println("난수 = "+random()); // 0<=난수<1  --> 1은 절대 안나옴
		// 이런식으로 Math.random()이렇게 안쓰고 위에 import걸어서 random()만 쓸 수 있음
		// 이렇게하면 import때문에 저 random()함수는 main메소드가 아니라 static영역에 들어감 [static으로만 가능]
		
		Random r = new Random();
		out.println("난수 = "+r.nextDouble()); // 난수. static이 아니라서 import static못씀
		out.println("정수형 난수 = "+r.nextInt()); // 21억 ~ -21억 사이 난수
		out.println("정수형 난수 = "+r.nextInt(100)); // 0~99 사이 난수
		out.println("정수형 난수 = "+(r.nextInt(100)+1)); // 1~100 사이 난수 / 괄호필수
		
		out.println("2의 5승 = "+pow(2, 5)); // Math.pow는 실수형값으로 가져옴 
	}

}
