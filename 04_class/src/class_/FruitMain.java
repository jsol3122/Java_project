package class_;

public class FruitMain {

	public static void main(String[] args) {
		FruitTest[] ar = {new FruitTest("사과", 100, 80, 75)
				,new FruitTest("포도", 30, 25, 10)
				,new FruitTest("딸기", 25, 30, 90)}; //배열형[] 배열명 = {초기값, 초기값, 초기값}
		
	/*---------배열 다르게 잡기---------------------
		FruitTest[] ar = new FruitTest[3];
		ar[0] = new FruitTest("사과", 100, 80, 75);
		ar[1] = new FruitTest("포도", 30, 25, 10);
		ar[2] = new FruitTest("딸기", 25, 30, 90);	// 이렇게 하면 for문은 못돌림
	------------또 다른 방법-------------------------
		배열형[] 배열명 = new 배열형[]{초기값, 초기값, 초기값}  ---> 초기값 바로앞[]는 꼭 비워두기
			ex) FruitTest[] ar = new FruitTest[] {new FruitTest("사과", 100, 80, 75),
												, new FruitTest("포도", 30, 25, 10)
												, new FruitTest("딸기", 25, 30, 90)}
			
	*/		
		
		ar[0].calcTot();
		ar[1].calcTot();
		ar[2].calcTot();
		
		System.out.println("---------------------------------------");
		System.out.println("PUM \t JAN \t FEB \t MAR \t TOT");
		System.out.println("---------------------------------------");
		ar[0].display();
		ar[1].display();
		ar[2].display();
		System.out.println("---------------------------------------");
		FruitTest.output();
	
	/* for문 돌리기 -1
	 	for(int i=0; i<ar.length; i++)
	 
	 * for문 돌리기 -2(확장형 for문 - 주소값을 통으로 받아옴 / FruitTest라는 클래스를 받아옴)
	 	for(FruitTest data : ar){
	 	data.calcTot();
	 	data.display();
	 	}   --> 방번호가 아니라 데이터를 통으로 받아서 출력
	 */
		
	}
}
