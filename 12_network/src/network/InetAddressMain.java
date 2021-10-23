package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {
	
	public static void main(String[] args) throws UnknownHostException {
		// 호스트이름을 주면 ip주소 주는 메소드 이용하여 InetAddress클래스 생성
		InetAddress naver = InetAddress.getByName("www.naver.com"); 
		System.out.println("NAVER IP : "+naver.getHostAddress());
		System.out.println();
		
		// 내 IP주소 받아오기
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("localhost IP : "+local.getHostAddress());
		System.out.println();
		
		// IP를 많이 얻어올 때 배열 이용
		InetAddress[] daum = InetAddress.getAllByName("www.daum.net");
		for(InetAddress ia : daum) { // 방번호로 daum.length로 for문 돌려도 됨
			System.out.println("DAUM IP : "+ia.getHostAddress());
		}
		System.out.println();
	}
	
	
}
