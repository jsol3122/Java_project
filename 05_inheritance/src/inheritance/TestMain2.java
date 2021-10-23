package inheritance;

class AA {
	public int a = 3;
	
	public void disp() {
		a+=5;
		System.out.println("AA : "+a+" ");
	}
}
//----------------------------------------------------------
class BB extends AA {
	public int a =8;
	
	public void disp() {
		this.a += 5;
		System.out.println("BB : "+a+" ");
	}
}
//----------------------------------------------------------
public class TestMain2 {

	public static void main(String[] args) {
		BB aa = new BB();
		aa.disp(); // BB : 13
		System.out.println("aa : "+aa.a); // aa : 13 -> disp()�����鼭 a���� ����ż�
		System.out.println();
		
		AA bb = new BB(); // new�� ���� ����Ŷ� ���� new�����ڿ��� ������ ���� �� ����(������) --> ������
		bb.disp(); // BB : 13
		System.out.println("bb : "+bb.a); // bb : 3 --> �ʵ�� override��°� ���� (only �޼ҵ�)
		System.out.println();
		
		AA cc = new AA(); // �θ�Ŭ���������ؼ� �θ�Ŭ������ ����Ŷ� �θ� ����!! / �θ����忡�� �ڽ��ִ����� ��
		cc.disp(); // AA : 8
		System.out.println("cc : "+cc.a); // cc : 8
		System.out.println();
		
		/* �ڽ�Ŭ���� ���� = �θ�Ŭ����  --> �̰� �Ұ��� ==> �Ϸ��� Casting(����ȯ)�ؾ���
			ex) �ڽ�Ŭ���� ���� = (�ڽ�)�θ�Ŭ���� �� ����ȯ(�̰�� �ڽ����� down Cast)�������
			ex) BB dd = bb;   --> �Ұ��� 
				BB dd = (BB)bb;  --> �̷��� ����ȯ����� ��
		*/
		
		BB dd = (BB)bb; // new�� ����� �ƴϱ� ������ ���� �� �����پ��Ŷ� ���� �����ߴ� ���굵 �� �����ִ°� ���°���
		dd.disp();
		System.out.println("dd : "+dd.a);
		System.out.println();
	}

}
