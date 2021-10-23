package array_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseBall {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] com = new int[3];
		int[] user = new int[3];
		int i=0, countS, countB, count=0;
		
		for(i=0; i<com.length; i++) {
			com[i]=(int)(Math.random()*9)+1;
			for(int j=0; j<i;j++) {
				if(com[i]==com[j]) i--;
			}		
		} // 난수발생 + 중복잡기
		
		/*  <<게임실행하겠습니까 yn제외 나머지나올때>>
		do {
			System.out.print("게임을 실행하시겠습니까(Y/N) : ");
			int yn = System.in.read();
			System.in.read();
			System.in.read();
		} while(yn!='y' && yn!='Y' && yn!='n' && yn!='N');
			
		     <<게임 실행 y n>>  <<난수 발생 + 중복체크>>
		if(yn=='y' && yn=='Y'){
			System.out.println("/n 게임을 시작합니다");
			
			for(int i=0; i<com.length; i++){
				com[i]=(int)(Math.random()*9)+1;
				for(int j=0; j<i; j++){
					if(com[i]==com[j]{
					i--; break;
					}
				}
			}
			while(true)
		}
		System.out.println("프로그램을 종료합니다");
		 */
		
		AB:for(;;) {
		System.out.print("게임을 실행하시겠습니까(Y/N) : ");
		String yn = br.readLine();
			if(yn.equals("N") || yn.equals("n")) break;
			
			else if(yn.equals("Y") || yn.equals("y")) {
				
				while(true) {
				count++; countS=0; countB=0; 
				System.out.print("숫자입력 : ");
				for(i=0; i<user.length; i++) {
					user[i] = System.in.read()-48;
				}
				System.in.read();
				System.in.read();
				for(i=0; i<user.length; i++) {
					for(int j=0; j<user.length; j++) {
						if(com[j]==user[i]) {
							if(i==j) countS++;
							else countB++; }
					}
				} // 스트라이크 / 볼 확인
				if(countS==3) {System.out.println("축하합니다! "+count+"번만에 맞추셨습니다!");break AB;}
				else System.out.println(countS+"스트라이크 "+countB+"볼"); 
				System.out.println();
				}
			} // else if 게임실행 + user에 값넣음
		}
		System.out.println("게임을 종료합니다");
		
	} //main

}
