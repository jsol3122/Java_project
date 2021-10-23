package inheritance2;

class Test extends Object{
	@Override
	public String toString() { // override의 경우 자식클래스 우선이므로, 이제 객체출력하면 이 toString수행
		return getClass()+"@개바부"; // getClass()가 자식클래스에 없으므로, 부모클래스(Object)에서 찾아서옴
	}
	
}
//-----------------------------------------------------------
class Sample {
	
}

//-----------------------------------------------------------
public class ObjectMain {

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("객체 t = "+t);
		System.out.println("객체 t = "+t.toString());
		System.out.println();
		
		Sample s = new Sample();
		System.out.println("객체 s = "+s.toString()); // 16진수 주소값
		System.out.println("객체 s = "+s.hashCode()); // 10진수 주소값
		System.out.println();
		
		String str = "apple";
		System.out.println("객체 str = "+str.toString()); // 주소값 아니라 문자열!!
		System.out.println("객체 str = "+str.hashCode()); // 10진수 주소값
		System.out.println();
		
		String aa = new String("apple"); // override되어있는 String클래스의 equals수행됨
		String bb = new String("apple");
		System.out.println("aa==bb : "+(aa==bb)); // false - 주소값은 다름
		System.out.println("aa.equals(bb) : "+(aa.equals(bb))); // true - 문자열은 동일
		System.out.println();
				
		Object cc = new Object(); // 부모클래스 Object만 생성된 것 - override된 함수들 무시
		Object dd = new Object();
		System.out.println("cc==dd : "+(cc=dd)); // false - 주소값 다름
		System.out.println("cc.equals(dd) : "+(cc.equals(dd))); // false - 주소값 다름
		System.out.println();
		
		Object ee = new String("apple");
		Object ff = new String("apple");
		System.out.println("ee==ff : "+(ee=ff)); // false - 주소값 다름
		System.out.println("ee.equals(ff) : "+(ee.equals(ff))); // true - 문자열 동일
		

	}

}
