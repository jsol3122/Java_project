package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SungJukService {
	Scanner scan = new Scanner(System.in);
	private List<SungJukDTO> list; // 다형성 이용해서 부모클래스 참조해서 자식클래스 생성하는것이 효율적
	
	
	public SungJukService() {
		list = new ArrayList<SungJukDTO>();
	} // 생성자
	
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
	
	public void insertArticle() {
		SungJukDTO dto = new SungJukDTO();
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
		list.add(dto);
	} // insert
	
	public void printArticle() {
		System.out.println();
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for(SungJukDTO dto : list) {
			System.out.print(dto);
		}
		System.out.println();
	} // print
	
	public void searchArticle() {
		int cnt=0, c=0;
		System.out.println();
		System.out.print("검색할 이름 입력 : ");
		String n = scan.next();
		for(SungJukDTO dto : list) {	
			if(dto.getName().compareTo(n)==0) {
				if(c==0) {
					System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
					c++;
				}
			System.out.print(dto);
			cnt++;
			} // if
		}
		if(cnt==0) System.out.println("찾고자 하는 이름이 없습니다");
		System.out.println();
	} // search
	
	// 삭제할 이름으로 list삭제하면 index번호가 달라지니까, iterator이용해서 index번호가 아닌 값 자체를 지정하도록 설정해서 삭제
	public void deleteArticle() { 
		System.out.println();
		int size = list.size();
		
		System.out.print("삭제할 이름 입력 : ");
		String n = scan.next();
		
		for(Iterator<SungJukDTO> it = list.iterator(); it.hasNext();) {	
			SungJukDTO dto = it.next(); // iterator로 꺼낸 데이터를 dto에 잠깐 담아놓고 next로 이동
			if(dto.getName().compareTo(n)==0) {
				it.remove(); // it가 가르키는 현재위치를 지우는 것x 위에서 꺼내둔 dto 지우는것임
			}
		} 
		if(size!=list.size()) System.out.println("데이터를 삭제하였습니다");
		if(size==list.size()) System.out.println("동일한 이름을 찾지 못하였습니다");
		System.out.println();
	} // delete
	
	public void sortArticle() {
		System.out.println();
		System.out.print("1. 이름으로 오름차순\r\n"
				+ "2. 총점으로 내림차순\r\n"
				+ "3. 이전메뉴\r\n");
		System.out.print(" 번호 입력 : ");
		int num = scan.nextInt();
		
		if(num==1) { // 이름으로 오름차순
			Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() {
				@Override
				public int compare(SungJukDTO o1, SungJukDTO o2) {
					return o1.getName().compareTo(o2.getName());
				}
			};
			Collections.sort(list, com); // 디폴트기준x 일시적기준으로 새로 설정한 comparator 이용해서 sort
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균"); // printArticle(); 으로 호출해서 출력하는것도 가능
			for(SungJukDTO dto : list) { 
				System.out.print(dto);
			}
		System.out.println();
		}
		if(num==2) { // 총점으로 내림차순
		Collections.sort(list); // sort함수는 지정값뿐 아니라 list자체를 정렬시켜줌 - 디폴트기준이 comparable임
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
			for(SungJukDTO dto : list) {
				System.out.print(dto);
			}
		System.out.println();
		}
		if(num==3) return;
	} // sort
	
} // class
