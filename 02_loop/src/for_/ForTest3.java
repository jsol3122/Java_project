package for_;

public class ForTest3 {
	public static void main(String[] args) {
		int rand;
		int count=0;		
		
		for(int i=1; i<=100; i++) {
			rand=(int)(Math.random()*26)+65;
			System.out.print((char)rand+" ");
			
			if(i%10==0) System.out.println();
			if(rand=='A') count++;
			}
		System.out.println();
		System.out.println("ÃÑ AÀÇ °³¼ö = "+count);
		}
}
