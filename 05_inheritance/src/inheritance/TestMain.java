package inheritance;


class Test{
	int a,b;
}
//-----------------------------------------
public class TestMain {

	public static void main(String[] args) {
		Test aa = new Test(); // new로 생성하면 주소값만 받음
		Test bb = aa; // new로 생성해서 받은 클래스의 주소값을 다시 받은 것(클래스 자체x)
		aa.a=2;
		aa.b=5;
		System.out.println(aa.a+"\t"+aa.b); // 2 5
		System.out.println(bb.a+"\t"+bb.b); // 2 5
		System.out.println();
		
		bb.a=7;
		bb.b=9;
		System.out.println(aa.a+"\t"+aa.b); // 7 9
		System.out.println(bb.a+"\t"+bb.b); // 7 9
		System.out.println();
		
		bb = new Test(); // bb에 있던 저번에 받은 aa의 주소가 사라지고 새로운 new로 생성한 주소 받음
		bb.a=10;
		bb.b=20;
		System.out.println(aa.a+"\t"+aa.b); // 7 9
		System.out.println(bb.a+"\t"+bb.b); // 10 20
	}
}
