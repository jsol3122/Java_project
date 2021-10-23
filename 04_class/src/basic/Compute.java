package basic;

public class Compute {
	private int x, y, sum, sub, mul;
	private double div;
	
	public void setX(int xx) {
		x=xx;
		//this.x=x; --> 필드의x=x(새로만든 xx)
	}
	public void setY(int yy) { //받기만 함
		y=yy;
	}
	public void calc() { //처리만 함
		sum=x+y;
		sub=x-y;
		mul=x*y;
		div=(double)x/y;
	}
	public int getX() { //내보내기만 함
		return x;
	}
	public int getY() {
		return y;
	}
	public int getSum() {
		return sum;
	}
	public int getSub() {
		return sub;
	}
	public int getMul() {
		return mul;
	}
	public double getDiv() {
		return div;
	}
}
