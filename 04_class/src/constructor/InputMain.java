package constructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputMain {
	private int x;
	private double y;
	
	public InputMain() throws FileNotFoundException {
		// Scanner scan = new Scanner(System.in);	--> Ű����κ��� �о���� ���
		Scanner scan = new Scanner(new File("data.txt"));
		
		//System.out.print("���� �Է� : ");
		x = scan.nextInt();
		//System.out.print("�Ǽ� �Է� : ");
		y = scan.nextDouble();
	}
	
	public void output() {
		System.out.println("x = "+this.x+"\t y = "+this.y);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		InputMain aa = new InputMain();
		aa.output();

	}

}
