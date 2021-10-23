package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain {

	public static void main(String[] args) {
		// System.out.println("args[0] = "+args[0]);
		// �����ڰ� �����͸� �Է����� �ʾƼ� �߻��� ���� Exception�̱� ������ try/throws���x
		// ���� �־��ָ� �ذ� ����
		
		// ArrayIndexOutOfBoundsException 
		if(args.length >= 1) System.out.println("args[0] = "+args[0]);
		// �� ��� ���� ���� �ʾƵ� if�� (����Ͻ����� �̿�) ���� ������� ������ Exception����x
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// bufferedreader������ �ؼ��� ���� �߻� x
		
		int a, b;
		
		try { // �����߻� ���ɱ���
			System.out.print("���� �Է� : ");
			a = Integer.parseInt(br.readLine());
			
			System.out.print("���� �Է� : ");
			b = Integer.parseInt(br.readLine());
			System.out.println(a+" / "+b+" = "+a/b);
		} catch(IOException e) { // �����߻� �� ���� ����
			e.printStackTrace(); // �߻��� ������ ���� �� ���� ���
		} catch(NumberFormatException e) { // ���ڿ��� �ԷµȰ���� ����ó�� - ��ü�� ����ó������
			System.out.println("���� ���¸� �Է��ϼ���");
			e.printStackTrace(); 
		} catch(ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�");
			e.printStackTrace();
		} finally {
			System.out.println("error�� �ְ� ���� ������ �����ϼ�");
		}
		
	} 

}
