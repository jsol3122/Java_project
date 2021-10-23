package abstract_;

import java.util.Scanner;

abstract class ShapeTest{
	protected double area;
	protected Scanner scan = new Scanner(System.in);// �θ� ���� �ڽĵ��� �� ���پ�������
	
	public ShapeTest() {
		System.out.println("ShapeTest �⺻ ������");
	}
	// ������ �Ⱦ��� ����κ��� �߻����� ��� - override�ؼ� �ڽ��� ���Ŵϱ� ��� �߻���Ƽ� �޸𸮾Ƴ��� 
	public abstract void calcArea(); 
	public abstract void dispArea();
}
//----------------------------------------------
class SamTest extends ShapeTest{
	protected int base, height;
	
	public SamTest() {
		System.out.println("SamTest �⺻������");
		System.out.print("�غ� : ");
		base = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
	}
	
	@Override
	public void calcArea() {
		area = base*height/2.0;
	}
	
	public void dispArea() {
		System.out.println("�ﰢ�� ���� = "+area);
	}
	
}
//----------------------------------------------
class SaTest extends ShapeTest{
	protected int width, height;
	
	public SaTest() {
		System.out.println("SaTest �⺻������");
		System.out.print("���� : ");
		width = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
	}
	
	@Override
	public void calcArea() {
		area = width*height;
	}
	
	public void dispArea() {
		System.out.println("�簢�� ���� = "+area);
	}
//----------------------------------------------	
}
class SadariTest extends ShapeTest{
	protected int top, bottom, height;
	
	public SadariTest() {
		System.out.println("SadariTest �⺻������");
		System.out.print("���� : ");
		top = scan.nextInt();
		System.out.print("�غ� : ");
		bottom = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
	}
	
	@Override
	public void calcArea() {
		area = (top+bottom)*height/2.0;
	}
	
	public void dispArea() {
		System.out.println("��ٸ��� ���� = "+area);
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
		
		// ���յ� ���߱� - ������
		ShapeTest shape;  // �θ��� ���ɸ����� ��ü �ѹ��� ��ƿ�����
		shape = new SamTest(); // �θ��ϳ��� �ڽ�Ŭ������ ���� --> ������ : ���δٸ� ����,���
		shape.calcArea();
		shape.dispArea();
		
		shape = new SaTest(); // �θ��ϳ� ��ƿ����ϱ� �ڽ��� �ϴ� ��ƿ� �� ���� = ��Ӿ�������(������)
		shape.calcArea();
		shape.dispArea();
		
		shape = new SadariTest(); 
		shape.calcArea();
		shape.dispArea();
		
		
	}

}
