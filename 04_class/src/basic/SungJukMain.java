package basic;

public class SungJukMain {

	public static void main(String[] args) {
		SungJuk[] ar = new SungJuk[3];
		System.out.println("----------------------------------------------------");
		System.out.println("�̸�\t����\t����\t����\t����\t���\t����");
		System.out.println("----------------------------------------------------");
				
		for(int i=0; i<ar.length; i++) {
			ar[i] = new SungJuk();
		}
		
		ar[0].setData("ȫ�浿", 90, 96, 100);	// ȣ��� (���� ������ �ֱ�)
		ar[1].setData("���̾�", 100, 89, 75);
		ar[2].setData("����ġ", 75, 80, 48);
		
		for(int i=0; i<ar.length; i++) {
		ar[i].calcAvg();
		ar[i].calcGrade();
		ar[i].calcTot();
		/* Ȯ���� for�� �̿� - Ŭ�������迭�� �����̴ϱ� Ŭ����Ÿ��(SungJuk)���� Ÿ�����
		
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
