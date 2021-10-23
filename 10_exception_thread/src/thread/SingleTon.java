package thread;

public class SingleTon { 
	private int num=3;
	private static SingleTon instance=null; // static으로 한번만 메모리생성해주기 (계속 new하지 x)
	// null로 초기화되는 과정도 프로그램 전체에서 처음 딱 한번만 수행!!
	
	public static SingleTon getInstance() {
		if(instance==null) { // 맨 처음 딱한번만 null임 - 초기화는 딱한번이니까
			synchronized(SingleTon.class){ // 동기화 처리 - 방법 3
				instance = new SingleTon(); // 처음 딱한번만 생성하게 됨
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		SingleTon aa = new SingleTon();
		aa.num++;
		System.out.println("aa = "+aa); // 16진수 주소값 출력
		System.out.println("num = "+aa.num);
		System.out.println();
		
		SingleTon bb = new SingleTon();
		bb.num++;
		System.out.println("bb = "+bb);
		System.out.println("num = "+bb.num);
		System.out.println();
		
		System.out.println("--- 싱글톤 ---");
		SingleTon cc = SingleTon.getInstance(); // new하지 않음 - static메소드여야함
		cc.num++;
		System.out.println("cc = "+cc); // 16진수 주소값 출력
		System.out.println("num = "+cc.num);
		System.out.println();
		
		SingleTon dd = SingleTon.getInstance(); // new하지 않음
		dd.num++;
		System.out.println("dd = "+dd); // cc와 주소값 동일
		System.out.println("num = "+dd.num);
		System.out.println();
	}
	
	
}
