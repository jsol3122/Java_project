package class_;

public class FruitMain {

	public static void main(String[] args) {
		FruitTest[] ar = {new FruitTest("���", 100, 80, 75)
				,new FruitTest("����", 30, 25, 10)
				,new FruitTest("����", 25, 30, 90)}; //�迭��[] �迭�� = {�ʱⰪ, �ʱⰪ, �ʱⰪ}
		
	/*---------�迭 �ٸ��� ���---------------------
		FruitTest[] ar = new FruitTest[3];
		ar[0] = new FruitTest("���", 100, 80, 75);
		ar[1] = new FruitTest("����", 30, 25, 10);
		ar[2] = new FruitTest("����", 25, 30, 90);	// �̷��� �ϸ� for���� ������
	------------�� �ٸ� ���-------------------------
		�迭��[] �迭�� = new �迭��[]{�ʱⰪ, �ʱⰪ, �ʱⰪ}  ---> �ʱⰪ �ٷξ�[]�� �� ����α�
			ex) FruitTest[] ar = new FruitTest[] {new FruitTest("���", 100, 80, 75),
												, new FruitTest("����", 30, 25, 10)
												, new FruitTest("����", 25, 30, 90)}
			
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
	
	/* for�� ������ -1
	 	for(int i=0; i<ar.length; i++)
	 
	 * for�� ������ -2(Ȯ���� for�� - �ּҰ��� ������ �޾ƿ� / FruitTest��� Ŭ������ �޾ƿ�)
	 	for(FruitTest data : ar){
	 	data.calcTot();
	 	data.display();
	 	}   --> ���ȣ�� �ƴ϶� �����͸� ������ �޾Ƽ� ���
	 */
		
	}
}
