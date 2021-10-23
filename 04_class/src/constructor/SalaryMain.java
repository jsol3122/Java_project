package constructor;

import java.io.IOException;

public class SalaryMain {

	public static void main(String[] args) throws IOException {
		SalaryDTO[] ar = new SalaryDTO[5];
		SalaryService service = new SalaryService(ar); //주소를 받아서 전달하는것
		service.menu();
		System.out.println("프로그램을 종료합니다");
	}

}
