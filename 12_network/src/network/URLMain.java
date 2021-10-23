package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLMain {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com/index.html");
		System.out.println("프로토콜 = "+url.getProtocol());
		System.out.println("호스트 = "+url.getHost());
		System.out.println("포트 = "+url.getPort()); // -1 (포트 설정 안했으니까)
		System.out.println("기본 포트 = "+url.getDefaultPort()); // 443 ( https니까)
		System.out.println("파일 = "+url.getFile());
		System.out.println();
		
		// url이 갖고있는 웹의 값을 openStream으로 가져오면 InputStream타입으로 가져옴
		// br은 한줄만 읽어오기 때문에 while문 돌리기 -- null값이 들어오면 다 읽었다는 뜻
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null;
		
		while((line=br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}

}
