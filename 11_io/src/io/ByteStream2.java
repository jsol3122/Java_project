package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream2 {

	public static void main(String[] args) throws IOException {
		File file = new File("data.txt");
		int size = (int)file.length();
		
		byte[] b = new byte[size];
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		bis.read(b, 0, size); // �迭�� 0������� �迭ũ�������� ��������
		
		System.out.println(new String(b));
		bis.close();
	}

}
