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
		System.out.println("���� ��¥ : "+date); //�ý��۳�¥ �״�� ���
		System.out.println();
		
		SimpleDateFormat sdf = new SimpleDateFormat("y�� MM�� dd�� E���� HH:mm:ss"); //��������
		System.out.println("���� ��¥ : "+sdf.format(date)); // ������ ���Ĵ�� ���
		System.out.println();
		
		// �Է�
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss"); // ��ȣ���� ���� ����
		Date birth = input.parse("19910716091527"); 
		// String�������� �ԷµǴ�, Date�������� �ٲ����(����ȯ) dateformat ���밡�� / scanner�� �޾Ƶ� ��
		System.out.println("������ : "+birth); // �⺻ ��¥����
		System.out.println("������ : "+sdf.format(birth)); // ������ ����
		System.out.println();
		
		//Calendar cal = new Calendar(); // �߻�Ŭ������ new���� �Ұ���
		//Calendar cal = new GregorianCalendar(); // �ڽ�Ŭ���� �̿�
		Calendar cal = Calendar.getInstance(); // �޼ҵ� �̿� - ���ٸ� ���� ���ָ� �����ð� ����
		
		//Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Canada/Pacific")); // Ư������ �ð�
		
		int year = cal.get(Calendar.YEAR); // ���ȭ���Ѽ� �˾ƺ��� ���� ��
		//int year = cal.get(1); --> �̰͵� ���� ���������, �̰͸� ���� �˾ƺ��� �����
		int month = cal.get(Calendar.MONTH)+1; // ���� 0������ �����ϱ� ������ +1�ؼ� ���������
		int day = cal.get(Calendar.DAY_OF_MONTH); 
		
		int week = cal.get(Calendar.DAY_OF_WEEK); // �Ͽ���=1 ���� ����
		String dayOfWeek=null;
		switch(week) {
		case 1 : dayOfWeek = "��";break;
		case 2 : dayOfWeek = "��";break;
		case 3 : dayOfWeek = "ȭ";break;
		case 4 : dayOfWeek = "��";break;
		case 5 : dayOfWeek = "��";break;
		case 6 : dayOfWeek = "��";break;
		case 7 : dayOfWeek = "��";break;
		}
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println("���� ��¥ : "+year+"��"+
						month +"�� "+
						day +"�� "+
						dayOfWeek +"���� "+
						hour +"�� "+
						minute +"�� "+
						second +"��");
		
		
		
	} //main
}
