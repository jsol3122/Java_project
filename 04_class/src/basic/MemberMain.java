package basic;

import java.io.IOException;

public class MemberMain { // ���� ���ุ ��, �ٸ� Ŭ���� new�����ؼ� ���ุ�ϱ�

	public static void main(String[] args) throws IOException {  //menu()�Լ��� ȣ���
		MemberService service = new MemberService();
		service.menu();
		System.out.println("���α׷��� �����մϴ�.");
	}
}

