package class_;

import java.util.Scanner;

public class StringBufferMain {
	Scanner scan = new Scanner(System.in);
	private int dan;
	
	public StringBufferMain() {	// 앞의 public은 생략가능하지만, 안쓰면 외부클래스에서는 접근 x
		System.out.print("원하는 단을 입력 : ");
		dan=scan.nextInt();	// 여기서는 생성자 자체에서 변수생성을 안햇으니까 this없어도 있는 변수 dan뿐이라 ㄱㅊ
		display();
	}
	
	public void display() {
		StringBuffer buffer = new StringBuffer(); //문자열 처리 - String과 달리 수정가능
			for(int i=1; i<10; i++) {
			// System.out.println(dan+" * "+i+" = "+(dan*i));
			buffer.append(dan);
			buffer.append("*");
			buffer.append(i);
			buffer.append("=");
			buffer.append(dan*i);
			System.out.println(buffer);
			buffer.delete(0, buffer.length()); // buffer append와 delete사용해서 구구단 찍기
		}
	}

	public static void main(String[] args) {
		StringBufferMain aa = new StringBufferMain(); //static이 없으니까 new로 생성해주기
		//생성자에 display(); 안넣어놓고 여기서 main.display();로 불러와도 됨
	} //main
}
