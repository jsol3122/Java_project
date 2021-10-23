package multiArray;

public class MultiArray {

	public static void main(String[] args) {
		int[][] ar = {{10, 20}, {30, 40}, {50, 60}}; //3행(3층) 2열 --> 고정길이
					// 3행짜리 배열이며 한 행당 2개로 나누어진 배열로 이루어져있는것
					// 2열짜리 배열 3개가 연속적으로 이어져있는 형태 ex) 2행의 0열 = ar[2][0]
	
		System.out.println("배열명 ar = "+ar);
		System.out.println();
		System.out.println("행 ar[0] = )"+ar[0]);
		System.out.println("행 ar[1] = )"+ar[1]);
		System.out.println("행 ar[2] = )"+ar[2]);
		System.out.println();
		
		for(int i = 0; i<ar.length; i++) {
			for(int j=0; j<ar[i].length; j++) { //-->행주소값이 있기때문에 저렇게도 가능
				System.out.println("ar["+i+"]["+j+"] = "+ar[i][j]);
			}
			System.out.println();
		} //for i
	}

}
