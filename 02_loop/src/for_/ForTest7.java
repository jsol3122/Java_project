package for_;

public class ForTest7 {

	public static void main(String[] args) {
		int i, sum=0;
		for(i=1; i<=10; i++) {
			
			if(i%2>0) {System.out.print("-"+i); sum-=i;}
			else {System.out.print("+"+i); sum+=i;}
		}
		System.out.print(" = "+sum);
		
	}

}
