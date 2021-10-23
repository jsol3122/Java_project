package array_;

public class SelectionSort {

	public static void main(String[] args) {
		int[] ar = {43, 30, 25, 78, 55};
		
		System.out.print("정렬 전 : ");
		for(int x : ar) {
			System.out.print(x+" ");			
		}
		System.out.println();
		
		int temp;
		for(int i=0; i<ar.length-1; i++) { 
			for(int j=i+1; j<ar.length; j++ ) { // 첫번째값부터 순차적으로 확정되어 다음반복부터는 순환x
				if(ar[i]<ar[j]) { // >로 하면 오름차순 || <로 하면 내림차순 ---> 나머지 동일
					temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
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
