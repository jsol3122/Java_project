package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SungJukService {
	Scanner scan = new Scanner(System.in);
	private List<SungJukDTO> list; // ������ �̿��ؼ� �θ�Ŭ���� �����ؼ� �ڽ�Ŭ���� �����ϴ°��� ȿ����
	
	
	public SungJukService() {
		list = new ArrayList<SungJukDTO>();
	} // ������
	
	public void menu() {
		for(;true;) {
		System.out.print("*****************\r\n"
				+ "   1. �Է�\r\n"
				+ "   2. ���\r\n"
				+ "   3. �˻�\r\n"
				+ "   4. ����\r\n"
				+ "   5. ����\r\n"
				+ "   6. ��\r\n"
				+ "*****************\r\n");
		System.out.print(" ��ȣ : ");
		int n = scan.nextInt();
		
		if(n==1) insertArticle();
		if(n==2) printArticle();
		if(n==3) searchArticle();
		if(n==4) deleteArticle();
		if(n==5) sortArticle();
		if(n==6) return;
		else if(n>6) System.out.println("1~6 �߿� �����ϼ��� \n");
		}
	} // menu
	
	public void insertArticle() {
		SungJukDTO dto = new SungJukDTO();
		System.out.println();
		System.out.print("��ȣ �Է� : ");
		dto.setNum(scan.nextInt());
		System.out.print("�̸� �Է� : ");
		dto.setName(scan.next());
		System.out.print("���� �Է� : ");
		dto.setKor(scan.nextInt());
		System.out.print("���� �Է� : ");
		dto.setEng(scan.nextInt());
		System.out.print("���� �Է� : ");
		dto.setMath(scan.nextInt());
		
		System.out.println();
		System.out.println("��� �Ϸ�");
		System.out.println();
		dto.calc();
		list.add(dto);
	} // insert
	
	public void printArticle() {
		System.out.println();
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		for(SungJukDTO dto : list) {
			System.out.print(dto);
		}
		System.out.println();
	} // print
	
	public void searchArticle() {
		int cnt=0, c=0;
		System.out.println();
		System.out.print("�˻��� �̸� �Է� : ");
		String n = scan.next();
		for(SungJukDTO dto : list) {	
			if(dto.getName().compareTo(n)==0) {
				if(c==0) {
					System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
					c++;
				}
			System.out.print(dto);
			cnt++;
			} // if
		}
		if(cnt==0) System.out.println("ã���� �ϴ� �̸��� �����ϴ�");
		System.out.println();
	} // search
	
	// ������ �̸����� list�����ϸ� index��ȣ�� �޶����ϱ�, iterator�̿��ؼ� index��ȣ�� �ƴ� �� ��ü�� �����ϵ��� �����ؼ� ����
	public void deleteArticle() { 
		System.out.println();
		int size = list.size();
		
		System.out.print("������ �̸� �Է� : ");
		String n = scan.next();
		
		for(Iterator<SungJukDTO> it = list.iterator(); it.hasNext();) {	
			SungJukDTO dto = it.next(); // iterator�� ���� �����͸� dto�� ��� ��Ƴ��� next�� �̵�
			if(dto.getName().compareTo(n)==0) {
				it.remove(); // it�� ����Ű�� ������ġ�� ����� ��x ������ ������ dto ����°���
			}
		} 
		if(size!=list.size()) System.out.println("�����͸� �����Ͽ����ϴ�");
		if(size==list.size()) System.out.println("������ �̸��� ã�� ���Ͽ����ϴ�");
		System.out.println();
	} // delete
	
	public void sortArticle() {
		System.out.println();
		System.out.print("1. �̸����� ��������\r\n"
				+ "2. �������� ��������\r\n"
				+ "3. �����޴�\r\n");
		System.out.print(" ��ȣ �Է� : ");
		int num = scan.nextInt();
		
		if(num==1) { // �̸����� ��������
			Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() {
				@Override
				public int compare(SungJukDTO o1, SungJukDTO o2) {
					return o1.getName().compareTo(o2.getName());
				}
			};
			Collections.sort(list, com); // ����Ʈ����x �Ͻ����������� ���� ������ comparator �̿��ؼ� sort
			System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���"); // printArticle(); ���� ȣ���ؼ� ����ϴ°͵� ����
			for(SungJukDTO dto : list) { 
				System.out.print(dto);
			}
		System.out.println();
		}
		if(num==2) { // �������� ��������
		Collections.sort(list); // sort�Լ��� �������� �ƴ϶� list��ü�� ���Ľ����� - ����Ʈ������ comparable��
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
			for(SungJukDTO dto : list) {
				System.out.print(dto);
			}
		System.out.println();
		}
		if(num==3) return;
	} // sort
	
} // class
