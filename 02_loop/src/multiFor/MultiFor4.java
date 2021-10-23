package multiFor;

public class MultiFor4 {

	public static void main(String[] args) {
		int dan, i;
		
		for(i=1; i<=9; i++) {
			
			for(dan=2; dan<=9; dan++) {
				
				System.out.print(dan+"*"+i+"="+(dan*i)+"\t");
				
				if(dan%3==1) System.out.println("\n");
			} // for dan
			System.out.println("\n");
			
		} // for i

	} // 3중 for는 도저히 모르겠읍니다..ㅜ

}
