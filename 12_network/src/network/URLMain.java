package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLMain {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com/index.html");
		System.out.println("�������� = "+url.getProtocol());
		System.out.println("ȣ��Ʈ = "+url.getHost());
		System.out.println("��Ʈ = "+url.getPort()); // -1 (��Ʈ ���� �������ϱ�)
		System.out.println("�⺻ ��Ʈ = "+url.getDefaultPort()); // 443 ( https�ϱ�)
		System.out.println("���� = "+url.getFile());
		System.out.println();
		
		// url�� �����ִ� ���� ���� openStream���� �������� InputStreamŸ������ ������
		// br�� ���ٸ� �о���� ������ while�� ������ -- null���� ������ �� �о��ٴ� ��
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null;
		
		while((line=br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}

}
