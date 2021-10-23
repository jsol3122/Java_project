package inheritance2;

public class FinalMain {
	public final String FRUIT = "���"; // static�� �ƴϹǷ� ��ü�����ʿ�
	public final String FRUIT2;
	
	public static final String ANIMAL = "ȣ����";
	public static final String ANIMAL2;
	
	static { // static�̶�� static�������� �ʱ�ȭ (������ �Ұ���)
		ANIMAL2 = "�⸰";
	}
	public FinalMain() { // static�ƴ϶�� �����ڷ� �ʱ�ȭ
		FRUIT2 = "����"; 
	}

	public static void main(String[] args) {
		final int AGE = 25; // final�Ⱦ��� �빮�ڷ� �ᵵ �׳� ������
		// AGE = 30; --> final�̱⶧���� ���� �Ұ��� ������
		System.out.println("AGE = "+AGE);
		
		final int AGE2; // �ʱⰪ�� ����ÿ� ���൵ �ٷδ����� �ָ� ����(C���� ����� �ʱⰪ ���ָ� ����)
		AGE2 = 30;
		System.out.println("AGE2 = "+AGE2);
		
		FinalMain aa = new FinalMain();
		System.out.println("FRUIT = "+aa.FRUIT); // static�ƴ϶� new�����ؼ� �ҷ�����
		System.out.println("FRUIT2 = "+aa.FRUIT2);
		
		System.out.println("ANIMAL = "+FinalMain.ANIMAL); // static�� new���� ���ص���
		System.out.println("ANIMAL2 = "+FinalMain.ANIMAL2);
	}

}
