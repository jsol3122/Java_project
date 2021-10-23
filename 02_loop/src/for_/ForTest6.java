package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("숫자 입력 : ");
		int a = Integer.parseInt(br.readLine());
		int count=0;
		
		for(int i=1; i<=a; i++) {
			if(a%i==0) {System.out.print(i+" "); count++;}
			}
		System.out.println();
		if(count>3) System.out.print(a+"는 소수가 아니다.");
		else System.out.print(a+"는 소수이다.");
	}

}
