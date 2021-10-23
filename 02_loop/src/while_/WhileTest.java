package while_;

public class WhileTest {

	public static void main(String[] args) {
		
		int a=0;
		while(a<10) {
			a++;
			System.out.print(a+" ");
		}
		
		while(true) {
			a++;
			System.out.print(a+" ");
			if (a==10) break;
		}

	}

}
