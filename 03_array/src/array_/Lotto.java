package array_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lotto { // for if ���

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] lotto = new int[6];
		int i, k, money=0;
		
		System.out.print("�� �Է� : ");
		money = Integer.parseInt(br.readLine());
			
		for(k=1; k<=(money/1000); k++) {
	
			for(i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45)+1;
				for(int j=0; j<i;j++) {
				if(lotto[i]==lotto[j]) i--;
				} //for �ߺ����
			} //for - �������
			
			int temp;
			for(i=0; i<lotto.length-1; i++) { 
				for(int j=i+1; j<lotto.length; j++ ) { // ù��°������ ���������� Ȯ���Ǿ� �����ݺ����ʹ� ��ȯx
					if(lotto[i]>lotto[j]) { // >�� �ϸ� �������� || <�� �ϸ� �������� ---> ������ ����
						temp = lotto[i];
						lotto[i] = lotto[j];
						lotto[j] = temp;
					} //if
				} //for j
			} //for i - ��������  ---> c���� �����ϴ� �� // java������ ���� �Լ�������
			
			/* java������ sort�Լ� �̿��� ���� - static�̶� ����x
			Arrays.sort(lotto);	---> Arrays�� java.util�� ���� // ���������� reverse���ֱ�
			 */
			
			for(i=0; i<lotto.length; i++) {
				System.out.print(lotto[i]+"\t");
			/* Ȯ��for�� ����ϱ�
			for(int data : lotto){
				System.out.print(String.format("%5d", data));
			*/
			} // for ����� ���	
			System.out.println();
			if(k%5==0) System.out.println();
		} // for ���� ���� �ݺ�	/ 5�ٸ��� ����
		} // main
} 

