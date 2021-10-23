package thread;

class SnackTest extends Thread{ // thread���� ��� 1 - ��� �̿�
	private String str;

	public SnackTest(String str) {
		this.str = str;
	}
	
	public void run() {
		for(int i=1; i<=5; i++) {
			System.out.println(str+"\ti = "+i+"\t"+Thread.currentThread()); // static�޼ҵ� - ���� ������ ������ ����
		} // for
	}
	
}
//---------------------------------------------------
public class SnackMain {

	public static void main(String[] args) { // ������(������x)�� ��� - main�� callback��
		// thread new ���� - ����س����ϱ�
		SnackTest aa = new SnackTest("�����"); 
		SnackTest bb = new SnackTest("��īĨ");
		SnackTest cc = new SnackTest("Ȩ����");
		
		// thread �̸� �ο�
		aa.setName("�����");
		bb.setName("��īĨ");
		cc.setName("Ȩ����");
		
		// thread �켱���� �ο� (1~10 �� �ο���) -- �ݵ�� �������� ���� �ƴ�
		//aa.setPriority(Thread.MAX_PRIORITY); // ���� ���� �켱���� �ο�(10) - ���� ���� �Ϸ�
			// aa.setPriority(10); -- �̷� �������� �켱���� �ο��� ����
		//bb.setPriority(Thread.MIN_PRIORITY); // ���� ���� �켱����(1)
		//cc.setPriority(Thread.NORM_PRIORITY); // �߰� �켱����(5) - default��
		
		// thread ���� - ���� ������ ���ǹ��� �Ұ���(�ü���� �ڵ�����)
		aa.start(); 
		try {
			aa.join(); // thread ���̱� - ���� ���� ó���Ϸ��ҵ��� �������� �����·� �����
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bb.start();
		cc.start();
	}

}
