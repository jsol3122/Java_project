package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count;
		int num1, num2;
		String yn;
		
		while(true) {
			count = 0;
			int ans;
		
			for(int i=1; i<=5; i++) {
				num1=(int)(Math.random()*90)+10;
				num2=(int)(Math.random()*90)+10;
				
				for(int j=1 ; j<=2; j++) {
					System.out.print("[문제 "+i+"] "+num1+" + "+num2+" = ");
					ans = Integer.parseInt(br.readLine());
					
					if(ans==(num1+num2)) {System.out.print("딩동댕~~ 참 잘했어요!!\n"); 
											count++; break;}
					else {
						if (j==1) System.out.println("틀렸습니다..."); 
						else if (j==2) System.out.println("틀렸습니다...정답 : "+(num1+num2)); }
					} // 내부 for 
				} //for
			System.out.println();
			System.out.println("당신은 총 "+count+"문제를 맞추어서 "+(count*20)+"점 입니다");
			
			System.out.print("1번 더 (Y / N) ?");
			yn = br.readLine();
			
				if(yn.equals("N") || yn.equals("n") ) break;
		} //while
		System.out.println();
		System.out.println("프로그램이 종료되었습니다.");
	}
}