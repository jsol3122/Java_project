package constructor;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SalaryService {
	Scanner scan = new Scanner(System.in);
	private SalaryDTO[] ar;
	DecimalFormat df = new DecimalFormat();
	private int i;
	// main.ar[i]
	public SalaryService(SalaryDTO[] ar) { //main���� �޾ƿ� ar�ּҸ� �Ȱ��� �޾��ֱ�
		this.ar=ar;	// ���� ar���� this�� �����ְ� this.ar���� main���� �޾ƿ� ar�� �����ؼ� ����
	}
	

	public void menu() throws IOException { //�⺻�� private���� - �ܺ�class���� ���پ��ҰŶ�� �����ص� ��
		for(;true;) {
			System.out.println("*****************");
			System.out.println("    1. ������");
			System.out.println("    2. ��ü ���");
			System.out.println("    3. ��� ���� ����");
			System.out.println("    4. ���");
			System.out.println("    5. ����");
			System.out.println("*****************");
			
			System.out.print("  ��ȣ : ");
			int num=System.in.read()-48;
			System.in.read();
			System.in.read();
			System.out.println();
			
				if(num==1) insertEmp();
				else if(num==2) display();
				else if(num==3) updateEmp();
				else if(num==4) deleteEmp();
				else if(num==5) break;
		}
	}  // menu()
	
	public void insertEmp() {
		
		if(i==ar.length) {	// 5�� ���� �� á���� �űԵ�� �Ұ�
			System.out.println("���� �ʰ�");
			return;
		}
		
		/* 	service���� ar[i]=new SalaryDTO(); �� �ҷ������� �ϰ���~~
		 *  DTO���� �ٷ� �޴� �� ����
		 *  ar[i].calcSalary();�� �ٷ� ������ �Ϸ��ص� ��
		 */
		
		for(i=0; i<ar.length; i++) {
			if(ar[i]==null) {
			System.out.print(" �����ȣ �Է� : ");
			int a=(scan.nextInt());
			System.out.print(" ����� �Է� : ");
			String b=(scan.next());
			System.out.print(" ���� �Է� : ");
			String c=(scan.next());
			System.out.print(" �⺻�� �Է� : ");
			int d=(scan.nextInt());
			System.out.print(" ���� �Է� : ");
			int e=(scan.nextInt());
			
			ar[i] = new SalaryDTO(a, b, c, d, e);
			break;
			}
		}
		System.out.println();
		System.out.println("��� �Ϸ�");
		System.out.println();
	} // insertEmp()
	
	public void display() {
		
		System.out.println("�����ȣ\t�̸�\t����\t�⺻��\t\t����\t����\t����\t����");
		for(i=0; i<ar.length; i++) {
			if(ar[i]!=null) {
			ar[i].clacSalary();
			System.out.println(ar[i].getEmpId()+"\t"
							+ar[i].getName()+"\t"
							+ar[i].getPosition()+"\t"
							+df.format(ar[i].getBasePay())+"\t"
							+df.format(ar[i].getBenefit())+"\t"
							+(int)(ar[i].getTaxRate()*100)+"%\t"
							+df.format(ar[i].getTax())+"\t"
							+df.format(ar[i].getSalary()));
			}
		}
		// decimalformat�� ���ڸ� �ޱ� ������ ���ڿ��� �ָ� ������
		System.out.println();
	} // display()
	
	public void updateEmp() {
		
		System.out.print("�����ȣ �Է� : ");
		int num = (scan.nextInt());
		System.out.println();
		
		for(i=0; i<ar.length; i++) {
			if(ar[i].getEmpId()==num) {
				System.out.println("�����ȣ\t�̸�\t����\t�⺻��\t\t����\t����\t����\t����");
				System.out.println(ar[i].getEmpId()+"\t"
						+ar[i].getName()+"\t"
						+ar[i].getPosition()+"\t"
						+df.format(ar[i].getBasePay())+"\t"
						+df.format(ar[i].getBenefit())+"\t"
						+(int)(ar[i].getTaxRate()*100)+"%\t"
						+df.format(ar[i].getTax())+"\t"
						+df.format(ar[i].getSalary()));
				
				System.out.println();
				System.out.print("������ ���� �Է� :");
				String a = (scan.next());
				System.out.print("������ �⺻�� �Է� :");
				int b = (scan.nextInt());
				System.out.print("������ ���� �Է� :");
				int c = (scan.nextInt());
				
				/*�����ؾ� �ϴµ� ������ �ι��� ���θ��ϱ� setter���� �����ϱ�
				public void setName(String name){ this.name.name;} ��� ����~~ 
				ar[i].setName(scan.next()); ���� �޾��ֱ�   ---> �ؾߵǴ� ��
				
				setter��� ������new�ؼ� �����, ������ �ƴ϶� ���ο�� ���� ��°Ŷ� 
				�����Ҷ����� �޸𸮰� ��Ӱ�� �ٽ� ������ ---> �����
				 */
				ar[i] = new SalaryDTO(ar[i].getEmpId(), ar[i].getName(), a, b, c);
				System.out.println("���� �Ϸ�");
				System.out.println();
				return;
			}
		}
	System.out.println("�����ȣ�� �����ϴ�");
	//if(i==ar.length){ System.out.prinln("�����ȣ����"); return;} ���� ��Ƶ� ��
	System.out.println();
	} // updateEmp()
	
	public void deleteEmp() { //java�� �����ڸ� ���� �� ����(JVM�� �˾Ƽ����� ��ų������)
		// ������ ������ ���ϰ� ������� �����ֱ�(=�ּҰ��� NULL�� ���) �׷��� ���߿� JVM�� �˾Ƽ� ����
		// NULLó���� �� for�� �ȿ��� �ش� ������ ������ break;��Ų �� for�� �ۿ��� ar[i]=null�ص� i�� �����ż� �� ������
		System.out.print("�����ȣ �Է� : ");
		int num = (scan.nextInt());
		System.out.println();
		
		for(i=0; i<ar.length; i++) {
			if(ar[i].getEmpId()==num) {
				ar[i]=null; // ����� �����ַ��� �ּҰ� NULL�� ��
				System.out.println("���� �Ϸ�");
				System.out.println();
				return;
			}
		}
		System.out.println("�����ȣ�� �����ϴ�");
		//if(i==ar.length){ System.out.prinln("�����ȣ����"); return;} ���� ��Ƶ� ��
		System.out.println();
	} // deleteEmp()
}
