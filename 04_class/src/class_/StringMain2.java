package class_;

import java.util.Scanner;

public class StringMain2 {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int cnt=0, i=0;
		
	System.out.print("���ڿ� �Է� : ");
	String a = scan.next();	//String a=scan.next().toLowerCase(); �� �ٷ� �ص� ����
	a=a.toLowerCase();
	
	System.out.print("���� ���ڿ� �Է� : ");
	String b = scan.next();
	b=b.toLowerCase();
	
	System.out.print("�ٲ� ���ڿ� �Է� : ");
	String c = scan.next();
	c=c.toLowerCase();
	
	while(true) {
		i=a.indexOf(b, i);
		if(i>=0) {cnt++;
		i+=b.length();}		
		else break;
	}
	
	/* �������ϱ⸦ �̷��� �� ���� ����
	int count= (a.length() - a.replace(b, "").length())/c.length();
      if(a.length()>a.replace(b, " ").length()) {
         System.out.println(d);
         System.out.println(count+"�� ġȯ");
      }
 
	---> ġȯ���� = (�� ���ڱ��� - ġȯ�ȵȱ��ڼ�)/ �ѹ��� ��ü�Ǵ� ���ڼ�
	 */

	if(a.length()<b.length()) {
		System.out.println("�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�");
		System.out.println("ġȯ�� �� �����ϴ�");
		return;
	}

	a=a.replace(b, c);
	System.out.println(a);
	System.out.println(cnt+"�� ġȯ");
	} // main
}
