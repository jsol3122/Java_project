import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.text.DecimalFormat;

class Salary {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat decimalFormat = new DecimalFormat();

		Salary sr = new Salary();

		System.out.print("�̸� �Է� : ");
		String a = br.readLine();
		System.out.print("���� �Է� : ");
		String b = br.readLine();
		System.out.print("�⺻�� �Է� : ");
		int c = Integer.parseInt(br.readLine());
		System.out.print("���� �Է� : ");
		int d = Integer.parseInt(br.readLine());

		int e = c+d;
		double f = e>=4000000 ? 0.3 : 0.2;	
		int g = sr.calcTax(e, f);
		int h = sr.calcSalary(e, g);
		
		System.out.println("\t*** "+a+" ���� ���� ***");
		System.out.println("���� : "+b);
		System.out.println("�⺻��\t\t����\t\t�޿�\t\t����\t\t����\t\t����");
		System.out.println(decimalFormat.format(c)+"\t"+decimalFormat.format(d)+"\t\t"+decimalFormat.format(e)+"\t"+(int)(f*10)+"%"+"\t"+decimalFormat.format(g)+"\t"+decimalFormat.format(h));

		} //main

	public int calcTax(int e, double f){
		return (int)(e*f);
		} 

	public int calcSalary(int e, int calcTax){
		return e-calcTax;
		} 

		
}
