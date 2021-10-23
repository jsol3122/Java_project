package abstract_;  // ����޷� ���� �ؼ���

import java.util.Calendar;
import java.util.Scanner;

class CalendarTest2{
	private int year, month, week, lastDay;
	
	public CalendarTest2() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�⵵ �Է� : ");
		this.year = scan.nextInt();
		System.out.print("�� �Է� : ");
		this.month = scan.nextInt();
	} // ������
	
	public void calc() {
		Calendar cal = Calendar.getInstance();
		//cal.set(Calendar.YEAR, year); // ��
		//cal.set(cal.MONTH, month);	// ��
		//cal.set(cal.DAY_OF_MONTH, 1);// ��
		 cal.set(year, month-1, 1); // �̷��� �ϸ� ������(�� 3��) �ѹ��� �����
		
		week = cal.get(cal.DAY_OF_WEEK); // ���� ��������
		lastDay = cal.getActualMaximum(cal.DAY_OF_MONTH); // �ش� ���� �������� ���ϱ�
	} // calc()
	
	public void display() {
		System.out.println("��"+"\t"+"��"+"\t"+"ȭ"+"\t"+"��"+"\t"+"��"+"\t"+"��"+"\t"+"��");
		
		for(int i=1; i<week; i++) {
			System.out.print("\t");
		} // ���Ͽ� �°� 1�� �����ϰ�
		
		for(int i=1; i<=lastDay; i++) {
			System.out.print(i+"\t");
			
			if(week%7==0) System.out.println();
			week++;
		}
	} // display()
}

//-----------------------------------------
public class CalendarMain {

	public static void main(String[] args) {
		CalendarTest2 ct = new CalendarTest2();
		ct.calc();
		ct.display();

	}
}
