package constructor;

import java.io.IOException;

public class SalaryMain {

	public static void main(String[] args) throws IOException {
		SalaryDTO[] ar = new SalaryDTO[5];
		SalaryService service = new SalaryService(ar); //�ּҸ� �޾Ƽ� �����ϴ°�
		service.menu();
		System.out.println("���α׷��� �����մϴ�");
	}

}
