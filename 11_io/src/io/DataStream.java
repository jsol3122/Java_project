package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

	// Exception처리는 여러 개 throws해도 되지만, 상위클래스인 IOException만 걸어줘서 다 포함시킬 수도 있음
	public static void main(String[] args) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
		dos.writeUTF("홍길동");
		dos.writeInt(25);
		// 실수형은 기본적으로 double이기 때문에 writeFloat(실수)하면 오류
		// writeDouble(실수)  or  writeFloat(실수f) 으로 사용 가능
		dos.writeFloat(195.3f);
		dos.close(); // 원래 끝내줘야 함
		
		DataInputStream dis = new DataInputStream(new FileInputStream("result.txt"));
		System.out.println("이름 = "+dis.readUTF());
		System.out.println("나이 = "+dis.readInt());
		System.out.println("키 = "+dis.readFloat()); // writeFloat으로 입력한건 readFloat으로 출력해야함
	}

}
