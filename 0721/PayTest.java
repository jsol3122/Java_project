import java.text.DecimalFormat;

class PayTest 
{
	public static void main(String[] args) 
	{
		char name = 'L';
		int basePay = 2500000;
		int tax = (int)(basePay*0.033);
		int salary = basePay - tax;
		DecimalFormat decimalFormat = new DecimalFormat();

		System.out.println("*** "+name+"�� ���� ***");
		System.out.println("�⺻�� : "+decimalFormat.format(basePay)+"��");
		System.out.println("����	: "+decimalFormat.format(tax)+"��");
		System.out.println("����	: "+decimalFormat.format(salary)+"��");


	}
}
