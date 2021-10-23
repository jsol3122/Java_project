package abstract_;

import java.util.Scanner;

abstract class ShapeTest{
	protected double area;
	protected Scanner scan = new Scanner(System.in);// 부모에 쓰면 자식들이 다 갖다쓸수있음
	
	public ShapeTest() {
		System.out.println("ShapeTest 기본 생성자");
	}
	// 어차피 안쓰는 공통부분은 추상으로 잡기 - override해서 자식이 쓸거니까 얘는 추상잡아서 메모리아끼기 
	public abstract void calcArea(); 
	public abstract void dispArea();
}
//----------------------------------------------
class SamTest extends ShapeTest{
	protected int base, height;
	
	public SamTest() {
		System.out.println("SamTest 기본생성자");
		System.out.print("밑변 : ");
		base = scan.nextInt();
		System.out.print("높이 : ");
		height = scan.nextInt();
	}
	
	@Override
	public void calcArea() {
		area = base*height/2.0;
	}
	
	public void dispArea() {
		System.out.println("삼각형 넓이 = "+area);
	}
	
}
//----------------------------------------------
class SaTest extends ShapeTest{
	protected int width, height;
	
	public SaTest() {
		System.out.println("SaTest 기본생성자");
		System.out.print("가로 : ");
		width = scan.nextInt();
		System.out.print("세로 : ");
		height = scan.nextInt();
	}
	
	@Override
	public void calcArea() {
		area = width*height;
	}
	
	public void dispArea() {
		System.out.println("사각형 넓이 = "+area);
	}
//----------------------------------------------	
}
class SadariTest extends ShapeTest{
	protected int top, bottom, height;
	
	public SadariTest() {
		System.out.println("SadariTest 기본생성자");
		System.out.print("윗변 : ");
		top = scan.nextInt();
		System.out.print("밑변 : ");
		bottom = scan.nextInt();
		System.out.print("높이 : ");
		height = scan.nextInt();
	}
	
	@Override
	public void calcArea() {
		area = (top+bottom)*height/2.0;
	}
	
	public void dispArea() {
		System.out.println("사다리꼴 넓이 = "+area);
	}
	
}
//----------------------------------------------
public class ShapeMain {

	public static void main(String[] args) {
		
		/*
		SamTest sam = new SamTest();
		sam.calcArea();
		sam.dispArea();
		System.out.println();
		
		SaTest sa = new SaTest();
		sa.calcArea();
		sa.dispArea();
		System.out.println();
		
		SadariTest sadari = new SadariTest();
		sadari.calcArea();
		sadari.dispArea();
		System.out.println();
		*/
		
		// 결합도 낮추기 - 다형성
		ShapeTest shape;  // 부모라는 만능리모컨 객체 한번만 잡아왔을때
		shape = new SamTest(); // 부모하나로 자식클래스를 참조 --> 다형성 : 서로다른 성질,모양
		shape.calcArea();
		shape.dispArea();
		
		shape = new SaTest(); // 부모하나 잡아왔으니까 자식은 싹다 잡아올 수 있음 = 상속쓰는이유(다형성)
		shape.calcArea();
		shape.dispArea();
		
		shape = new SadariTest(); 
		shape.calcArea();
		shape.dispArea();
		
		
	}

}
