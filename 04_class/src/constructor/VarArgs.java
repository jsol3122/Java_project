package constructor;

public class VarArgs {
	// Overload된 함수들 중 리턴값과 자료형 다 똑같은데 인수 개수만 다른경우 (자료형...)으로 할 수 있음 
	// 이 경우 자료형도 다 달라도 하나로 만들 때는 (Object...)로 가능
		
	public int sum(int...ar) { //내부적으론 배열로 처리
		int hab=0;
		for(int i=0; i<ar.length; i++) {
			hab += ar[i];
		}
		return hab;
	}
	/*
	public int sum(int a, int b) {
		return a+b;
	}
	public int sum(int a, int b, int c) {
		return a+b+c;
	}
	public int sum(int a, int b, int c, int d) {
		return a+b+c+d;
	}
	*/

	public static void main(String[] args) {
		VarArgs va = new VarArgs();
		
		System.out.println("합 = "+va.sum(10,20));
		System.out.println("합 = "+va.sum(10,20, 30));
		System.out.println("합 = "+va.sum(10,20, 30, 40));

	}
}
