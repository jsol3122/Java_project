package nested;

public class Outer {
	private String name;
	
	public void output() {
		//System.out.println("�̸� = "+name+"\t���� = "+age); -- ����Ŭ���� �ٷ� ���� �Ұ���
		System.out.println("�̸� = "+this.name+"\t���� = "+new Inner().age); //��ü�����ؼ� ����
	}
	
	class Inner{  // member inner
		private int age;
		
		public void disp() {
			System.out.println("�̸� = "+Outer.this.name+"\t���� = "+this.age);
		}
	}
	
	public static void main(String[] args) {
		Outer ou = new Outer();	// InnerŬ������ �����̹Ƿ� OuterŬ���� �޸𸮸� ����
		ou.name = "ȫ�浿";
		ou.output();
		
		Outer.Inner in = ou.new Inner(); // new �� �� ����Ŭ�������� �˷���� ��
		in.age = 25;
		in.disp();  // �ܺ�Ŭ������ �ʵ� ������ �� �� ����
		
		Outer.Inner in2 = ou.new Inner();
		in2.age = 30;
		in2.disp();
		
		Outer.Inner in3 = new Outer().new Inner(); // ������ �� outer��ü ���� �ű⿡ ���λ���
		in3.age = 35;
		in3.disp();
		// in3.name(); --�̰� �Ұ��� / ����Ŭ������ �ܺβ� �����پ��°� Ŭ���� �ȿ����� ���� 
	}
}
