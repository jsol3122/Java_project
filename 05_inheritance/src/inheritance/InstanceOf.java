package inheritance;

class AAA{}
class BBB extends AAA{}
//------------------------------------------------
public class InstanceOf {

	public static void main(String[] args) {
		AAA aa = new AAA();
		BBB bb = new BBB();
		AAA aa2 = new BBB();
		
		AAA aa3 = aa; // 가능한지 판별해보자
		if(aa instanceof AAA) 
			System.out.println("1. TRUE");
		else
			System.out.println("1. FALSE");
		
		AAA aa4 = bb; // bb는 BBB를 참조하지만, 안에 AAA도 있으니 같은주소 참조하면 안에 AAA도 참조 가능
		if(bb instanceof AAA)
			System.out.println("2. TRUE");
		else
			System.out.println("2. FALSE");
		
		BBB bb2 = (BBB)aa2; // 가능
		if(aa2 instanceof BBB)
			System.out.println("3. TRUE");
		else
			System.out.println("3. FALSE");
		
		// BBB bb3 = (BBB)aa; --> 불가능 - aa는 AAA만 만든거라, 자식 있는지도 몰라서 참조든 형변환이든 모르는데 어케불러와요;;
		// 여기서는 아예 안돼서 error가 나와서 결고보려고 //해놨음
		if(aa instanceof BBB)
			System.out.println("4. TRUE");
		else
			System.out.println("4. FALSE");  
	}

}
