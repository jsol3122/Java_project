package thread;

public class SingleTon { 
	private int num=3;
	private static SingleTon instance=null; // static���� �ѹ��� �޸𸮻������ֱ� (��� new���� x)
	// null�� �ʱ�ȭ�Ǵ� ������ ���α׷� ��ü���� ó�� �� �ѹ��� ����!!
	
	public static SingleTon getInstance() {
		if(instance==null) { // �� ó�� ���ѹ��� null�� - �ʱ�ȭ�� ���ѹ��̴ϱ�
			synchronized(SingleTon.class){ // ����ȭ ó�� - ��� 3
				instance = new SingleTon(); // ó�� ���ѹ��� �����ϰ� ��
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		SingleTon aa = new SingleTon();
		aa.num++;
		System.out.println("aa = "+aa); // 16���� �ּҰ� ���
		System.out.println("num = "+aa.num);
		System.out.println();
		
		SingleTon bb = new SingleTon();
		bb.num++;
		System.out.println("bb = "+bb);
		System.out.println("num = "+bb.num);
		System.out.println();
		
		System.out.println("--- �̱��� ---");
		SingleTon cc = SingleTon.getInstance(); // new���� ���� - static�޼ҵ忩����
		cc.num++;
		System.out.println("cc = "+cc); // 16���� �ּҰ� ���
		System.out.println("num = "+cc.num);
		System.out.println();
		
		SingleTon dd = SingleTon.getInstance(); // new���� ����
		dd.num++;
		System.out.println("dd = "+dd); // cc�� �ּҰ� ����
		System.out.println("num = "+dd.num);
		System.out.println();
	}
	
	
}
