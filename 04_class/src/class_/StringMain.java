package class_;

public class StringMain {

	public static void main(String[] args) {
		String a = "apple";
		String b = "apple";
		
		if(a==b) System.out.println("a�� b�� �������� ����");
		else System.out.println("a�� b�� �������� �ٸ���");
		
		if(a.equals(b)) System.out.println("a�� b�� ���ڿ��� ����");
		else System.out.println("a�� b�� ���ڿ��� �ٸ���");
		System.out.println();
		
		String c = new String("apple");
		String d = new String("apple");
		if(c==d) System.out.println("c�� d�� �������� ����");
		else System.out.println("c�� d�� �������� �ٸ���");
		
		if(c.equals(d)) System.out.println("c�� d�� ���ڿ��� ����");
		else System.out.println("c�� d�� ���ڿ��� �ٸ���");
		System.out.println();
		
		String e = "���� ��¥�� "+1991+7+16; 
		System.out.println("e = "+e);
		System.out.println("���ڿ� ũ�� = "+e.length());  // 14��
		
		System.out.println("ù��° ���� = "+e.charAt(0));
		System.out.println("�ι�° ���� = "+e.charAt(1));
		System.out.println("������ ���� = "+e.charAt(13));
		
		System.out.println("�κ� ���ڿ� ���� = "+e.substring(7));
		System.out.println("�κ� ���ڿ� ���� = "+e.substring(7, 11));  // 1991�̱� - 7����ġ���� 11�� "����"���� �̾ƿ�
		
		System.out.println("�빮�� ���� = "+"Hello".toUpperCase());		// ��ҹ��� �����־ �ϴ� �빮��/�ҹ��ڷ� ����
		System.out.println("�ҹ��� ���� = "+"Hello".toLowerCase());
		
		System.out.println("���ڿ� �˻� = "+e.indexOf("¥"));	//4
		System.out.println("���ڿ� �˻� = "+e.indexOf("��¥"));	//3
		System.out.println("���ڿ� �˻� = "+e.indexOf("���ٺ�"));	//-1�� ã�� ���ڰ� ���ٴ� ��
		System.out.println("���ڿ� �˻� = "+e.indexOf("1"));	// ã�� ���ڿ��� ��������� �� �տ� ���� ��� = 0�����ں��� �˻���
		System.out.println("���ڿ� �˻� = "+e.indexOf("1", 8));	// 8��° ���ڿ����� "1"�� ã����� ���� ����(�� �պ��� �˻�x)
		
		System.out.println("���ڿ� ġȯ = "+e.replace("��¥", "����"));
		/* �̷��� �ϸ� "���� ��¥�� " / "���� ��¥�� 1991" / "���� ��¥�� 19917" / "���� ��¥�� 1991716" �޸� 4���� ���� - ������ �ȵǴϱ� 
		JVM�� ������ Garbage Collector(������)���� ���� - �ٷ� ����x
		Garbage Collector�� ����Ǹ� ��ǻ�Ͱ� ��� ���� - ����������ϴ°�
		 */
	}

}





