package array_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseBall {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] com = new int[3];
		int[] user = new int[3];
		int i=0, countS, countB, count=0;
		
		for(i=0; i<com.length; i++) {
			com[i]=(int)(Math.random()*9)+1;
			for(int j=0; j<i;j++) {
				if(com[i]==com[j]) i--;
			}		
		} // �����߻� + �ߺ����
		
		/*  <<���ӽ����ϰڽ��ϱ� yn���� ���������ö�>>
		do {
			System.out.print("������ �����Ͻðڽ��ϱ�(Y/N) : ");
			int yn = System.in.read();
			System.in.read();
			System.in.read();
		} while(yn!='y' && yn!='Y' && yn!='n' && yn!='N');
			
		     <<���� ���� y n>>  <<���� �߻� + �ߺ�üũ>>
		if(yn=='y' && yn=='Y'){
			System.out.println("/n ������ �����մϴ�");
			
			for(int i=0; i<com.length; i++){
				com[i]=(int)(Math.random()*9)+1;
				for(int j=0; j<i; j++){
					if(com[i]==com[j]{
					i--; break;
					}
				}
			}
			while(true)
		}
		System.out.println("���α׷��� �����մϴ�");
		 */
		
		AB:for(;;) {
		System.out.print("������ �����Ͻðڽ��ϱ�(Y/N) : ");
		String yn = br.readLine();
			if(yn.equals("N") || yn.equals("n")) break;
			
			else if(yn.equals("Y") || yn.equals("y")) {
				
				while(true) {
				count++; countS=0; countB=0; 
				System.out.print("�����Է� : ");
				for(i=0; i<user.length; i++) {
					user[i] = System.in.read()-48;
				}
				System.in.read();
				System.in.read();
				for(i=0; i<user.length; i++) {
					for(int j=0; j<user.length; j++) {
						if(com[j]==user[i]) {
							if(i==j) countS++;
							else countB++; }
					}
				} // ��Ʈ����ũ / �� Ȯ��
				if(countS==3) {System.out.println("�����մϴ�! "+count+"������ ���߼̽��ϴ�!");break AB;}
				else System.out.println(countS+"��Ʈ����ũ "+countB+"��"); 
				System.out.println();
				}
			} // else if ���ӽ��� + user�� ������
		}
		System.out.println("������ �����մϴ�");
		
	} //main

}
