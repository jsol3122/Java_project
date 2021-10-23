package inheritance;

class AA {
	public int a = 3;
	
	public void disp() {
		a+=5;
		System.out.println("AA : "+a+" ");
	}
}
//----------------------------------------------------------
class BB extends AA {
	public int a =8;
	
	public void disp() {
		this.a += 5;
		System.out.println("BB : "+a+" ");
	}
}
//----------------------------------------------------------
public class TestMain2 {

	public static void main(String[] args) {
		BB aa = new BB();
		aa.disp(); // BB : 13
		System.out.println("aa : "+aa.a); // aa : 13 -> disp()돌리면서 a값이 변경돼서
		System.out.println();
		
		AA bb = new BB(); // new로 새로 만든거라서 위의 new생성자에서 수행한 값들 다 노상관(별개임) --> 다형성
		bb.disp(); // BB : 13
		System.out.println("bb : "+bb.a); // bb : 3 --> 필드는 override라는게 없음 (only 메소드)
		System.out.println();
		
		AA cc = new AA(); // 부모클래스참조해서 부모클래스만 만든거라 부모만 생성!! / 부모입장에선 자식있는지도 모름
		cc.disp(); // AA : 8
		System.out.println("cc : "+cc.a); // cc : 8
		System.out.println();
		
		/* 자식클래스 ㅁㅁ = 부모클래스  --> 이건 불가능 ==> 하려면 Casting(형변환)해야함
			ex) 자식클래스 ㅁㅁ = (자식)부모클래스 로 형변환(이경우 자식으로 down Cast)해줘야함
			ex) BB dd = bb;   --> 불가능 
				BB dd = (BB)bb;  --> 이렇게 형변환해줘야 함
		*/
		
		BB dd = (BB)bb; // new로 만든게 아니기 때문에 기존 거 가져다쓴거라 기존 수행했던 연산도 다 남아있는거 쓰는거임
		dd.disp();
		System.out.println("dd : "+dd.a);
		System.out.println();
	}

}
