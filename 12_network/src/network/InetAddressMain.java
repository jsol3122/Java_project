package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {
	
	public static void main(String[] args) throws UnknownHostException {
		// ȣ��Ʈ�̸��� �ָ� ip�ּ� �ִ� �޼ҵ� �̿��Ͽ� InetAddressŬ���� ����
		InetAddress naver = InetAddress.getByName("www.naver.com"); 
		System.out.println("NAVER IP : "+naver.getHostAddress());
		System.out.println();
		
		// �� IP�ּ� �޾ƿ���
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("localhost IP : "+local.getHostAddress());
		System.out.println();
		
		// IP�� ���� ���� �� �迭 �̿�
		InetAddress[] daum = InetAddress.getAllByName("www.daum.net");
		for(InetAddress ia : daum) { // ���ȣ�� daum.length�� for�� ������ ��
			System.out.println("DAUM IP : "+ia.getHostAddress());
		}
		System.out.println();
	}
	
	
}
