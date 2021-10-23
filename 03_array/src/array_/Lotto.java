package array_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lotto { // for if 사용

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] lotto = new int[6];
		int i, k, money=0;
		
		System.out.print("돈 입력 : ");
		money = Integer.parseInt(br.readLine());
			
		for(k=1; k<=(money/1000); k++) {
	
			for(i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45)+1;
				for(int j=0; j<i;j++) {
				if(lotto[i]==lotto[j]) i--;
				} //for 중복잡기
			} //for - 난수출력
			
			int temp;
			for(i=0; i<lotto.length-1; i++) { 
				for(int j=i+1; j<lotto.length; j++ ) { // 첫번째값부터 순차적으로 확정되어 다음반복부터는 순환x
					if(lotto[i]>lotto[j]) { // >로 하면 오름차순 || <로 하면 내림차순 ---> 나머지 동일
						temp = lotto[i];
						lotto[i] = lotto[j];
						lotto[j] = temp;
					} //if
				} //for j
			} //for i - 오름차순  ---> c언어에서 정렬하는 법 // java에서는 따로 함수가있음
			
			/* java에서의 sort함수 이용한 정렬 - static이라서 선언x
			Arrays.sort(lotto);	---> Arrays는 java.util에 있음 // 내림차순은 reverse해주기
			 */
			
			for(i=0; i<lotto.length; i++) {
				System.out.print(lotto[i]+"\t");
			/* 확장for로 출력하기
			for(int data : lotto){
				System.out.print(String.format("%5d", data));
			*/
			} // for 결과물 출력	
			System.out.println();
			if(k%5==0) System.out.println();
		} // for 돈에 따라 반복	/ 5줄마다 끊기
		} // main
} 

