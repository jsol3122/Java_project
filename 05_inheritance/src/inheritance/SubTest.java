package inheritance;

public class SubTest extends SuperTest { // SuperTest(�θ�)�� �ڽ�Ŭ�������� ��������
	// ��ӵ� ���谡 ���� ��� �ϴ� �ڽ�Ŭ�������� �˻��ϰ� ������ �� �θ�Ŭ������ ã���� ��
	// �θ�Ŭ������ �⺻������ �ʿ� - �⺻������ �ڵ�ȣ���Ϸ��� Ŭ�����ȿ� ������ 0������ ��
	// ������ ������(double,double) �־ �ڵ����� �ȸ�������ϱ� �⺻������ ���ٰ� ������
	// 
	private String name; // private�ɸ� ��� �ȵǰ� ���� ��
	private int age;

	public SubTest(String name, int age, double weight, double height) {
		System.out.println("SubTestŬ���� ������");
		this.name=name;
		this.age=age;
		this.weight=weight; // �θ�͵� �����̱� ������ this ����
		this.height=height;
		// super.weight=weight; �� �ϸ� �θ� ���� �ٷ� ������� ��
		// this���°Ͱ� super���°� ����� ���������� this�� �� ���뼺����
	}
	
	public void output() {
		System.out.println("SubTestŬ���� output()");
		System.out.println("�̸� = "+ name);
		System.out.println("���� = "+age);
		System.out.println("������ = "+weight);
		System.out.println("Ű = "+height);
	}
	public static void main(String[] args) {
		SubTest aa = new SubTest("ȫ�浿", 25, 72.3, 185.3); 
		// �ڽ�Ŭ������ new�����ϸ� �ڽ�+�θ� �޸� ���� ���� = �����ڵ� �ΰ� ȣ��
		aa.output();
		System.out.println("--------------------------");
		aa.disp(); // �켱 �� Ŭ���� �ȿ��� ã�� ������ �θ�(SuperTest)�� ã���� ��
		System.out.println("--------------------------");
		
		SuperTest bb = new SubTest("�ڳ�", 13, 25.6, 158.7);
		// bb.output();  --> �Ұ��� : SuperTest�� �����ϱ� ���� // �����ڴ� �θ�/�ڽ� �Ѵ� ������
		// �θ�� �ڽ�Ŭ������ ������ �� �ִ�! �߿��ϰ� ���� ��
		bb.disp();
	}

}
