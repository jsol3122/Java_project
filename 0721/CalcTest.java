class CalcTest
{
	public static void main(String[] args) 
	{
		short a = 320;
		short b = 258;
		int sum = a + b;
		int sub = a - b;
		int mul = a * b;
		double div = (double)a / b;
		System.out.println(a + " + " + b + " = " + sum);
		System.out.println(a + " - " + b + " = " + sub);
		System.out.println(a + " * " + b + " = " + mul);
		System.out.println(a + " / " + b + " = " + String.format("%.2f", div));
		System.out.printf("%d / %d = %.2f\n", a, b, div);
	}
}
