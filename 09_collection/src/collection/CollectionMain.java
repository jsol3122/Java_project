package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain {

	public static void main(String[] args) {
		Collection coll = new ArrayList(); // ��� implement���ִ� Ŭ����
		// collection�� �θ�Ŭ�����μ� ����Ѱ�ó�� �۵���
		// coll.get(�ε�����ȣ); �� ���� ������ �� ������, get()�޼ҵ尡 ArrayList�� �ְ� Collection(�θ�)�� �������̶� �� �� ����
		
		coll.add("ȣ����");
		coll.add("����");
		coll.add("ȣ����"); // �ߺ����, ����
		coll.add(25);
		coll.add(43.8);
		coll.add("�⸰");
		coll.add("�ڳ���");
		
		Iterator it = coll.iterator(); // collection�ȿ� ������ �������̽� ����
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
