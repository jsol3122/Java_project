package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMain {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>(); // ������ ��Ģ ���� �������� ���(����x)
		
		set.add("ȣ����");
		set.add("����");
		set.add("ȣ����"); // �ߺ����x(�ѹ��� ���), ����x
		set.add("�⸰");
		set.add("�ڳ���");
		
		Iterator<String> it = set.iterator(); // ����
		
		for(String data : set) { // ��ü ����Լ� x
			System.out.println(data);
		}

	}

}
