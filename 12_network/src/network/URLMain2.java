package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLMain2 {

	public static void main(String[] args) throws IOException {
		// view-source:http://www.goldria.net/m/product_list.html?xcode=012
		// 사이트 소스에서 indexOf이용해서 14k 갯수 출력
		URL url = new URL("http://www.goldria.net/m/product_list.html?xcode=012");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null;
		int cnt = 0;
		
		while((line=br.readLine()) != null) { // 한줄씩
			line = line.toLowerCase();
			
			int i = 0;
			while( (i = line.indexOf("14k", i)) != -1) { // 한줄 안에서 14k없을때까지
				i += "14k".length();
				cnt++;
			}
		}
		System.out.println("14k의 수 = "+cnt);
		br.close();
	}

}
