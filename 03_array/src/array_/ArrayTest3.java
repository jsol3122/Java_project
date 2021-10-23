package array_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�迭 ũ�� �Է� : ");
		int size = Integer.parseInt(br.readLine());
		int[] ar = new int[size];
		int sum=0; 						

		for(int i=0; i<ar.length; i++) { // �迭ũ���Է��ؼ� �����ϱ����� ���ȣ�� ������ �������� �������ϱ� �̷���
			
			System.out.print("ar["+i+"] �Է� : ");
			ar[i] = Integer.parseInt(br.readLine());
			
			sum+=ar[i];			
		} //for
		
		int max=ar[0];  // ���� �ִ밪or�ּҰ� �ʱⰪ�� 0���� �ߴµ� �迭������ �� ������� �ʱⰪ�� �ִ밪�� �Ǵ� ���� �߻�
		int min=ar[0];	// SO, �ʱⰪ���� ������ �� �ϳ�(ar[0]�� ����)�� ���� ���� ����
						// int max = min = ar[0]; ���� �ص� ����
		for(int i=0; i<ar.length ;i++) {
			if (max<ar[i]) max=ar[i]; 
			if (min>ar[i]) min=ar[i];
		} // for max min
				
		for(int a : ar) { //Ȯ���� for���� length���ص� �˾Ƽ� üũ�ؼ� �迭ũ�⸸ŭ ����	
			System.out.print(a+"  ");
		} //for a
		
		System.out.println();
		System.out.println("�� = "+sum);
		System.out.println("�ִ밪 = "+max);
		System.out.println("�ּҰ� = "+min);
	} //main

}
