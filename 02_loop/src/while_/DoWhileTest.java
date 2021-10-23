package while_;

public class DoWhileTest {

	public static void main(String[] args) {
		
		int a = 0;
		do {
			a++;
			System.out.print(a+" ");
			
		} while(a<10);
		System.out.println();
		System.out.println();

		char b = 'A';
		int count=0;
		do {
			System.out.print(b+" ");
			b++; count++;
			if (count%7==0) System.out.println();
			
		}while(b<='Z');
		
	}
	
	
}
