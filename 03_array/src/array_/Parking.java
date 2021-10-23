package array_;

import java.io.IOException;

public class Parking {

	public static void main(String[] args) throws IOException {
		int ans, i;
		boolean[] ar = new boolean[5]; //배열은 초기값을 안주면 쓰레기값말고 0을 가짐 ---> boolean배열은 False값
		
		while(true) {
			System.out.println("*****************");
			System.out.println("    1. 입차");
			System.out.println("    2. 출차");
			System.out.println("    3. 리스트");
			System.out.println("    4. 종료");
			System.out.println("*****************");
			
			System.out.print("메뉴 : ");
			ans = System.in.read()-48;
			System.in.read();
			System.in.read();
			
			if(ans>4) System.out.println("1~4번만 입력하세요.");
			if(ans==4) break;	
			
			if(ans==1) {
				System.out.print("위치 입력 : ");
				i = System.in.read()-48;
				System.in.read();
				System.in.read();
				
				if(ar[i-1]==false) {System.out.println(i+"위치에 입차"); ar[i-1]=true;}
				else System.out.println("이미 주차되어있습니다");
			} // 1번메뉴 if
			if(ans==2) {
				System.out.print("위치 입력 : ");
				i = System.in.read()-48;
				System.in.read();
				System.in.read();
				
				if(ar[i-1]==true) {System.out.println(i+"위치에 출차"); ar[i-1]=false;}
				// if(ar[i-1]) 이렇게만 써도 저 "조건이 참일때"를 의미하므로 동일결과
				else System.out.println("주차되어 있지 않습니다");
			} // 2번메뉴 if
			if(ans==3) {
				for(i=0; i<ar.length; i++) {
				System.out.println((i+1)+"위치 : "+ar[i]); 	
				} // 3번메뉴 for
			} // 3번메뉴 if
			System.out.println();
		} //while
		System.out.println("프로그램을 종료합니다.");
		
	} //main

}
