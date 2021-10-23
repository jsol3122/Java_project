package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SungJukServiceDB { // SungJuk�� DB�����ؼ� �����ϴ� ��� - ������ list���� �����ؼ� �ܼ�â���� �Ҹ�
	Scanner scan = new Scanner(System.in);
	private List<SungJukDTO> list; // list�� select���� �����
	
	public SungJukServiceDB() {
		list = new ArrayList<SungJukDTO>();
	}
	
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


	private void insertArticle() {
		SungJukDTO dto = new SungJukDTO();
		SungJukDAO dao = new SungJukDAO();
		
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
		dao.insertArticle(dto);
	} // insert
	
	private void printArticle() {
		System.out.println();
		SungJukDAO dao = new SungJukDAO();
		List<SungJukDTO> list = dao.printArticle();
	
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		for(SungJukDTO dto : list) {
			System.out.print(dto);
		}
		System.out.println();
	} // print
	
	private void searchArticle() {
		SungJukDAO dao = new SungJukDAO();
		System.out.println();
		System.out.print("�˻��� ��ȣ �Է� : ");
		int n = scan.nextInt();
		
		SungJukDTO dto = dao.searchArticle(n); // ��ȣ�� �ߺ��Ұ��ϱ� 1�ٸ� �������״� 1�κ�dto�� �޾ƿ�
		if(dto!=null) {
			System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
			System.out.println(dto);
		}else System.out.println("�ش� ��ȣ�� �������� �ʽ��ϴ�");
	} // search
	
	private void deleteArticle() {
		SungJukDAO dao = new SungJukDAO();
		System.out.println();
		System.out.print("������ ��ȣ �Է� : "); // ���������� ���� �� �����Ƿ� �̸����ٴ� ��ȣ������ ����
		int n = scan.nextInt();
		
		int su = dao.deleteArticle(n);
		if(su==0) System.out.println("�ش� ��ȣ�� �������� �ʽ��ϴ�");
		else System.out.println("���� �Ϸ�");
		System.out.println();
	} // delete
	
	private void sortArticle() { // Comparabe, Comparator�� java������ ��� (DB�϶� X)
		SungJukDAO dao = new SungJukDAO();
		System.out.println();
		System.out.println("*********************");
		System.out.print("1. �̸����� ��������\r\n"
				+ "2. �������� ��������\r\n"
				+ "3. �����޴�\r\n");
		System.out.println("*********************");
		System.out.print(" ��ȣ �Է� : ");
		int num = scan.nextInt();
		System.out.println();
		
		if(num==3) return;
		List<SungJukDTO> list = dao.sortArticle(num);
		
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		 for(SungJukDTO dto : list) {
			 System.out.print(dto);
		 }
		System.out.println();
	} // sort
	
} // class
