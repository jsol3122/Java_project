package class_;

import java.util.StringTokenizer;

public class Token {

	public static void main(String[] args) {
		String str = "학원,집,,게임방";
		
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println("토큰 개수 = "+ st.countTokens()); //3개 --> 학원 / 집 / 게임방
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println("----------------");
		
		String[] ar = str.split(",");
		for(String data : ar) {
			System.out.println(data);
		}
		
	}

}
