package while_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhileTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count;
		System.out.println();
		while(true) {
			count=1;
			int num=(int)(Math.random()*100)+1;
			System.out.println("숫자를 발생했습니다....."+num);
			
			while(true) {
				
				System.out.print("숫자 입력 : ");
				int i = Integer.parseInt(br.readLine());
				
				if(num>i) {System.out.println(i+"보다 큽니다."); count++;}
				else if (num<i) {System.out.println(i+"보다 작습니다."); count++;}
				else if (num==i) break;
				} //내부 while
			System.out.println("딩동댕~~~ "+count+"번만에 맞추셨습니다.");
			
			int yn;
			while(true) {
				System.out.print("1번 더 (Y/N) ? ");
				yn = br.read();
				br.read();
				br.read();
			
			if(yn=='y' || yn=='Y' || yn=='n' || yn=='N') break;
				} //내부 while 2
			
			if(yn=='n' || yn=='N') break;
		} //외부 while
		System.out.println("프로그램을 종료합니다.");

	}

}
