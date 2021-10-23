package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionMain2 {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>(); // �߻�Ŭ���� �ƴϹǷ� new����
		// ArrayList�����ؼ� new�ϸ� get()�� �� ���� - iterator �Ƚᵵ ��

		list.add("ȣ����");
		list.add("����");
		list.add("ȣ����"); // �ߺ����, ����
		//list.add(25);
		//list.add(43.8);
		list.add("�⸰");
		list.add("�ڳ���");
		
		Iterator it = list.iterator(); // collection�ȿ� ������ �������̽� ����
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		// iterator�� ��ü ����Լ��� ���°�� ���� ��� + ���� �ÿ��� �ʼ�
		
		System.out.println("-------------------------------");
		
		for(int i=0; i<list.size(); i++) { // list�� �ٷ� �����ߴٸ� iterator �Ⱦ��� get���� ��°���
			System.out.println(list.get(i));
		}
		
		System.out.println("-------------------------------");
		
		for(String data : list) { // Ȯ��for������ ����ص� �� - ���� ���̻��
			System.out.println(data);
		}
		
	}

}
