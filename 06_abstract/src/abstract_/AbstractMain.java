package abstract_;

//��Ӹ� �ϸ� �ȵǰ�, �籸��(override)���� �������(������) / �ڽ��� �籸�� ���ϸ� ����Ŭ������ ������ ���޵�(������)
public class AbstractMain extends AbstractTest{ 
	
	@Override
	public void setName(String name) { // Override(�籸��)���ϸ� �߻� �� ���� �ǹ� ����
		this.name=name;
	}

	public static void main(String[] args) {
		//AbstractTest at = new AbstractTest(); -> �߻�Ŭ������ new�޸𸮻��� �Ұ� => ������� �ذ�
		AbstractTest at = new AbstractMain(); // �ڽĲ��� new�����ؼ� �θ�+�ڽ� ���� �����ϱ�
		at.setName("ȫ�浿");
		System.out.println(at.getName());

	}

}
