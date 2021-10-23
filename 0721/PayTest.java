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

		System.out.println("*** "+name+"의 월급 ***");
		System.out.println("기본급 : "+decimalFormat.format(basePay)+"원");
		System.out.println("세금	: "+decimalFormat.format(tax)+"원");
		System.out.println("월급	: "+decimalFormat.format(salary)+"원");


	}
}
