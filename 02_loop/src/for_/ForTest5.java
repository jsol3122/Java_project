package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a;
		int count=0;
		
		System.out.print("시작값 입력 : ");
		int first = Integer.parseInt(br.readLine());
			
		int sum=0;
		System.out.print("끝값 입력 : ");
		int last = Integer.parseInt(br.readLine());
		
		for(a=first; a<=last; a++) {
			sum=sum+a;
			System.out.print(a+" ");
			count++;
			if(count%5==0)System.out.println();
			}
		System.out.println();
		System.out.print(first+" ~ "+last+"까지의 합 = "+sum);
			
	}

}
