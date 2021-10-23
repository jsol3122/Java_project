package thread;

// 상속이니까 굳이 따로 thread new생성해서 설정할 필요x - 클래스 자체가 thread
public class Synchronized extends Thread {
	private static int count;
	
	public Synchronized() {
		System.out.println("this = "+this);
	}
	
	public static void main(String[] args) {
		Synchronized aa = new Synchronized(); // 스레드 생성
		Synchronized bb = new Synchronized(); // 클래스를 각각 만들었기 때문에(공유x) 방법1동기화 안됨
		Synchronized cc = new Synchronized();
		
		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");
		
		aa.start(); // 스레드 시작
		bb.start();
		cc.start();
	}
	
	@Override
	// public synchronized void run() { -- 동기화 처리가 안됨(방법 1)
	public void run() {
		synchronized(Synchronized.class) { // 세 thread의 공통점인 클래스파일을 이용해 동기화 - 방법 3
			for(int i=1; i<=5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName()+" : count = "+count);
			}
		}
	}

}
