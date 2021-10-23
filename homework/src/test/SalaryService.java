package test;

import java.util.Scanner;

public class SalaryService {
	Scanner scan = new Scanner(System.in);
	private SalaryDTO[] dto;
	private int i;
	
	
	public SalaryService(SalaryDTO[] dto) { 
		this.dto=dto;	
	}
	
	public void menu() {
		for(;true;) {
			System.out.println("1.���");
			System.out.println("2.���");
			System.out.println("3.����");
			System.out.println("4.�˻�");
			System.out.println("5.����");
			System.out.println("-------");
			
			System.out.print(" ��ȣ : ");
			int num=(scan.nextInt());
			
				if(num==1) insert();
				else if(num==2) list();
				else if(num==3) update();
				else if(num==4) search();
				else if(num==5) break;
		}
	} //menu
	
	public void insert() {
		for(i=0; i<dto.length; i++) {
			if(dto[i]==null) {
				dto[i]=new SalaryDTO();
				dto[i].calc();
				break;
			}
		}
		System.out.println();
	} //insert
	
	public void list() {
		System.out.println();
		System.out.println("-- <���> --");
		
		for(i=0; i<dto.length; i++) {
			if(dto[i]!=null) {
				System.out.println("\t"+dto[i].getName()+"\t"
						+dto[i].getPosition()+"\t"
						+dto[i].getBasePay()+"\t"
						+dto[i].getBenefit()+"\t"
						+dto[i].getTaxRate()+"\t"
						+dto[i].getSalary()+"\t");
			}
		}
		System.out.println();
	} //list
	
	public void update() {
		System.out.println();
		System.out.println("-- <����> --");
		System.out.print("������ �̸�? ");
		String n = (scan.next());
		
		for(i=0; i<dto.length; i++) {
			if(dto[i].getName().equals(n)) {
				System.out.println("\t"+dto[i].getName()+"\t"
						+dto[i].getPosition()+"\t"
						+dto[i].getBasePay()+"\t"
						+dto[i].getBenefit()+"\t"
						+dto[i].getTaxRate()+"\t"
						+dto[i].getSalary()+"\t");
				
				System.out.println();
				System.out.print("��  ��: ");
				dto[i].setPosition(scan.next());
				System.out.print("�⺻��: ");
				dto[i].setBasePay(scan.nextInt());
				System.out.print("��  ��: ");
				dto[i].setBenefit(scan.nextInt());
				System.out.println();
				dto[i].calc();
				return;
			}
		}	
	} //update
	
	public void search() {
		System.out.println();
		System.out.println("-- <�˻�> --");
		System.out.print("�˻��� �̸�? ");
		String n = (scan.next());
		
		for(i=0; i<dto.length; i++) {
			if(dto[i].getName().equals(n)) {
				System.out.println("\t"+dto[i].getName()+"\t"
						+dto[i].getPosition()+"\t"
						+dto[i].getBasePay()+"\t"
						+dto[i].getBenefit()+"\t"
						+dto[i].getTaxRate()+"\t"
						+dto[i].getSalary()+"\t");
				System.out.println();
				break;
			}
		}
	} //search
} // class
