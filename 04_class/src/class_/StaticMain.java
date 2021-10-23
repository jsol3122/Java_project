package class_;

public class StaticMain {
	private int a; // �ʵ�, �ν��Ͻ����� / ���� ����� �Ҹ� / ���� this.������ ������(this��������)
	// new�� �����Ҷ����� heap������ ���ο� a�� ����
	
	private static int b; // �ʵ�, Ŭ�������� / ���� Ŭ������.������ ������(Ŭ������ ��������)
	// ���� ������� ��� static������ �����ؼ� �޸𸮿� �ѹ��� �����Ѱ� ��Ӿ� // �������� - ��簴ü�� ����
	
	public StaticMain() {	// new �Ҷ����� �ʱ�ȭ ����
		System.out.println("�⺻ ������");
		a=3;
	}
	static {	// �� �ѹ��� �ʱ�ȭ ����
		System.out.println("static ����");
		b=3;
	}
	
	public void calc() {
		a++;
		b++;
	}
	
	public void disp() {
		System.out.println("a = "+this.a+"\t b = "+StaticMain.b); // static�� this���� ����
	}
	public static void output() {
		System.out.println("static method ");
		//System.out.println("a = "+this.a+"\t b = "+StaticMain.b);
			// ������ static�����̱� ������ this�� ���� ������ (static�ƴ� �ν��Ͻ������� ���Ѱ��̶� this��ü�� �ȵ�)
	}
	
	public static void main(String[] args) {
		StaticMain st = new StaticMain(); // ������ �ڵ�ȣ��Ǹ� static�� �ƴ� a������ heap�޸𸮿� ������
										// �׸��� ������ ���� ����� ����
		st.calc();	// a�� �����ڿ��� 3�� ��� b�� �� �������ϰ� ���Ϸ��ϸ� a=4 b=1 ��
		st.disp();	// ��� " a=4 b=1 "
		System.out.println();
		
		StaticMain st2 = new StaticMain(); //���� ������ ȣ��Ǹ� static�� �ƴ� ���ο� a������ heap�޸𸮿� ������
		st2.calc();	// a�� �ٽû����� ������ ���̶� �ٽ� �� 3 ���, b�� �Ʊ� �ִ� �� static�������� �Ҹ���ؼ� +1�ϸ� a=4 b=2 ��
		st2.disp();	// ��� " a=4 b=2 "
		System.out.println();
		
		StaticMain st3 = new StaticMain();	//�߰��� �� ������ ȣ��Ǹ� static�� �ƴ� ���ο� a������ heap�޸𸮿� ������
		st3.calc();	// a�� �ٽû����� ������ ���̶� �ٽ� �� 3 ���, b�� �Ʊ� �ִ� �� static�������� �Ҹ���ؼ� +1�ϸ� a=4 b=3 ��
		st3.disp();	// ��� " a=4 b=3 "
		System.out.println();
		
		// static �޼ҵ� ȣ��
		StaticMain.output(); // Ŭ���������� �ٷ� ���� ����  --> Ŭ������.�޼ҵ�()�� �ٷ� ȣ��
		output(); // class StaticMain ���̴ϱ� --> output(); �̷��Ը� �ҷ��� ȣ�Ⱑ��
		st.output(); // ��ü�� �������ٸ� --> st.output();���� ��ü�����ε� ȣ�� ����
		
	}

} // class StaticMain
