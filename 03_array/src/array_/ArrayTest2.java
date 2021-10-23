package array_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i;
		
		 //for   --->이렇게 하고 run configurations - arguments에서 값입력하면 출력됨
		for(i=0; i<args.length; i++) {
		System.out.println("args["+i+"] = "+args[i]);
		System.out.println("args["+i+"] 문자열 크기 = "+args[i].length());
		System.out.println("args["+i+"] 첫번째 문자 = "+args[i].charAt(0));
		System.out.println();
		}
		System.out.println();
		
		System.out.println("확장 for");
		for(String data : args) {
		System.out.println(data);
		System.out.println("문자열 크기 = "+data.length());
		System.out.println("첫번째 문자 = "+data.charAt(0));
		System.out.println();
		}
		
		/*
		for(String input : args) {
		System.out.println("문자열 입력 : ");
		input = br.readLine();
		System.out.println("가운데 문자 = "+input.charAt(input.length()/2));
		}
		*/
		
		System.out.print("문자열 입력 : ");
		String str = br.readLine();
		
		int index = str.length() / 2;
		System.out.println("가운데 문자 = "+str.charAt(index));
		
	}

}
