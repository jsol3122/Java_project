package com.apple;

import com.zoo.Zoo;

public class Apple {
	public static void main(String[] args) {
		System.out.println("���� ���");
		// static���� �޼ҵ�ϱ� new���ֱ�
		Zoo z = new Zoo();
		//com.zoo.Zoo z = new com.zoo.Zoo(); --> �̷��� �ص� �� / ������ �� Ŭ�����ȿ����� ��������
		z.tiger(); // public�̶� �ٸ� ��Ű������ ���� - default,protected,private�� �ٸ���Ű��x
		//z.giraffe();
		//z.elephant();
		//z.lion();
		
		
		
	}
}
