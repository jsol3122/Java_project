package multiArray;


public class MultiArray2 {

	public static void main(String[] args)  {
		
		int[][] ar = new int[10][10];
		int num=0;
		
		/*
		for(int i=0; i<ar.length; i++ ) {
		
			for(int j=0; j<ar[i].length; j++) {
				num++;
				ar[i][j] = num;
			}
		} //입력
		*/ 
		
		//입력방법은 0행다찍고 1행다찍고 ~~~ 이렇게말고 0열다찍고 1열다찍고 ~~~ 이렇게도 가능
		/*
		for(int i=0; i<ar.length; i++) {
			for(int j=0; j<ar.length; j++) {
				num++;
				ar[j][i] = num;
			}	
		}
		*/
		
		for(int i=ar.length-1; i>=0; i-- ) {
			for(int j=ar[i].length-1; j>=0; j--) {
				num++;
				ar[i][j] = num;
			}
		}
		
		for(int i=0; i<ar.length; i++ ) {
			for(int j=0; j<ar[i].length; j++) {
				System.out.print(String.format("%4d", ar[i][j]));
			}
			System.out.println();
		} //출력 
	}

}
