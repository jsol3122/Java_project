package multiFor;

public class MultiFor3 {

	public static void main(String[] args) {
		
		int dan=2, i=1;
				
		for(i=1; i<=9; i++) {
			
			for(dan=2; dan<=9; ) {
				
				System.out.print(dan+"*"+i+"="+(dan*i)+"\t");
				dan++;
			} //for dan
			System.out.println();
		} //for i

	}

}
