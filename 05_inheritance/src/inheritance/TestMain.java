package inheritance;


class Test{
	int a,b;
}
//-----------------------------------------
public class TestMain {

	public static void main(String[] args) {
		Test aa = new Test(); // new�� �����ϸ� �ּҰ��� ����
		Test bb = aa; // new�� �����ؼ� ���� Ŭ������ �ּҰ��� �ٽ� ���� ��(Ŭ���� ��üx)
		aa.a=2;
		aa.b=5;
		System.out.println(aa.a+"\t"+aa.b); // 2 5
		System.out.println(bb.a+"\t"+bb.b); // 2 5
		System.out.println();
		
		bb.a=7;
		bb.b=9;
		System.out.println(aa.a+"\t"+aa.b); // 7 9
		System.out.println(bb.a+"\t"+bb.b); // 7 9
		System.out.println();
		
		bb = new Test(); // bb�� �ִ� ������ ���� aa�� �ּҰ� ������� ���ο� new�� ������ �ּ� ����
		bb.a=10;
		bb.b=20;
		System.out.println(aa.a+"\t"+aa.b); // 7 9
		System.out.println(bb.a+"\t"+bb.b); // 10 20
	}
}
