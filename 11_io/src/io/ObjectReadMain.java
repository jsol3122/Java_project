package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectReadMain {

	// throws ClassNotFoundException과 IOException 두개 걸어도 됨
	public static void main(String[] args) throws Exception { 
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result3.txt"));
		
		// readObject()로 꺼내온 데이터는 Object타입(최상위부모클래스형)으로 들어옴
		PersonDTO dto = (PersonDTO) ois.readObject();
		
		System.out.println("이름 = "+dto.getName());
		System.out.println("나이 = "+dto.getAge());
		System.out.println("키 = "+dto.getHeight());

		ois.close();
	}

}
