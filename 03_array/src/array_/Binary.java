package array_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary { // while for 사용

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dec, i; //10진수 입력받기 / 4byte라서 32bit 나오니까 비트당 배열잡기
		int[] binary = new int[32];
		
		while(true) {			
		System.out.print("10진수 입력 : ");
		dec = Integer.parseInt(br.readLine());
			if(dec==0) break;
			else if(dec<0) {
				System.out.print("10진수 입력 : ");
				dec = Integer.parseInt(br.readLine());
			/* else if로 음수일때 반복 대신 
			 * if(dec<0) continue; 이렇게 하면 다시 while(true)시작으로 돌아가니까 동일결과임	
			 */
			
			} // else if
			else {
				for(i=0; dec>0 ; i++) {
					binary[i]=dec%2; 
					dec/=2;	 
					if(dec==0)break;
				} // for
				
				for(; i>=0; i--) {
					System.out.print(binary[i]);
					if(i%4==0)System.out.print(" ");
				}
				System.out.println();
			} // else
		} // while
		
		System.out.println("프로그램을 종료합니다");
	} //main

}
