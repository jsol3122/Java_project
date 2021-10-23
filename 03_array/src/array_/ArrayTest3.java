package array_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("배열 크기 입력 : ");
		int size = Integer.parseInt(br.readLine());
		int[] ar = new int[size];
		int sum=0; 						

		for(int i=0; i<ar.length; i++) { // 배열크기입력해서 설정하기전엔 방번호를 변수나 조건으로 못잡으니까 이렇게
			
			System.out.print("ar["+i+"] 입력 : ");
			ar[i] = Integer.parseInt(br.readLine());
			
			sum+=ar[i];			
		} //for
		
		int max=ar[0];  // 만약 최대값or최소값 초기값을 0으로 했는데 배열값들이 다 음수라면 초기값이 최대값이 되는 문제 발생
		int min=ar[0];	// SO, 초기값으로 데이터 중 하나(ar[0]이 무난)를 갖는 것이 적절
						// int max = min = ar[0]; 으로 해도 가능
		for(int i=0; i<ar.length ;i++) {
			if (max<ar[i]) max=ar[i]; 
			if (min>ar[i]) min=ar[i];
		} // for max min
				
		for(int a : ar) { //확장형 for문은 length안해도 알아서 체크해서 배열크기만큼 돈다	
			System.out.print(a+"  ");
		} //for a
		
		System.out.println();
		System.out.println("합 = "+sum);
		System.out.println("최대값 = "+max);
		System.out.println("최소값 = "+min);
	} //main

}
