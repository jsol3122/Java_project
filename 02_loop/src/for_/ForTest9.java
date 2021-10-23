package for_;

import java.io.IOException;

public class ForTest9 {

	public static void main(String[] args) throws IOException {

		System.out.print("x°ª ÀÔ·Â : ");
		int x = System.in.read()-48;
		System.in.read();
		System.in.read();
		
		System.out.println();
		System.out.print(x+"! = ");
		
		int ans=1;
		for(int i=1; i<=x; i++) {
			ans*=i;
				if(i==x) {System.out.print(i); break;}
			System.out.print(i+"*");
			
			} //for ans
	
		System.out.println(" = "+ans);

	} //main

}
