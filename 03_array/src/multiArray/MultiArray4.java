package multiArray;

public class MultiArray4 {

	public static void main(String[] args) {
		int[][] ar = new int[3][];   // 열 값은 가변적이니까 값 지정해서 고정시키지x
		ar[0] = new int[2];
		ar[1] = new int[3];
		ar[2] = new int[4];
		
		ar[0][0] = 10;
		ar[0][1] = 20;
		
		ar[1][0] = 30;
		ar[1][1] = 40;
		ar[1][2] = 50;
		
		ar[2][0] = 60;
		ar[2][1] = 70;
		ar[2][2] = 80;
		ar[2][3] = 90;
		
		for(int i = 0; i<ar.length; i++) {
			for(int j=0; j<ar[i].length; j++) { //-->행주소값이 있기때문에 저렇게도 가능
				System.out.println("ar["+i+"]["+j+"] = "+ar[i][j]);
			}
			System.out.println();
		} 
	}

}
