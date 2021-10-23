package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class ATMTest implements Runnable{
	private long depositeMoney=100000; // 잔액
	private long balance; // 찾고자 하는 금액 , 8byte
	
	public static void main(String[] args) {
		ATMTest at = new ATMTest(); // 하나의 클래스를 스레드 mom,son이 공유
		
		Thread mom = new Thread(at, "엄마"); // 스레드 생성 + 이름부여
		mom.start(); // 스레드 시작
		Thread son = new Thread(at, "아들");
		son.start();
		
		//mom.setName("엄마");
		//son.setName("아들");
	}

	@Override
	public synchronized void run() { // 동기화 처리 - 방법 1
		System.out.println(Thread.currentThread().getName()+"님 안녕하세요");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try { // Override된 구역이기 때문에 throws불가능
			System.out.print("찾고자 하는 금액 입력 : ");
			balance = Long.parseLong(br.readLine());
			
			if(balance/10000<1) { // balance%10000 != 0 으로 계산하는것도 가능
				System.out.println("만원 단위로 입력하세요");
			}else if(depositeMoney>=balance) {
				depositeMoney -= balance; // 이 경우에만 인출 가능이니까
				// 일회성 decimalformat이용법
				System.out.println("잔액은 "+new DecimalFormat().format(depositeMoney)+"원입니다");
			}else if(depositeMoney<balance) {
				System.out.println("잔액이 부족합니다");
			}
			System.out.println();
			
		} catch (IOException e) { // 이게 상위메소드라서 이것만 걸어도 됨
			e.printStackTrace();
		} 
	}
}
