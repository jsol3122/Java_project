package thread;

class JoinTest implements Runnable {  // thread���� ��� 2 - �������̽� �̿�

	@Override
	public void run() { // callback �޼ҵ� - ȣ������� ��(�ü���� �˾Ƽ���)
		for(int i=1; i<=5; i++) {
			System.out.println("i = "+i); 
		} 
	} // run
	
}

//--------------------------------------------------------
public class JoinMain {

	public static void main(String[] args) {
		JoinTest jt = new JoinTest();  // thread ����x - ����� �ƴϴϱ�
		Thread t = new Thread(jt); // thread ����o - jt��� JoinTestŬ������ Thread�� ����
		
		System.out.println("������ ����");
		t.start(); // thread ���� - thread�� �����Ϸ� �ü���� ���� run()ȣ��
		try {
			t.join(); // thread�� �׿��� ���������� ��ȯ -> t�۾��� ���������� �ٸ� �۾����� ��ȯ��������(��׶���x)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������ ����");
	} 
	// main�޼ҵ�� run�޼ҵ� �ΰ��� thread�� �ִ� ��
	// main�޼ҵ尡 ����Ǵ��� thread�� ��׶��忡�� ��� ����(����x)
	// join���� thread�� �׿��ָ�, �ش� �۾��� ������ó�� ����Ǿ� �ش� �۾��� ����ɶ����� ����thread�� ��ȯx(��׶���x)
	// join�� �������� thread�� �ɾ��� ���� ����
}
