package multiFor;

public class MultiFor {

	public static void main(String[] args) {
		int i, j;
		
		for(i=2; i<=4; i+=2) {
			
			for(j=1; j<=3; j++) {
				System.out.println("i="+i+"    j="+j);
			} //for j
			System.out.println();
		} //for i
		

	}

}
