package while_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhileTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count;
		System.out.println();
		while(true) {
			count=1;
			int num=(int)(Math.random()*100)+1;
			System.out.println("���ڸ� �߻��߽��ϴ�....."+num);
			
			while(true) {
				
				System.out.print("���� �Է� : ");
				int i = Integer.parseInt(br.readLine());
				
				if(num>i) {System.out.println(i+"���� Ů�ϴ�."); count++;}
				else if (num<i) {System.out.println(i+"���� �۽��ϴ�."); count++;}
				else if (num==i) break;
				} //���� while
			System.out.println("������~~~ "+count+"������ ���߼̽��ϴ�.");
			
			int yn;
			while(true) {
				System.out.print("1�� �� (Y/N) ? ");
				yn = br.read();
				br.read();
				br.read();
			
			if(yn=='y' || yn=='Y' || yn=='n' || yn=='N') break;
				} //���� while 2
			
			if(yn=='n' || yn=='N') break;
		} //�ܺ� while
		System.out.println("���α׷��� �����մϴ�.");

	}

}
