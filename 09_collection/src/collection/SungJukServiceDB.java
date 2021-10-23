package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SungJukServiceDB { // SungJuk을 DB연동해서 저장하는 방식 - 이전엔 list에만 저장해서 콘솔창끄면 소멸
	Scanner scan = new Scanner(System.in);
	private List<SungJukDTO> list; // list는 select에서 사용함
	
	public SungJukServiceDB() {
		list = new ArrayList<SungJukDTO>();
	}
	
	public void menu() {
		for(;true;) {
		System.out.print("*****************\r\n"
				+ "   1. 입력\r\n"
				+ "   2. 출력\r\n"
				+ "   3. 검색\r\n"
				+ "   4. 삭제\r\n"
				+ "   5. 정렬\r\n"
				+ "   6. 끝\r\n"
				+ "*****************\r\n");
		System.out.print(" 번호 : ");
		int n = scan.nextInt();
		
		if(n==1) insertArticle();
		if(n==2) printArticle();
		if(n==3) searchArticle();
		if(n==4) deleteArticle();
		if(n==5) sortArticle();
		if(n==6) return;
		else if(n>6) System.out.println("1~6 중에 선택하세요 \n");
		}
	} // menu


	private void insertArticle() {
		SungJukDTO dto = new SungJukDTO();
		SungJukDAO dao = new SungJukDAO();
		
		System.out.println();
		System.out.print("번호 입력 : ");
		dto.setNum(scan.nextInt());
		System.out.print("이름 입력 : ");
		dto.setName(scan.next());
		System.out.print("국어 입력 : ");
		dto.setKor(scan.nextInt());
		System.out.print("영어 입력 : ");
		dto.setEng(scan.nextInt());
		System.out.print("수학 입력 : ");
		dto.setMath(scan.nextInt());
		
		System.out.println();
		System.out.println("등록 완료");
		System.out.println();
		
		dto.calc();
		dao.insertArticle(dto);
	} // insert
	
	private void printArticle() {
		System.out.println();
		SungJukDAO dao = new SungJukDAO();
		List<SungJukDTO> list = dao.printArticle();
	
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for(SungJukDTO dto : list) {
			System.out.print(dto);
		}
		System.out.println();
	} // print
	
	private void searchArticle() {
		SungJukDAO dao = new SungJukDAO();
		System.out.println();
		System.out.print("검색할 번호 입력 : ");
		int n = scan.nextInt();
		
		SungJukDTO dto = dao.searchArticle(n); // 번호는 중복불가니까 1줄만 가져올테니 1인분dto에 받아옴
		if(dto!=null) {
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
			System.out.println(dto);
		}else System.out.println("해당 번호가 존재하지 않습니다");
	} // search
	
	private void deleteArticle() {
		SungJukDAO dao = new SungJukDAO();
		System.out.println();
		System.out.print("삭제할 번호 입력 : "); // 동명이인이 있을 수 있으므로 이름보다는 번호삭제가 좋음
		int n = scan.nextInt();
		
		int su = dao.deleteArticle(n);
		if(su==0) System.out.println("해당 번호가 존재하지 않습니다");
		else System.out.println("삭제 완료");
		System.out.println();
	} // delete
	
	private void sortArticle() { // Comparabe, Comparator는 java에서만 사용 (DB일땐 X)
		SungJukDAO dao = new SungJukDAO();
		System.out.println();
		System.out.println("*********************");
		System.out.print("1. 이름으로 오름차순\r\n"
				+ "2. 총점으로 내림차순\r\n"
				+ "3. 이전메뉴\r\n");
		System.out.println("*********************");
		System.out.print(" 번호 입력 : ");
		int num = scan.nextInt();
		System.out.println();
		
		if(num==3) return;
		List<SungJukDTO> list = dao.sortArticle(num);
		
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		 for(SungJukDTO dto : list) {
			 System.out.print(dto);
		 }
		System.out.println();
	} // sort
	
} // class
