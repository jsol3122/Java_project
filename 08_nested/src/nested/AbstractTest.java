package nested;

// POJO���� - Ŭ������ ������������ [ Plain Old Java Object ]
public abstract class AbstractTest {
	String name; // default�ϱ� ����Ű�� ������o

	public String getName() {
		return name;
	}

	// interface�� ������ �߻���̶� abstract ���� �Ƚᵵ ��
	public abstract void setName(String name);
}
