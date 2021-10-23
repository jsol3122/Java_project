package test;

public class SalaryMain {

	public static void main(String[] args) {
		SalaryDTO[] dto = new SalaryDTO[5];
		SalaryService sal = new SalaryService(dto);
		sal.menu();
		System.out.println("종료합니다.");
	}
}
