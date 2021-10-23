package thread;

class JoinTest implements Runnable {  // thread설정 방법 2 - 인터페이스 이용

	@Override
	public void run() { // callback 메소드 - 호출시점은 모름(운영체제가 알아서함)
		for(int i=1; i<=5; i++) {
			System.out.println("i = "+i); 
		} 
	} // run
	
}

//--------------------------------------------------------
public class JoinMain {

	public static void main(String[] args) {
		JoinTest jt = new JoinTest();  // thread 생성x - 상속이 아니니까
		Thread t = new Thread(jt); // thread 생성o - jt라는 JoinTest클래스를 Thread로 생성
		
		System.out.println("스레드 시작");
		t.start(); // thread 시작 - thread를 실행하러 운영체제에 의해 run()호출
		try {
			t.join(); // thread를 죽여서 절차식으로 전환 -> t작업이 끝날때까지 다른 작업으로 전환되지않음(백그라운드x)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("스레드 종료");
	} 
	// main메소드와 run메소드 두개의 thread가 있는 것
	// main메소드가 종료되더라도 thread는 백그라운드에서 계속 돈다(종료x)
	// join으로 thread를 죽여주면, 해당 작업은 절차식처럼 변경되어 해당 작업이 종료될때까지 다음thread로 전환x(백그라운드x)
	// join을 여러개의 thread에 걸어줄 수도 있음
}
