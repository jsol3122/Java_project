package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberService { //일하는 집합 (객체생성, 데이터넣기, 데이터출력, 데이터수정 등 모든 일들), menu()함수~탈퇴함수 다하기
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int num, count=0;
	
	MemberDTO[] dto = new MemberDTO[5];
	
	public void menu() throws IOException {	//구현부에 IOException이 걸렸으면 호출부에도 걸어줘야함
		
	for(;true;) {
		System.out.println("*****************");
		System.out.println("    1. 가입");
		System.out.println("    2. 출력");
		System.out.println("    3. 수정");
		System.out.println("    4. 탈퇴");
		System.out.println("    5. 끝내기");
		System.out.println("*****************");
		
		System.out.print("  번호 : ");
		num=System.in.read()-48;
		System.in.read();
		System.in.read();
		System.out.println();
		
			if(num==1) insertMember();
			else if(num==2) list();
			else if(num==3) updateMember();
			else if(num==4) deleteMember();
			else if(num==5) break;
	}
	} // menu()
	
	public void insertMember() throws IOException {
		/*   이렇게 애초에 null이면 배열생성을 안해버릴수도 있음 
	 		->그러면 뒤에 dto[i].getName()==null 이런식으로 안하고 dto[i]==null 이런식으로도 사용 가능
	int i;
    for(i=0; i<ar.length; i++) {
      if(ar[i]==null) break;
    }
      
  if(i==ar.length) {
     System.out.println("정원 초과..");
     return; //메소드를 벗어나라
  }
  
  ar[i] = new MemberDTO();

		 */
	
	for(int i=0; i<dto.length; i++) {
	if(count>0)break;
	dto[i] = new MemberDTO();
	}
	
	for(int i=0; i<dto.length; i++) {
		if(count==5) { System.out.println("정원 초과");
			return;
		}
		if(dto[i].getName()==null) {
			System.out.print("이름 입력 : ");
			dto[i].setName(br.readLine());
			System.out.print("나이 입력 : ");
			dto[i].setAge(Integer.parseInt(br.readLine()));
			System.out.print("핸드폰 입력 : ");
			dto[i].setCellphone(br.readLine());
			System.out.print("주소 입력 : ");
			dto[i].setAddress(br.readLine());
			break;
		}
	}
	count++;
	System.out.println("등록 완료 / "+(5-count)+"자리 남았습니다");
	System.out.println();
	// menu();  이렇게 부르면 신규 menu()가 계속 새로 생기니까 하지 말기!!
	} // insertMember()
	
	public void list() throws IOException {

	System.out.println("이름\t나이\t핸드폰\t주소");
		for(int i=0; i<dto.length; i++) {
			if(dto[i].getName()!=null) {
			System.out.println(dto[i].getName()+"\t"
							+dto[i].getAge()+"\t"
							+dto[i].getCellphone()+"\t"
							+dto[i].getAddress());
			}
		}
	System.out.println();
		
	/*	애초에 null은 배열생성 안한 경우
	System.out.println();
      System.out.println("이름\t나이\t핸드폰\t\t주소");
      for(int i=0; i<dto.length; i++) {
         if(dto[i]!=null) {
            System.out.println(dto[i].getName()+"\t"
                         + dto[i].getAge()+"\t"
                         + dto[i].getCellphone()+"\t"
                         + dto[i].getAddress());
         }
      }
	*/
	} // list()
	
	public void updateMember() throws IOException {
	
	String cnum;
	System.out.print("핸드폰 번호 입력 : ");
	cnum=br.readLine();
	for(int i=0; i<dto.length; i++) {
		if(cnum.equals(dto[i].getCellphone())) {
			System.out.println(dto[i].getName()+"\t"
					+dto[i].getAge()+"\t"
					+dto[i].getCellphone()+"\t"
					+dto[i].getAddress());
			System.out.println();
			System.out.print("수정할 이름 입력 : ");
			dto[i].setName(br.readLine());
			System.out.print("수정할 나이 입력 : ");
			dto[i].setAge(Integer.parseInt(br.readLine()));
			System.out.print("수정할 핸드폰 입력 : ");
			dto[i].setCellphone(br.readLine());
			System.out.print("수정할 주소 입력 : ");
			dto[i].setAddress(br.readLine());
			System.out.println();
			System.out.println("수정 완료");
			return;
		}
	} 
	System.out.println("찾고자 하는 회원이 없습니다");
	System.out.println();
	} // updateMember()
	
	public void deleteMember() throws IOException {

	String cnum;
	System.out.print("핸드폰 번호 입력 : ");
	cnum=br.readLine();
		for(int i=0; i<dto.length; i++) {
			if(cnum.equals(dto[i].getCellphone())) {
				dto[i].setName(null);
				dto[i].setAge(0);
				dto[i].setCellphone(null);
				dto[i].setAddress(null);
				System.out.println("삭제 완료");
				System.out.println();
				count--;
				return;
			}
		}
	System.out.println("찾고자 하는 회원이 없습니다");
	System.out.println();
	
	/*	애초에 null은 배열생성 안한 경우
		
	System.out.print("핸드폰 번호 입력 : ");
      String phone = br.readLine();
      
      int i;
      for(i=0; i<dto.length; i++) {
         if(dto[i] != null) {
            if(dto[i].getCellphone().equals(phone)) break;
         }//if
      }//for
      
      if(i==dto.length) {
         System.out.println("찾고자 하는 회원이 없습니다");
         
      }else {
    	  dto[i] = null;
         System.out.println("탈퇴 완료...");
      }
	*/
	} // deleteMember()
}

