package inheritance;

public class SuperTest {
	protected double weight, height;
	
	public SuperTest() {
		System.out.println("SuperTestŬ���� �⺻������");
	}
	
	// ������ - ���� ���� �μ�(�Ű�����)�� double w, h; �̷��� ���� �ȵ�
	public SuperTest(double weight, double height) {
		System.out.println("SuperTestŬ���� ������");
		this.weight=weight;
		this.height=height;				
	}
	
	// getter���� ��� �ٷ� ����ع��� ���� ����
	public void disp() { // �ڽ�Ŭ������ �Ȱ��� �̸��� disp()�������� - �̸��� �������� �ٸ����� => Override
		System.out.println("SuperTestŬ���� disp()");
		System.out.println("������ = "+weight);
		System.out.println("Ű = "+height);
	}
	
	
}
