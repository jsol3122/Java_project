package for_;

import java.io.IOException;

public class ForTest2 {
	public static void main(String[] args) throws IOException {
		
		int dan=7, i;
				
		for(i=1; i<=9; i++) {
			System.out.println(dan+"*"+i+"="+(dan*i));
		}
		
		int a, b;
		System.out.print("원하는 단을 입력 : ");
		a = System.in.read()-48;
		System.in.read();
		System.in.read();
		
		for(b=1; b<=9; b++) {
			System.out.println(a+"*"+b+"="+(a*b));
		}
		
		
		
	}

}
