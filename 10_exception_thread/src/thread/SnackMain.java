package thread;

class SnackTest extends Thread{ // thread설정 방법 1 - 상속 이용
	private String str;

	public SnackTest(String str) {
		this.str = str;
	}
	
	public void run() {
		for(int i=1; i<=5; i++) {
			System.out.println(str+"\ti = "+i+"\t"+Thread.currentThread()); // static메소드 - 현재 실행중 스레드 정보
		} // for
	}
	
}
//---------------------------------------------------
public class SnackMain {

	public static void main(String[] args) { // 절차식(스레드x)인 경우 - main이 callback됨
		// thread new 생성 - 상속해놨으니까
		SnackTest aa = new SnackTest("새우깡"); 
		SnackTest bb = new SnackTest("포카칩");
		SnackTest cc = new SnackTest("홈런볼");
		
		// thread 이름 부여
		aa.setName("새우깡");
		bb.setName("포카칩");
		cc.setName("홈런볼");
		
		// thread 우선순위 부여 (1~10 중 부여됨) -- 반드시 지켜지는 것은 아님
		//aa.setPriority(Thread.MAX_PRIORITY); // 가장 높은 우선순위 부여(10) - 가장 먼저 완료
			// aa.setPriority(10); -- 이런 형식으로 우선순위 부여도 가능
		//bb.setPriority(Thread.MIN_PRIORITY); // 가장 낮은 우선순위(1)
		//cc.setPriority(Thread.NORM_PRIORITY); // 중간 우선순위(5) - default값
		
		// thread 시작 - 실행 순서는 임의배정 불가능(운영체제가 자동설정)
		aa.start(); 
		try {
			aa.join(); // thread 죽이기 - 가장 먼저 처리완료할동안 나머지는 대기상태로 만들기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bb.start();
		cc.start();
	}

}
