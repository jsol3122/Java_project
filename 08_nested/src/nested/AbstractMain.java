package nested;

public class AbstractMain {

	public static void main(String[] args) {
		AbstractTest at = new AbstractTest() { // �߻� �͸� inner class�� new ���Ѽ� ���������� new �����ϱ�
			
			@Override
			public void setName(String name) {}
		};
		InterA in = new InterA() { // �������̽��� �͸� inner class�� new ���Ѽ� ���������� new �����ϱ�

			@Override
			public void aa() {} // �߻�޼ҵ��ִ� �߻�Ŭ���� - override �ʼ�!!

			@Override
			public void bb() {}
		};
		
		AbstractExam ae = new AbstractExam() {
			// override �ص��ǰ� ���ص��� - �߻�޼ҵ� ���� �߻�Ŭ����
		};
	}


}
