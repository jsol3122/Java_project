package abstract_;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberMain {

	public static void main(String[] args) {
		// NumberFormat은 import해봤자 추상이라 new생성 시도하면 에러뜸
		// NumberFormat의 자식클래스로는 DecimalFormat 이 있으니 얘 이용해보자
		// DecimalFormat의 기본설정은 3자리마다 컴마 찍고 소수점 3째자리까지 출력
		NumberFormat nf = new DecimalFormat(); 
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		NumberFormat nf2 = new DecimalFormat("#,###.##원"); // 오라클에선 #대신9로 표현
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();
		
		NumberFormat nf3 = new DecimalFormat("#,###.00원"); // 강제로 0표시
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		//추상클래스를 메소드를 이용하여 생성
		//NumberFormat nf4 = NumberFormat.getInstance(); // new아니어도 메소드 생성 가능 - static함수임
		NumberFormat nf4 = NumberFormat.getCurrencyInstance(); // 현지 통화기호 표시
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		NumberFormat nf5 = NumberFormat.getInstance();
		nf5.setMaximumFractionDigits(2); // 소수점 2째자리까지 출력
		nf5.setMinimumFractionDigits(2); // 강제로 2째자리까지 0 표시 - 값 없어도
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();
		
		//NumberFormat nf6 = NumberFormat.getInstance(Locale.US);
		NumberFormat nf6 = NumberFormat.getCurrencyInstance(Locale.US); //나라별 통화표시
		nf6.setMaximumFractionDigits(2); // 소수점 2째자리까지 출력
		nf6.setMinimumFractionDigits(2); // 강제로 2째자리까지 0 표시 - 값 없어도
		System.out.println(nf6.format(12345678.456789));
		System.out.println(nf6.format(12345678));
		System.out.println();	
	}
}
