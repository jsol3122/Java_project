package basic;

public class Compute {
	private int x, y, sum, sub, mul;
	private double div;
	
	public void setX(int xx) {
		x=xx;
		//this.x=x; --> �ʵ���x=x(���θ��� xx)
	}
	public void setY(int yy) { //�ޱ⸸ ��
		y=yy;
	}
	public void calc() { //ó���� ��
		sum=x+y;
		sub=x-y;
		mul=x*y;
		div=(double)x/y;
	}
	public int getX() { //�������⸸ ��
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
