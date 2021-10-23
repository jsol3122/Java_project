package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain {

	public static void main(String[] args) {
		// System.out.println("args[0] = "+args[0]);
		// 개발자가 데이터를 입력하지 않아서 발생한 실행 Exception이기 때문에 try/throws사용x
		// 값만 넣어주면 해결 가능
		
		// ArrayIndexOutOfBoundsException 
		if(args.length >= 1) System.out.println("args[0] = "+args[0]);
		// 이 경우 값을 넣지 않아도 if로 (비즈니스로직 이용) 오류 막아줬기 때문에 Exception뜨지x
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// bufferedreader생성만 해서는 에러 발생 x
		
		int a, b;
		
		try { // 에러발생 가능구역
			System.out.print("정수 입력 : ");
			a = Integer.parseInt(br.readLine());
			
			System.out.print("정수 입력 : ");
			b = Integer.parseInt(br.readLine());
			System.out.println(a+" / "+b+" = "+a/b);
		} catch(IOException e) { // 에러발생 시 수행 구역
			e.printStackTrace(); // 발생한 에러의 종류 및 원인 출력
		} catch(NumberFormatException e) { // 문자열이 입력된경우의 예외처리 - 구체적 예외처리설정
			System.out.println("숫자 형태만 입력하세요");
			e.printStackTrace(); 
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다");
			e.printStackTrace();
		} finally {
			System.out.println("error가 있건 없건 무조건 실행하소");
		}
		
	} 

}
