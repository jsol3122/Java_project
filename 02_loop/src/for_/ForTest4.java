package for_;

public class ForTest4 {

	public static void main(String[] args) {
		int i, sum=0, mul=1;
		
		for(i=1; i<=10; i++) {
			sum=sum+i;    // sum += i;
			mul=mul*i;
			System.out.println(i+"\t"+sum+"\t"+mul);
					
		}

	}

}
