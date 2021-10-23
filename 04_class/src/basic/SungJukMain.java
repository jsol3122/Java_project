package basic;

public class SungJukMain {

	public static void main(String[] args) {
		SungJuk[] ar = new SungJuk[3];
		System.out.println("----------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("----------------------------------------------------");
				
		for(int i=0; i<ar.length; i++) {
			ar[i] = new SungJuk();
		}
		
		ar[0].setData("홍길동", 90, 96, 100);	// 호출부 (직접 데이터 넣기)
		ar[1].setData("라이언", 100, 89, 75);
		ar[2].setData("어피치", 75, 80, 48);
		
		for(int i=0; i<ar.length; i++) {
		ar[i].calcAvg();
		ar[i].calcGrade();
		ar[i].calcTot();
		/* 확장형 for문 이용 - 클래스형배열의 값들이니까 클래스타입(SungJuk)으로 타입잡기
		
		for(SungJuk data : ar){
			data.calcTot();
			data.calcAvg(0;
			data.calcGrade();
		}
		
		 */
		
		System.out.print(ar[i].getName()+"\t"+ar[i].getKor()
				+"\t"+ar[i].getEng()
				+"\t"+ar[i].getMath()
				+"\t"+ar[i].getTot()
				+"\t"+String.format("%.2f", ar[i].getAvg())
				+"\t"+ar[i].getGrade());
			System.out.println();
			
		}
	
	}

}
