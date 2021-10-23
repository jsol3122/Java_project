package basic;

import java.io.IOException;

public class MemberMain { // 오직 실행만 함, 다른 클래스 new설정해서 실행만하기

	public static void main(String[] args) throws IOException {  //menu()함수의 호출부
		MemberService service = new MemberService();
		service.menu();
		System.out.println("프로그램을 종료합니다.");
	}
}

