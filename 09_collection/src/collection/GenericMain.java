package collection;

class GenericTest<T>{  // � Ÿ���� ���� ���� �����ߴٴ� ������ T
	private T a;
	
	public void setA(T a) {
		this.a = a;
	}
	public T getA() {
		return a;
	}
}


//--------------------------------------------------------------
public class GenericMain {

	public static void main(String[] args) { // Ÿ���� �⺻��x 
		GenericTest<String> aa = new GenericTest<String>(); 
		// ������ �� �� Ÿ�� �����ִ� ��
		aa.setA("ȫ�浿");
		System.out.println(" �̸� = "+aa.getA());
		
		// aa.setA(25); - �̰� ���� / StringŸ������ �ϱ�� �����߱� ����
		
		GenericTest<Integer> bb = new GenericTest<Integer>();
		// ���� Ŭ������ �ٸ� Ÿ������ ������ ���� ����
		bb.setA(25); // ����
		System.out.println(" ���� = "+bb.getA());
	}
	
	

}
