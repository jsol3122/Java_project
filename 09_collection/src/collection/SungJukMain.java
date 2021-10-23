package collection;

public class SungJukMain {

	public static void main(String[] args) {
//		SungJukService service = new SungJukService();  -- list이용 저장 (방법 1)
//		service.menu();
		
		SungJukServiceDB serviceDB = new SungJukServiceDB(); // DB이용 저장 (방법 2)
		serviceDB.menu();
		System.out.println("프로그램을 종료합니다");
	}
}
