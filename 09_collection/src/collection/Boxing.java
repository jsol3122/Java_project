package collection;

public class Boxing {
	public static void main(String[] args) {
		int a = 25; // �⺻��
		// double b = a; -- �������� �ƴ�����, ���� �⺻���̰� double���� �� ũ�ϱ� ����
		double b = (double)a/3;  // (double)�� ��������ȯ / 3->3.0�� �ڵ�����ȯ
		
		String c = "25";
		// int d = (int)c; -- ��ü���� �⺻������ ����ȯ �Ұ���
		int d = Integer.parseInt(c); // ���� ��ü������ ����ȯ ĳ����
		
		int e = 5;
		Integer f = e; // AutoBoxing(��üȭ) -- ���� �������̴ϱ� ���
		// Integer f = new Integer(e); -- ������ AutoBoxing�ȵż� �̷��� ������
		
		Integer g = 5;
		int h = g; // UnAutoBoxing (=AutoUnboxing)
		// int h = g.intValue(); -- ������ AutoUnboxing�ȵż� �̷��� ����
	}

}
