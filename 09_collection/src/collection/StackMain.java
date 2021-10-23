package collection;

import java.util.Stack;
import static java.lang.System.out; // 이렇게 static선언하면 사용 시 생략가능

public class StackMain { // stack은 들어간것과 반대순서로 출력 (마지막입력부터 출력 LIFO) - 한개씩 입출력
						 // stack으로 함수를 주로 관리함

	public static void main(String[] args) {
		String[] groupA = {"우즈베키스탄", "쿠웨이트", "사우디", "대한민국"};
		Stack<String> stack = new Stack<String>();
		
		for(int i=0; i<groupA.length; i++) { // stack에 입력 - push
			stack.push(groupA[i]);
		}

		while( ! stack.isEmpty()) { // stack에서 출력 - pop
			out.println(stack.pop());
		}
	}

}
