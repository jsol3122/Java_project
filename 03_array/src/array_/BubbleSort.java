package array_;

public class BubbleSort {

	public static void main(String[] args) {
		int[] ar = {43, 30, 25, 78, 55};
		
		System.out.print("정렬 전 : ");
		for(int x : ar) {
			System.out.print(x+" ");			
		}
		System.out.println();
		
		int temp;
		for(int i=0; i<ar.length-1; i++) {
			for(int j=0; j<ar.length-1-i; j++) { // selection sort랑 다르게 ar.length-1-i인 것 유의
												 // selection이랑 다르게 j도 0부터 계속 다시 시작(마지막값부터 확정됨)
				if(ar[j]>ar[j+1]) { // >로 하면 오름차순 || <로 하면 내림차순 ---> 나머지 동일
					temp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] = temp;
				} //if
			} //for j
		} //for i
		
		System.out.print("정렬 후 : ");
		for(int x : ar) {
			System.out.print(x+" ");			
		}
		System.out.println();

	}

}
