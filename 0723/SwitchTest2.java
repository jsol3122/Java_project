import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class SwitchTest2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("a�� �Է� : ");
		int a = Integer.parseInt(br.readLine());
		System.out.print("b�� �Է� : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("������(+,-,*,/) : ");
		String op = br.readLine();
		//int op = br.read();  -->�̶� case'+'�� ��������ǥ
		//int op = System.in.read();


		switch(op){
			case "+" : System.out.print(a+"+"+b+" = "+(a+b)); break;
			case "-" : System.out.print(a+"-"+b+" = "+(a-b)); break;
			case "*" : System.out.print(a+"*"+b+" = "+(a*b)); break;
			case "/" : System.out.print(a+"/"+b+" = "+((double)a/b)); break;
			default : System.out.print("������ error");

		}

		
	}
}
