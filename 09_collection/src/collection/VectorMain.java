package collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorMain {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();	// ArrayListó�� ���� new��ƹ����� ����
		// vector�� �⺻�뷮 10���� ��� ���� - arraylist�� �׶��׶� �߰�
		// vector���� �⺻�뷮 10�� �پ��� �����Ҷ����� 10���� �߰� - �����͸� ¯���� ����
		System.out.println("���� ũ�� = "+v.size()); // 0 - �׸� ����
		System.out.println("���� �뷮 = "+v.capacity()); // 10 - ���� ũ��(�⺻)
		System.out.println();
		
		System.out.println("--- �׸� �߰� ---");
		for(int i=1; i<=10; i++) {
			v.add(i+"");
		}
		System.out.println();
		
		// v.add("5"); -- collection�� �����̶� �ߺ�o����o
		v.addElement("5"); // add�� �ᵵ �ǰ� addElement�ᵵ �����ϰ� �Էµ�
		System.out.println("���� ũ�� = "+v.size()); // 11 - �׸� ����
		System.out.println("���� �뷮 = "+v.capacity()); // 20 - ���� ũ��(�⺻10�� �ٽἭ �� 10�߰�)
		System.out.println();
		
		for(int i=0; i<v.size(); i++) {
			System.out.print(v.get(i)+"  ");
		}
		System.out.println();
		
		System.out.println("--- �׸� ���� ---");
		v.remove("5");
		//v.removeElement("5"); -- remove�� �����ϰ� ���� �޼ҵ�
		v.removeElementAt(9); // �ش� �ε����� ���� ���� (��ġ���� ����) 
		// �ߺ��� �ִ°�� remove�ϸ� ���� �� �����ϴϱ� removeElementAt(��ġ)���� ��ġ�����ؼ� ����
		// �߰� ���� ������ ��� index��ȣ�� �׸�ŭ ������ ������ 
		
		Iterator<String> it = v.iterator(); // ���� -- get��� iterator�̿뵵 ����
		while(it.hasNext()) {
			System.out.print(it.next()+"  ");
		}
		System.out.println();
		
		Vector<String> v2 = new Vector<String>(5, 2); 
		// �⺻�뷮 5�� ���, �پ��� 2�� �뷮 �����ϵ��� ���� - �� default��(10,10) ������ �ʿ�x
	}

}
