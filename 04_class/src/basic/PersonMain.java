package basic;

class Person{ // �޴����� - �޸�����x / ����Ϸ��� new�� �����������!!
	private String name; 	// �ʵ�. �ʱ�ȭ�Ǿ��ֱ� ������ �⺻������ �����Ⱚ ������ ����
	private int age;
	
	public void setName(String n) {
		name = n;
	}
	public void setAge(int a) {
		age = a;
	}
	public void setData(String n, int a) {
		name=n; age=a;
	}
	public void setData() {	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
//---------
public class PersonMain {

	public static void main(String[] args) {
		Person p; //��ü�� (����x)
		p = new Person(); // �޸𸮿� Ŭ����(�޴���) ��������
		System.out.println("��ü p = "+p);
		System.out.println("��ü p = "+p.toString());
		p.setName("ȫ�浿");
		p.setAge(25);
		// p.name = "ȫ�浿";		---> PersonŬ������ name�� age�� private�Ǿ����� ���� ���� �̷��� ȣ��
		// p.age = 25;
		System.out.println("�̸� = "+p.getName()+"\t ���� = "+p.getAge());
		System.out.println();
		
		Person p2 = new Person();
		System.out.println("��ü p2 = "+p2);
		p2.setName("�ڳ�");
		p2.setAge(13);
		System.out.println("�̸� = "+p2.getName()+"\t ���� = "+p2.getAge());
		System.out.println();
		
		Person p3 = new Person();
		p3.setData("���̾�", 35);
		System.out.println("�̸� = "+p3.getName()+"\t ���� = "+p3.getAge());
		System.out.println();
		
		Person p4 = new Person();
		p3.setData();
		System.out.println("�̸� = "+p4.getName()+"\t ���� = "+p4.getAge());
		System.out.println();
		
	}
}
