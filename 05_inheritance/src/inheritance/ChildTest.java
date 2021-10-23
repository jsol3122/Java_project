package inheritance;


public class ChildTest extends SuperTest {
	private String name; 
	private int age;
	
	public ChildTest(String name, int age, double weight, double height) {
		super(weight, height); //���� ���ϴ� �θ������ �����ؼ� ȣ�� - �� ù��!
		// �⺻�θ�����ڴ� �ڵ�ȣ���� / ���ϴ� �θ������ȣ���� super()�� �ҷ�����
		
		System.out.println("ChildTestŬ���� ������");
		this.name=name;
		this.age=age;
		this.weight=weight; // �θ�͵� �����̱� ������ this ����
		this.height=height;
		
	}
	
	public void disp() { // Override
		System.out.println("ChildTestŬ���� disp()");
		System.out.println("�̸� = "+ name);
		System.out.println("���� = "+age);
		System.out.println("������ = "+weight);
		System.out.println("Ű = "+height);
	}
 
	public static void main(String[] args) {
		ChildTest aa = new ChildTest("ȫ�浿", 25, 72.3, 185.3);
		aa.disp(); // �θ�Ŭ�������� disp()�� ������ �ڽ�Ŭ������ ���� ã������ �����ϱ� �ڽĲ� ȣ���
	
		SuperTest bb = new ChildTest("�ڳ�", 13, 25.6, 158.7);
		bb.disp(); // �θ�Ŭ������ ����������, Override�Ǿ��ֱ� ������ �ڽĲ����� ã�Ƽ� ȣ����
	}
}
