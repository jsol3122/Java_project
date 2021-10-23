package swing;

import java.util.Vector;

//상수화시키기 - int형이지만 숫자로만 쓰면 헷갈리니까
//상수가 3개가 넘어갈 때는 상수화클래스 잡아서 넣기 - 0번부터 숫자매겨짐
//클래스명과 필드의 자료형 동일하게 잡고, 마지막 세미콜론 생략
enum Shape {  // enum도 하나의 자료형
	LINE, CIRCLE, RECT, ROUNDRECT, PEN
}

public class ShapeDTO { // 도형 1개 분량
	private int x1, y1, x2, y2, z1, z2;
	private boolean fill;
	private Shape shape; // 도형을 상수화클래스로 저장하기
	private int color; // color의 인덱스번호로 받아오기 - 상수화x
	private Vector<Integer> vector = new Vector<Integer>();
	
	// setter  , getter
	public void setVector(Vector<Integer> vector) {
		this.vector = vector;
	}
	public Vector<Integer> getVector(){
		return vector;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public int getZ1() {
		return z1;
	}
	public void setZ1(int z1) {
		this.z1 = z1;
	}
	public int getZ2() {
		return z2;
	}
	public void setZ2(int z2) {
		this.z2 = z2;
	}
	public boolean isFill() {
		return fill;
	}
	public void setFill(boolean fill) {
		this.fill = fill;
	}
	public Shape getShape() {
		return shape;
	}
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	
}
