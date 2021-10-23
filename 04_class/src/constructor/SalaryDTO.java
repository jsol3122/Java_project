package constructor;

public class SalaryDTO {

	private int empId, basePay, benefit, tax, salary;
	private String name, position;
	private double taxRate;
	
	// 생성자
	public SalaryDTO(int empId, String name,String position, int basePay, int benefit) {
		this.empId=empId;
		this.name=name;
		this.position=position;
		this.basePay=basePay;
		this.benefit=benefit;
	}
	
	/*	service에서 받아서 전달하지 않고 여기서 바로 받아도 됨
	 * 	service에서 ar[i]=new SalaryDTO(); 로 불러오도록 하고나서~~
	 *  DTO에서 바로 받는 식 쓰기
	public SalaryDTO(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print(" 사원번호 입력 : ");
			empId=(scan.nextInt());
			System.out.print(" 사원명 입력 : ");
			name=(scan.next());
			System.out.print(" 직급 입력 : ");
			position=(scan.next());
			System.out.print(" 기본급 입력 : ");
			basePay=(scan.nextInt());
			System.out.print(" 수당 입력 : ");
			benefit=(scan.nextInt());
			
		}
	 */
	
	// 계산 - basePay+benefit을 total로 식을 만들어놓고 연산해도 됨
	public void clacSalary() {
		if(basePay+benefit<=2000000)
			taxRate=0.01;
		else if(basePay+benefit<=4000000)
			taxRate=0.02;
		else taxRate=0.03;
		tax=(int)((basePay+benefit)*taxRate);
		salary=basePay+benefit-tax;
	}
	
	// getter
	public int getEmpId() {
		return empId;
	}
	public String getName() {
		return name;
	}
	public String getPosition() {
		return position;
	}
	public int getBasePay() {
		return basePay;
	}
	public int getBenefit() {
		return benefit;
	}
	public double getTaxRate() {
		return taxRate;
	}
	public int getTax() {
		return tax;
	}
	public int getSalary() {
		return salary;
	}
}
