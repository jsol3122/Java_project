package for_;

public class ForTest {

	public static void main(String[] args) {
		int i;
		for (i=1; i<=10; i++) {
			System.out.println("�ȳ��ϼ���");
			
		}

		System.out.println("Ż�� i = "+ i);
		System.out.println();
		
		
		for(i=10; i>=1; i--) {
			System.out.print(i+" ");
		}	
		System.out.println();
		
		for(i='A'; i<='Z'; i++) {
			System.out.print((char)i+" ");
		}
		System.out.println();
	}

}
