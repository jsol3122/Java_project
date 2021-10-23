package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain2 {
	private int dan;
	
	public void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ϴ� ���� �Է� : ");
		try { // ������ Exception
			dan = Integer.parseInt(br.readLine());
		} catch (IOException e) { 
			// NumberFormatException �� ���� ����ó���Լ��� �θ� IOException�̶� ��� ���� �� ����
			// ���� �ٸ� ����ó�� ����Ƶ� ������� / ��ü�� ���ܻ�Ȳ�� ���� ó���� ������ ���� ���� ��������
			// Exception�� �θ�� Throwable / ��κ� Exception����
			e.printStackTrace();
		}	
		output(dan);
	}
	
	public void output(int dan) {
		if(dan>=2 && dan<=9) { 
			for(int i=1; i<10 ; i++) System.out.println(dan+" * "+i+" = "+dan*i);
		}
		// ����Ͻ� �������� ����ó�� ��� - ���� Exception
		// else System.out.println("2~9 ������ ���ڸ� �Է��Ͻÿ�");
		
		else {
			try{
				// ������ Exception �߻���Ű�� ��� - �߻��� error ����ִ� �۾��� �����ؾ� ��
				// throw new Exception("2~9 ������ ���ڸ� �Է��Ͻÿ�");
				
				// �����ڰ� ���� ExceptionŬ���� �̿��Ͽ� ���� ó�� ���
				throw new MakeException("2~9 ������ ���ڸ� �Է��Ͻÿ�");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new ExceptionMain2().input();
	}

}
