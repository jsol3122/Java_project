package abstract_;

// POJO���� (Plain Old Java Object ������ ����)
// Ư���� �ٸ��ſ� ��ӹ��� �ʰ� �⺻Object��Ӹ� �⺻���� �������ְ�, private���� �ʵ���� set/get�ִ� �ܼ�Ŭ����
public abstract class AbstractTest { // �߻��� ���� Ŭ������� ��
	String name; // private���� �� �ƿ� �Ⱦ��� default��

	public String getName() {
		return name;
	}

	//�߻�޼ҵ� - �߻��� �ɾ����� ���������δ� ���� ��������Ŷ�� ����(����=override�ʼ�)
	public abstract void setName(String name); 
	
} //class
	

