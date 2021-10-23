package class_;


public class FruitTest {
	private FruitTest[] ar;
	private String pum;
	private int jan, feb, mar, tot;
	private static int sumJan, sumFeb, sumMar;
	// 월별합계는 객체별로 합계만 되고 객체간 일부값끼리의 합계 누적이 안되므로, static공간으로 따로 잡아서 계산 필요
	
	// 생성자
	public FruitTest(String pum, int jan, int feb, int mar) {
		this.pum=pum;
		this.jan=jan;
		this.feb=feb;
		this.mar=mar;
	}
	
	// 계산
	public void calcTot() {
		tot=jan+feb+mar;
		
		sumJan+=jan;
		sumFeb+=feb;
		sumMar+=mar;
	}
	
	public void display() {
		
		System.out.println(pum+"\t"+jan+"\t"+feb+"\t"+mar+"\t"+tot);
	}
	
	public static void output() { // static변수쓸때 메소드 잡기가 필수는 아님
		System.out.println("\t"+sumJan+"\t"+sumFeb+"\t"+sumMar);
	}
}
