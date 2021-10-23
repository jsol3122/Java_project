import java.io.IOException;
class InputTest {
	public static void main(String[] args) throws IOException	{
		System.out.print("데이터 : ");
		int a=System.in.read();
		System.in.read();
		System.in.read();

		System.out.print("데이터 : ");
		int b=System.in.read();
		System.in.read();
		System.in.read();
		System.out.println("결과 = "+a+", "+b);
	}
}
