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
			System.out.println("1.등록");
			System.out.println("2.출력");
			System.out.println("3.수정");
			System.out.println("4.검색");
			System.out.println("5.종료");
			System.out.println("-------");
			
			System.out.print(" 번호 : ");
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
		System.out.println("-- <출력> --");
		
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
		System.out.println("-- <수정> --");
		System.out.print("수정할 이름? ");
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
				System.out.print("직  급: ");
				dto[i].setPosition(scan.next());
				System.out.print("기본급: ");
				dto[i].setBasePay(scan.nextInt());
				System.out.print("수  당: ");
				dto[i].setBenefit(scan.nextInt());
				System.out.println();
				dto[i].calc();
				return;
			}
		}	
	} //update
	
	public void search() {
		System.out.println();
		System.out.println("-- <검색> --");
		System.out.print("검색할 이름? ");
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
