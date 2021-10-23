package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class ATMTest implements Runnable{
	private long depositeMoney=100000; // �ܾ�
	private long balance; // ã���� �ϴ� �ݾ� , 8byte
	
	public static void main(String[] args) {
		ATMTest at = new ATMTest(); // �ϳ��� Ŭ������ ������ mom,son�� ����
		
		Thread mom = new Thread(at, "����"); // ������ ���� + �̸��ο�
		mom.start(); // ������ ����
		Thread son = new Thread(at, "�Ƶ�");
		son.start();
		
		//mom.setName("����");
		//son.setName("�Ƶ�");
	}

	@Override
	public synchronized void run() { // ����ȭ ó�� - ��� 1
		System.out.println(Thread.currentThread().getName()+"�� �ȳ��ϼ���");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try { // Override�� �����̱� ������ throws�Ұ���
			System.out.print("ã���� �ϴ� �ݾ� �Է� : ");
			balance = Long.parseLong(br.readLine());
			
			if(balance/10000<1) { // balance%10000 != 0 ���� ����ϴ°͵� ����
				System.out.println("���� ������ �Է��ϼ���");
			}else if(depositeMoney>=balance) {
				depositeMoney -= balance; // �� ��쿡�� ���� �����̴ϱ�
				// ��ȸ�� decimalformat�̿��
				System.out.println("�ܾ��� "+new DecimalFormat().format(depositeMoney)+"���Դϴ�");
			}else if(depositeMoney<balance) {
				System.out.println("�ܾ��� �����մϴ�");
			}
			System.out.println();
			
		} catch (IOException e) { // �̰� �����޼ҵ�� �̰͸� �ɾ ��
			e.printStackTrace();
		} 
	}
}
