package collection;

public class SungJukMain {

	public static void main(String[] args) {
//		SungJukService service = new SungJukService();  -- list�̿� ���� (��� 1)
//		service.menu();
		
		SungJukServiceDB serviceDB = new SungJukServiceDB(); // DB�̿� ���� (��� 2)
		serviceDB.menu();
		System.out.println("���α׷��� �����մϴ�");
	}
}
