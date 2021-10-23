package constructor;

public class PointMain {
	private int x, y;
	
	public PointMain() {
		x=y=10;
	}
	public PointMain (int x, int y) {		// PointMain()�̶� Overload��
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
	public void calcPlus(int a, int b) {	// calcPlus()�� Overload��
		x += a;
		y += b;
		// ���� a,b ��� �Ȱ��� x,y�� ��Ƽ� this.x += x / this.y += y �� �ص� ��
	}
	
	public static void main(String[] args) {
		PointMain aa = new PointMain();
		System.out.println("x = "+aa.x+"\t y = "+aa.y);
		
		System.out.println("\n x�� ���� +10 �����ϴ� �޼ҵ带 �ۼ��Ͻÿ� - calcPlus()");
		aa.calcPlus();
		System.out.println("x = "+aa.x+"\t y = "+aa.y);
		System.out.println();
		
		PointMain bb = new PointMain(100, 200);
		System.out.println("x = "+bb.x+"\t y = "+bb.y);
		
		System.out.println("\n x�� ���� 3����, y�� ���� -8 �����ϴ� �޼ҵ带 �ۼ��Ͻÿ� - calcPlus()");
		bb.calcPlus(3, -8);
		System.out.println("x = "+bb.x+"\t y = "+bb.y);
		System.out.println();
		
		System.out.println("x�� aa�� x���� bb�� x���� ���ϰ�, y������ ���ϱ�");
		PointMain cc = new PointMain(aa, bb);
		System.out.println("x = "+cc.x+"\t y = "+cc.y);
	}

}
