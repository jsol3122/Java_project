package array_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary { // while for ���

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dec, i; //10���� �Է¹ޱ� / 4byte�� 32bit �����ϱ� ��Ʈ�� �迭���
		int[] binary = new int[32];
		
		while(true) {			
		System.out.print("10���� �Է� : ");
		dec = Integer.parseInt(br.readLine());
			if(dec==0) break;
			else if(dec<0) {
				System.out.print("10���� �Է� : ");
				dec = Integer.parseInt(br.readLine());
			/* else if�� �����϶� �ݺ� ��� 
			 * if(dec<0) continue; �̷��� �ϸ� �ٽ� while(true)�������� ���ư��ϱ� ���ϰ����	
			 */
			
			} // else if
			else {
				for(i=0; dec>0 ; i++) {
					binary[i]=dec%2; 
					dec/=2;	 
					if(dec==0)break;
				} // for
				
				for(; i>=0; i--) {
					System.out.print(binary[i]);
					if(i%4==0)System.out.print(" ");
				}
				System.out.println();
			} // else
		} // while
		
		System.out.println("���α׷��� �����մϴ�");
	} //main

}
