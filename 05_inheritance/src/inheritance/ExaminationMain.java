package inheritance; ////////// ���� �����

import java.util.Scanner;

public class ExaminationMain {	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�ο��� �Է� : "); // �Ѹ�� Ŭ���� �ϳ��̰� �������� ��� �迭 ���!
		int num = scan.nextInt();
		
		Examination[] ar = new Examination[num];
		
		for(int i=0; i<ar.length; i++) {
			ar[i]=new Examination();
			ar[i].compare();
		}
		
		System.out.println();
		System.out.println("�̸� \t1 2 3 4 5\t����");
		
		for(int j=0; j<ar.length; j++) {
		System.out.print(ar[j].getName()+"\t");
		for(int i=0; i<ar[j].getOx().length; i++) 
			System.out.print(ar[j].getOx()[i]+" ");
		System.out.println("\t"+ar[j].getScore());
		}
	}
}
