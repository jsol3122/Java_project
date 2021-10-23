package abstract_;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {
	Scanner scan = new Scanner(System.in);
	private int year, month, week, lastDay;
	
	//생성자 - 입력받기
	public CalendarTest(){
		System.out.print("년도 입력 : ");
		year = scan.nextInt();
		System.out.print("월 입력 : ");
		month = scan.nextInt();
		calc();
		display();
	}
	
	public void calc() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(year, month-1, 1);
		
		lastDay = cal.getActualMaximum(Calendar.DATE);
		week = cal.get(Calendar.DAY_OF_WEEK);
	}
	
	public void display() {
		System.out.println();
		System.out.println("일"+"\t"+"월"+"\t"+"화"+"\t"+"수"+"\t"+"목"+"\t"+"금"+"\t"+"토");
		
		for(int i=1; i<=lastDay; i++) {
			if(i==1) {
				for(int j=1; j<week; j++)
					System.out.print("\t");
			}
			System.out.print(i+"\t");
			
			if(week%7==0)
			System.out.println();
			
			week++;
		}
		System.out.println("\n");
		System.out.println("끝나는 일 : "+lastDay+"일");
	}
	
	//--------------------------------------------------
	public static void main(String[] args) {
		new CalendarTest();
	} //main
}
