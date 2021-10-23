package abstract_;  // 만년달력 숙제 해설본

import java.util.Calendar;
import java.util.Scanner;

class CalendarTest2{
	private int year, month, week, lastDay;
	
	public CalendarTest2() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("년도 입력 : ");
		this.year = scan.nextInt();
		System.out.print("월 입력 : ");
		this.month = scan.nextInt();
	} // 생성자
	
	public void calc() {
		Calendar cal = Calendar.getInstance();
		//cal.set(Calendar.YEAR, year); // 연
		//cal.set(cal.MONTH, month);	// 월
		//cal.set(cal.DAY_OF_MONTH, 1);// 일
		 cal.set(year, month-1, 1); // 이렇게 하면 연월일(위 3줄) 한번에 다찍기
		
		week = cal.get(cal.DAY_OF_WEEK); // 요일 가져오기
		lastDay = cal.getActualMaximum(cal.DAY_OF_MONTH); // 해당 달의 마지막일 구하기
	} // calc()
	
	public void display() {
		System.out.println("일"+"\t"+"월"+"\t"+"화"+"\t"+"수"+"\t"+"목"+"\t"+"금"+"\t"+"토");
		
		for(int i=1; i<week; i++) {
			System.out.print("\t");
		} // 요일에 맞게 1일 시작하게
		
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
