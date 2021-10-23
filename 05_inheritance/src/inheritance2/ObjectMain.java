package inheritance2;

class Test extends Object{
	@Override
	public String toString() { // override�� ��� �ڽ�Ŭ���� �켱�̹Ƿ�, ���� ��ü����ϸ� �� toString����
		return getClass()+"@���ٺ�"; // getClass()�� �ڽ�Ŭ������ �����Ƿ�, �θ�Ŭ����(Object)���� ã�Ƽ���
	}
	
}
//-----------------------------------------------------------
class Sample {
	
}

//-----------------------------------------------------------
public class ObjectMain {

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("��ü t = "+t);
		System.out.println("��ü t = "+t.toString());
		System.out.println();
		
		Sample s = new Sample();
		System.out.println("��ü s = "+s.toString()); // 16���� �ּҰ�
		System.out.println("��ü s = "+s.hashCode()); // 10���� �ּҰ�
		System.out.println();
		
		String str = "apple";
		System.out.println("��ü str = "+str.toString()); // �ּҰ� �ƴ϶� ���ڿ�!!
		System.out.println("��ü str = "+str.hashCode()); // 10���� �ּҰ�
		System.out.println();
		
		String aa = new String("apple"); // override�Ǿ��ִ� StringŬ������ equals�����
		String bb = new String("apple");
		System.out.println("aa==bb : "+(aa==bb)); // false - �ּҰ��� �ٸ�
		System.out.println("aa.equals(bb) : "+(aa.equals(bb))); // true - ���ڿ��� ����
		System.out.println();
				
		Object cc = new Object(); // �θ�Ŭ���� Object�� ������ �� - override�� �Լ��� ����
		Object dd = new Object();
		System.out.println("cc==dd : "+(cc=dd)); // false - �ּҰ� �ٸ�
		System.out.println("cc.equals(dd) : "+(cc.equals(dd))); // false - �ּҰ� �ٸ�
		System.out.println();
		
		Object ee = new String("apple");
		Object ff = new String("apple");
		System.out.println("ee==ff : "+(ee=ff)); // false - �ּҰ� �ٸ�
		System.out.println("ee.equals(ff) : "+(ee.equals(ff))); // true - ���ڿ� ����
		

	}

}
