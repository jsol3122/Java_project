import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class InputTest2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("정수 데이터 입력 : ");
		int a = Integer.parseInt(br.readLine());

		System.out.print("실수 데이터 입력 : ");
		double b = Double.parseDouble(br.readLine());

		System.out.print(a+" + "+b+" = "+(a+b));
	}
}
