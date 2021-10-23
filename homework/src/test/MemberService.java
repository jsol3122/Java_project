package test;

import java.util.List;
import java.util.Scanner;

public class MemberService {
	Scanner scan = new Scanner(System.in);
	
	public MemberService() {
		
	} // 생성자
	
	public void menu() {
		while(true) {
			System.out.println();
			System.out.println("*****************\r\n"
					+ "1. 회원가입\r\n"
					+ "2. 로그인\r\n"
					+ "3. 회원 리스트\r\n"
					+ "4. 끝\r\n"
					+ "*****************");
			System.out.print("번호 : ");
			int num = scan.nextInt();
			
			if(num==4) break;
			if(num>4) {
				System.out.println("1~4 중에 선택하세요\n");
				continue;
			}else if(num==1) writeMember();
			else if(num==2) loginMember();
			else if(num==3) listMember();			
		} // while
	} // menu()
	
	public void writeMember() {
		
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		
		MemberDTO dto = new MemberDTO();
		// 싱글톤으로 DAO 불러내기 -- 원래 DB는 쓸때마다 new하지 않고 하나만들어서 계속써야하니까
		MemberDAO dao = MemberDAO.getInstance(); 
		String yn = dao.checkMember(id); // id중복체크니까 id만 가져가서 확인해도 됨
		
		if(yn!=null) {
			System.out.println();
			System.out.println("이미 사용중인 아이디입니다");
			return;
		}else if(yn==null){ // "사용가능아이디" 제외 나머지부분은 else문 밖에다 써도 됨
			dto.setName(name);
			dto.setId(id);
			System.out.println("사용 가능한 아이디입니다");
			System.out.print("비밀번호 입력 : ");
			dto.setPwd(scan.next());
			System.out.print("이메일 입력 : ");
			dto.setMail(scan.next());
			dao.insertMember(dto);
			System.out.println();
			System.out.println("회원가입을 축하합니다");
		}
	} // writeMember()
	
	public void loginMember() {
		System.out.println();
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		System.out.print("비밀번호 입력 : ");
		String pwd = scan.next();
		System.out.println();
		
		MemberDAO dao = new MemberDAO();
		String name = dao.loginMember(id, pwd);
		
		if(name==null) System.out.println("이이디 또는 비밀번호가 맞지 않습니다");
		else System.out.println(name+"님 로그인");
	} // loginMember()
	
	public void listMember() {
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.listMember();
		
		System.out.println("이름\t아이디\t비밀번호\t이메일");
		for(MemberDTO dto : list) {
			System.out.print(dto);
		}
	} // listMember()
}
