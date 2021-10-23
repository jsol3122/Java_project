package abstract_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Today {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println("오늘 날짜 : "+date); //시스템날짜 그대로 출력
		System.out.println();
		
		SimpleDateFormat sdf = new SimpleDateFormat("y년 MM월 dd일 E요일 HH:mm:ss"); //형식지정
		System.out.println("오늘 날짜 : "+sdf.format(date)); // 지정한 형식대로 출력
		System.out.println();
		
		// 입력
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss"); // 기호없이 형식 지정
		Date birth = input.parse("19910716091527"); 
		// String형식으로 입력되니, Date형식으로 바꿔줘야(형변환) dateformat 적용가능 / scanner로 받아도 됨
		System.out.println("내생일 : "+birth); // 기본 날짜형식
		System.out.println("내생일 : "+sdf.format(birth)); // 지정한 형식
		System.out.println();
		
		//Calendar cal = new Calendar(); // 추상클래스라서 new생성 불가능
		//Calendar cal = new GregorianCalendar(); // 자식클래스 이용
		Calendar cal = Calendar.getInstance(); // 메소드 이용 - 별다른 설정 안주면 현지시간 기준
		
		//Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Canada/Pacific")); // 특정지역 시간
		
		int year = cal.get(Calendar.YEAR); // 상수화시켜서 알아보기 쉽게 함
		//int year = cal.get(1); --> 이것도 연도 출력이지만, 이것만 보고 알아보기 어려움
		int month = cal.get(Calendar.MONTH)+1; // 월은 0월부터 시작하기 때문에 +1해서 맞춰줘야함
		int day = cal.get(Calendar.DAY_OF_MONTH); 
		
		int week = cal.get(Calendar.DAY_OF_WEEK); // 일요일=1 에서 시작
		String dayOfWeek=null;
		switch(week) {
		case 1 : dayOfWeek = "일";break;
		case 2 : dayOfWeek = "월";break;
		case 3 : dayOfWeek = "화";break;
		case 4 : dayOfWeek = "수";break;
		case 5 : dayOfWeek = "목";break;
		case 6 : dayOfWeek = "금";break;
		case 7 : dayOfWeek = "토";break;
		}
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println("오늘 날짜 : "+year+"년"+
						month +"월 "+
						day +"일 "+
						dayOfWeek +"요일 "+
						hour +"시 "+
						minute +"분 "+
						second +"초");
		
		
		
	} //main
}
