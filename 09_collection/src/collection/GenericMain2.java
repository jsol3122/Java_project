package collection;

class GenericTest2<T>{  // � Ÿ���� ���� ���� �����ߴٴ� ������ T
	private T a;
	
	public GenericTest2(T a) { // generic�̶� �ǳ� String���� ���� �ƴϴϱ� T������
		this.a = a;
	} // ������
	
	public void setA(T a) {
		this.a = a;
	}
	public T getA() {
		return a;
	}
}


//--------------------------------------------------------------
public class GenericMain2 {

	public static void main(String[] args) {
		GenericTest2<?> aa = new GenericTest2<String>("ȫ�浿");
		// �̷��� ?������ String���� ����������, Ŭ���� ���ο����� ObjectŸ��ó�� �����
		// BUT, ?�� �̿��ϸ� setter�δ� �������Է� �Ұ��� / ������ ���� �Է¸� ����
		String name = (String)aa.getA();
		// Ŭ���� ���ο��� ObjectŸ��ó�� ����ǰ� �����Ƿ�, StringŸ������ casting
		System.out.println("�̸� = "+name);
		
		GenericTest2<?> bb = new GenericTest2<Integer>(25);
		int age = (Integer)bb.getA(); 
		// int���� Integer(��ü��)���� ����ȯ�ؼ� �޾Ƶ� ���� - AutoUnboxing
		System.out.println("���� = "+age);
	}

}
