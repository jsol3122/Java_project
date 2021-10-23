package test;

import java.util.Scanner;

public class SalaryDTO {
	private String name, position;
	private int basePay, benefit, salary;
	private double taxRate;
	
	public SalaryDTO(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("-- <등록> --");
		System.out.print("이  름 : ");
		this.name=(scan.next());
		System.out.print("직  급 : ");
		this.position=(scan.next());
		System.out.print("기본급 : ");
		this.basePay=(scan.nextInt());
		System.out.print("수  당: ");
		this.benefit=(scan.nextInt());
		}
	
	public void setPosition(String position) {
		this.position=position;
	}
	public void setBasePay(int basePay) {
		this.basePay=basePay;
	}
	public void setBenefit(int benefit) {
		this.benefit=benefit;
	}
	
	public void calc() {
		int sum = basePay+benefit;
		
		if(sum<=2000000) taxRate=0.01;
		else if(sum<=4000000) taxRate=0.02;
		else taxRate=0.03;
		
		salary=(int)(sum-(sum*taxRate));
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
	public int getSalary() {
		return salary;
	}
	public double getTaxRate() {
		return taxRate;
	}
} // class
