package array_;

import java.io.IOException;

public class Parking {

	public static void main(String[] args) throws IOException {
		int ans, i;
		boolean[] ar = new boolean[5]; //�迭�� �ʱⰪ�� ���ָ� �����Ⱚ���� 0�� ���� ---> boolean�迭�� False��
		
		while(true) {
			System.out.println("*****************");
			System.out.println("    1. ����");
			System.out.println("    2. ����");
			System.out.println("    3. ����Ʈ");
			System.out.println("    4. ����");
			System.out.println("*****************");
			
			System.out.print("�޴� : ");
			ans = System.in.read()-48;
			System.in.read();
			System.in.read();
			
			if(ans>4) System.out.println("1~4���� �Է��ϼ���.");
			if(ans==4) break;	
			
			if(ans==1) {
				System.out.print("��ġ �Է� : ");
				i = System.in.read()-48;
				System.in.read();
				System.in.read();
				
				if(ar[i-1]==false) {System.out.println(i+"��ġ�� ����"); ar[i-1]=true;}
				else System.out.println("�̹� �����Ǿ��ֽ��ϴ�");
			} // 1���޴� if
			if(ans==2) {
				System.out.print("��ġ �Է� : ");
				i = System.in.read()-48;
				System.in.read();
				System.in.read();
				
				if(ar[i-1]==true) {System.out.println(i+"��ġ�� ����"); ar[i-1]=false;}
				// if(ar[i-1]) �̷��Ը� �ᵵ �� "������ ���϶�"�� �ǹ��ϹǷ� ���ϰ��
				else System.out.println("�����Ǿ� ���� �ʽ��ϴ�");
			} // 2���޴� if
			if(ans==3) {
				for(i=0; i<ar.length; i++) {
				System.out.println((i+1)+"��ġ : "+ar[i]); 	
				} // 3���޴� for
			} // 3���޴� if
			System.out.println();
		} //while
		System.out.println("���α׷��� �����մϴ�.");
		
	} //main

}
