package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest8 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int ans=1; true;) {

		System.out.print("x�� �Է� : ");
		int x = Integer.parseInt(br.readLine());
		if(x==0) {System.out.println("���α׷��� �����մϴ�."); break;}
		System.out.print("y�� �Է� : ");
		int y = Integer.parseInt(br.readLine());
		
			for(int i=1; i<=y ; i++) {
				
			ans=ans*x;
					
			} // for i
		System.out.println(x+"�� "+y+"���� "+ans);
		System.out.println();
		} // for true
	} //main

}
