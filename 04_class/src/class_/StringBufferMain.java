package class_;

import java.util.Scanner;

public class StringBufferMain {
	Scanner scan = new Scanner(System.in);
	private int dan;
	
	public StringBufferMain() {	// ���� public�� ��������������, �Ⱦ��� �ܺ�Ŭ���������� ���� x
		System.out.print("���ϴ� ���� �Է� : ");
		dan=scan.nextInt();	// ���⼭�� ������ ��ü���� ���������� �������ϱ� this��� �ִ� ���� dan���̶� ����
		display();
	}
	
	public void display() {
		StringBuffer buffer = new StringBuffer(); //���ڿ� ó�� - String�� �޸� ��������
			for(int i=1; i<10; i++) {
			// System.out.println(dan+" * "+i+" = "+(dan*i));
			buffer.append(dan);
			buffer.append("*");
			buffer.append(i);
			buffer.append("=");
			buffer.append(dan*i);
			System.out.println(buffer);
			buffer.delete(0, buffer.length()); // buffer append�� delete����ؼ� ������ ���
		}
	}

	public static void main(String[] args) {
		StringBufferMain aa = new StringBufferMain(); //static�� �����ϱ� new�� �������ֱ�
		//�����ڿ� display(); �ȳ־���� ���⼭ main.display();�� �ҷ��͵� ��
	} //main
}
