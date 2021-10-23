package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain2 {
	private int dan;
	
	public void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("원하는 단을 입력 : ");
		try { // 컴파일 Exception
			dan = Integer.parseInt(br.readLine());
		} catch (IOException e) { 
			// NumberFormatException 등 여러 예외처리함수의 부모가 IOException이라서 모든 예외 다 포함
			// 따로 다른 예외처리 안잡아도 상관없음 / 구체적 예외상황에 대한 처리를 설정할 때만 따로 설정해줌
			// Exception의 부모는 Throwable / 대부분 Exception설정
			e.printStackTrace();
		}	
		output(dan);
	}
	
	public void output(int dan) {
		if(dan>=2 && dan<=9) { 
			for(int i=1; i<10 ; i++) System.out.println(dan+" * "+i+" = "+dan*i);
		}
		// 비즈니스 로직으로 예외처리 방법 - 실행 Exception
		// else System.out.println("2~9 사이의 숫자만 입력하시오");
		
		else {
			try{
				// 강제로 Exception 발생시키는 방법 - 발생된 error 잡아주는 작업도 병행해야 함
				// throw new Exception("2~9 사이의 숫자만 입력하시오");
				
				// 개발자가 만든 Exception클래스 이용하여 예외 처리 방법
				throw new MakeException("2~9 사이의 숫자만 입력하시오");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new ExceptionMain2().input();
	}

}
