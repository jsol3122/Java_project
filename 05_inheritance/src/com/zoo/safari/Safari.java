package com.zoo.safari;

import com.zoo.Zoo;

public class Safari extends Zoo{

	public static void main(String[] args) {
		Zoo z = new Zoo(); // ���� ��Ű���ϱ� import���ص���
		z.tiger(); // public�̶� ����
		// z.giraffe(); -- �θ� ��Ƽ� �����ϸ� �θ� �ڽ� �ִ��� ���� �����پ�
		//z.elephant();
		//z.lion();  
		System.out.println("------------------");
		Safari s = new Safari();
		s.tiger();
		s.giraffe(); // �ڽ� ��Ƽ� �����ϸ� ������� �ƴϱ� �θ�� ���پ� �� ����
		//s.elephant();
		//s.lion();
	}

}
