package constructor;

public class SalaryDTO {

	private int empId, basePay, benefit, tax, salary;
	private String name, position;
	private double taxRate;
	
	// ������
	public SalaryDTO(int empId, String name,String position, int basePay, int benefit) {
		this.empId=empId;
		this.name=name;
		this.position=position;
		this.basePay=basePay;
		this.benefit=benefit;
	}
	
	/*	service���� �޾Ƽ� �������� �ʰ� ���⼭ �ٷ� �޾Ƶ� ��
	 * 	service���� ar[i]=new SalaryDTO(); �� �ҷ������� �ϰ���~~
	 *  DTO���� �ٷ� �޴� �� ����
	public SalaryDTO(){
		Scanner scan = new Scanner(System.in);
		
		System.out.print(" �����ȣ �Է� : ");
			empId=(scan.nextInt());
			System.out.print(" ����� �Է� : ");
			name=(scan.next());
			System.out.print(" ���� �Է� : ");
			position=(scan.next());
			System.out.print(" �⺻�� �Է� : ");
			basePay=(scan.nextInt());
			System.out.print(" ���� �Է� : ");
			benefit=(scan.nextInt());
			
		}
	 */
	
	// ��� - basePay+benefit�� total�� ���� �������� �����ص� ��
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
