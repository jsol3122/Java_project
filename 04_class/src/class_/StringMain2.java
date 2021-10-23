package class_;

import java.util.Scanner;

public class StringMain2 {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int cnt=0, i=0;
		
	System.out.print("문자열 입력 : ");
	String a = scan.next();	//String a=scan.next().toLowerCase(); 로 바로 해도 가능
	a=a.toLowerCase();
	
	System.out.print("현재 문자열 입력 : ");
	String b = scan.next();
	b=b.toLowerCase();
	
	System.out.print("바꿀 문자열 입력 : ");
	String c = scan.next();
	c=c.toLowerCase();
	
	while(true) {
		i=a.indexOf(b, i);
		if(i>=0) {cnt++;
		i+=b.length();}		
		else break;
	}
	
	/* 개수구하기를 이렇게 할 수도 있음
	int count= (a.length() - a.replace(b, "").length())/c.length();
      if(a.length()>a.replace(b, " ").length()) {
         System.out.println(d);
         System.out.println(count+"번 치환");
      }
 
	---> 치환개수 = (원 글자길이 - 치환안된글자수)/ 한번당 교체되는 글자수
	 */

	if(a.length()<b.length()) {
		System.out.println("입력한 문자열의 크기가 작습니다");
		System.out.println("치환할 수 없습니다");
		return;
	}

	a=a.replace(b, c);
	System.out.println(a);
	System.out.println(cnt+"번 치환");
	} // main
}
