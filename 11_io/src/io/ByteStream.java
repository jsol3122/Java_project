package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream { // Byte단위로 한글자씩 입출력

	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));
		int data;
		
		while( (data = bis.read()) != -1 ) {
			System.out.print((char)data);
		}
		
		bis.close();
	}

}
