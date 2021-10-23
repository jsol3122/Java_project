package array_;

public class ArrayTest4 {

	public static void main(String[] args) {
		int[] ar = new int[100];
		int[] count = new int[26];
		int i, j;
		
		for(i=0; i<ar.length; i++) {
			ar[i] = (int)(Math.random()*26)+65;	
		} // for 난수입력

		for(i=0; i<ar.length; i++) {
			System.out.print((char)ar[i]+" ");
			if((i+1)%10==0) System.out.println();
			
			for(j=0; j<count.length; j++) { //count배열로 A~Z구역 새로 만들어서 이중for돌리기 
				if (ar[i]==j+'A') count[j]++; // 'A'를 i변수나 j변수 이용해서 설정해야 ++로 증가시켜 반복되니까
			} // for 카운트
			
		} // for 난수출력
		for(i=0; i<count.length; i++) { //A개수~Z개수 출력 반복할 for문 만들어 돌리기
			System.out.print((char)(i+'A')+"의 개수 = "+count[i]+"\t");
			if((i+1)%3==0) System.out.println();
		} // for 개수구하기
	}
}

