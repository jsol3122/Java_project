package array_;

public class SelectionSort {

	public static void main(String[] args) {
		int[] ar = {43, 30, 25, 78, 55};
		
		System.out.print("���� �� : ");
		for(int x : ar) {
			System.out.print(x+" ");			
		}
		System.out.println();
		
		int temp;
		for(int i=0; i<ar.length-1; i++) { 
			for(int j=i+1; j<ar.length; j++ ) { // ù��°������ ���������� Ȯ���Ǿ� �����ݺ����ʹ� ��ȯx
				if(ar[i]<ar[j]) { // >�� �ϸ� �������� || <�� �ϸ� �������� ---> ������ ����
					temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				} //if
			} //for j
		} //for i
		
		System.out.print("���� �� : ");
		for(int x : ar) {
			System.out.print(x+" ");			
		}
		System.out.println();

	}

}
