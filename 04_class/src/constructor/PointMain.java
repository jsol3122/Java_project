package constructor;

public class PointMain {
	private int x, y;
	
	public PointMain() {
		x=y=10;
	}
	public PointMain (int x, int y) {		// PointMain()이랑 Overload임
		this.x=x;
		this.y=y;
	}
	public PointMain(PointMain aa, PointMain bb) {
		this.x = aa.x + bb.x;
		this.y = aa.y * bb.y;
	}
	public void calcPlus() {
		x += 10;
	}
	public void calcPlus(int a, int b) {	// calcPlus()랑 Overload임
		x += a;
		y += b;
		// 변수 a,b 대신 똑같은 x,y로 잡아서 this.x += x / this.y += y 로 해도 됨
	}
	
	public static void main(String[] args) {
		PointMain aa = new PointMain();
		System.out.println("x = "+aa.x+"\t y = "+aa.y);
		
		System.out.println("\n x의 값을 +10 증가하는 메소드를 작성하시오 - calcPlus()");
		aa.calcPlus();
		System.out.println("x = "+aa.x+"\t y = "+aa.y);
		System.out.println();
		
		PointMain bb = new PointMain(100, 200);
		System.out.println("x = "+bb.x+"\t y = "+bb.y);
		
		System.out.println("\n x의 값을 3증가, y의 값을 -8 감소하는 메소드를 작성하시오 - calcPlus()");
		bb.calcPlus(3, -8);
		System.out.println("x = "+bb.x+"\t y = "+bb.y);
		System.out.println();
		
		System.out.println("x는 aa의 x값과 bb의 x값을 더하고, y끼리는 곱하기");
		PointMain cc = new PointMain(aa, bb);
		System.out.println("x = "+cc.x+"\t y = "+cc.y);
	}

}
