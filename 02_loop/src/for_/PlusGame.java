package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count;
		int num1, num2;
		String yn;
		
		while(true) {
			count = 0;
			int ans;
		
			for(int i=1; i<=5; i++) {
				num1=(int)(Math.random()*90)+10;
				num2=(int)(Math.random()*90)+10;
				
				for(int j=1 ; j<=2; j++) {
					System.out.print("[���� "+i+"] "+num1+" + "+num2+" = ");
					ans = Integer.parseInt(br.readLine());
					
					if(ans==(num1+num2)) {System.out.print("������~~ �� ���߾��!!\n"); 
											count++; break;}
					else {
						if (j==1) System.out.println("Ʋ�Ƚ��ϴ�..."); 
						else if (j==2) System.out.println("Ʋ�Ƚ��ϴ�...���� : "+(num1+num2)); }
					} // ���� for 
				} //for
			System.out.println();
			System.out.println("����� �� "+count+"������ ���߾ "+(count*20)+"�� �Դϴ�");
			
			System.out.print("1�� �� (Y / N) ?");
			yn = br.readLine();
			
				if(yn.equals("N") || yn.equals("n") ) break;
		} //while
		System.out.println();
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}
}