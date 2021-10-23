package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PersonSort {

	public static void main(String[] args) {
		String[] ar = {"orange", "apple", "banana", "pear", "peach", "applemango"};
		
		System.out.print("���� �� = ");
		for(String str : ar) {
			System.out.print(str+"  ");
		}
		System.out.println();
		
		Arrays.sort(ar); // sort�� �˾Ƽ� ���� - �迭�̴ϱ� Arrays�� ����
		
		System.out.print("���� �� = ");
		for(String str : ar) {
			System.out.print(str+"  ");
		}
		System.out.println("\n");
		
		PersonDTO aa = new PersonDTO("ȫ�浿", 25); 
		PersonDTO bb = new PersonDTO("���̾�", 30);
		PersonDTO cc = new PersonDTO("����ġ", 28);
		
		// �� ���� ������ ��ü���� �� ���� ��Ƴ���
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>(); 
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		System.out.println("���� �� : ");
		System.out.println(list); 
		// list�� [,,]�ȿ� �׸��� ������
		// ���� toString()�� ���� �ּҰ� ����ε�, override�ؼ� ���밪 ����ϵ��� ������
		System.out.println();
		
		// �Ʊ�� �޸� �迭 �ƴ϶� collection�� sort�ϴ� �Ŵϱ� 
		Collections.sort(list);
		
		System.out.println("���̷� ��������(��������) : ");
		System.out.println(list); 
		System.out.println();
		
		System.out.println("�̸����� ��������(��������) : ");
		Comparator<PersonDTO> com = new Comparator<PersonDTO>() { // �͸� inner�̿��� ����
			@Override
			public int compare(PersonDTO dto1, PersonDTO dto2) { 
				// ���ڿ��� ��ü������ ũ���x - compareTo �̿��ϱ�
				// return dto1.getName().compareTo(dto2.getName()); - ��������
				// ����� -1/0/1 ���� �����ϱ� �� ��ü�� return�ϱ�
				return dto2.getName().compareTo(dto1.getName()); // �������� ��� 1
				// return dto1.getName().compareTo(dto2.getName())*-1; - �������� ��� 2
			}
		};
	
		Collections.sort(list, com); // list�� ��� ������ ���� ���� com�������� sort
		System.out.println(list);
		System.out.println();
		
	}
}
