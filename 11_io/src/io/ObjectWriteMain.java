package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriteMain {

	public static void main(String[] args) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result3.txt"));

		PersonDTO dto = new PersonDTO();
		dto.setName("홍길동");
		dto.setAge(25);
		dto.setHeight(185.3);
		
		oos.writeObject(dto); // 한번에 묶어서 보내기 가능
		oos.close();
	}

}
