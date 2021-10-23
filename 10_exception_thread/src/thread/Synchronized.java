package thread;

// ����̴ϱ� ���� ���� thread new�����ؼ� ������ �ʿ�x - Ŭ���� ��ü�� thread
public class Synchronized extends Thread {
	private static int count;
	
	public Synchronized() {
		System.out.println("this = "+this);
	}
	
	public static void main(String[] args) {
		Synchronized aa = new Synchronized(); // ������ ����
		Synchronized bb = new Synchronized(); // Ŭ������ ���� ������� ������(����x) ���1����ȭ �ȵ�
		Synchronized cc = new Synchronized();
		
		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");
		
		aa.start(); // ������ ����
		bb.start();
		cc.start();
	}
	
	@Override
	// public synchronized void run() { -- ����ȭ ó���� �ȵ�(��� 1)
	public void run() {
		synchronized(Synchronized.class) { // �� thread�� �������� Ŭ���������� �̿��� ����ȭ - ��� 3
			for(int i=1; i<=5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName()+" : count = "+count);
			}
		}
	}

}
