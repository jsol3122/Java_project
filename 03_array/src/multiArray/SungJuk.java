package multiArray;

public class SungJuk {

	public static void main(String[] args) {
		String [] name = {"홍길동", "라이언", "어피치"};
		int [][] jumsu = {{90, 96, 100, 0}, {100, 89, 75, 0}, {75, 80, 48, 0}};
		double [] avg = new double[3]; 
		char [] grade = new char[3];
		
		for(int i=0; i<jumsu.length; i++) {
			for(int j=0; j<jumsu[i].length-1; j++ ) {
				jumsu[i][3]+=jumsu[i][j];
			}
			avg[i]=jumsu[i][3]/3.;
			if(avg[i]>=90) grade[i]='A';
			else if(avg[i]>=80) grade[i]='B';
			else if(avg[i]>=70) grade[i]='C';
			else if(avg[i]>=60) grade[i]='D';
			else grade[i]='F';
		} // 입력

		System.out.println("----------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("----------------------------------------------------");
		
		for(int i=0; i<jumsu.length; i++ ) {
			System.out.print(name[i]+"\t");
			for(int j=0; j<jumsu[i].length; j++) {
				//System.out.print(String.format("%4d %.2f %4d", jumsu[i][j]), avg[i], grade[i]));
				System.out.print(String.format("%4d", jumsu[i][j])+"\t");
			}
			System.out.print(String.format("%.2f", avg[i])+"\t"+grade[i]);
			System.out.println();
		}
	}

}
