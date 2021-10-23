package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectReadMain {

	// throws ClassNotFoundException�� IOException �ΰ� �ɾ ��
	public static void main(String[] args) throws Exception { 
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result3.txt"));
		
		// readObject()�� ������ �����ʹ� ObjectŸ��(�ֻ����θ�Ŭ������)���� ����
		PersonDTO dto = (PersonDTO) ois.readObject();
		
		System.out.println("�̸� = "+dto.getName());
		System.out.println("���� = "+dto.getAge());
		System.out.println("Ű = "+dto.getHeight());

		ois.close();
	}

}
