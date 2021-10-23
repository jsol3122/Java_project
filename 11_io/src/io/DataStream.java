package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

	// Exceptionó���� ���� �� throws�ص� ������, ����Ŭ������ IOException�� �ɾ��༭ �� ���Խ�ų ���� ����
	public static void main(String[] args) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
		dos.writeUTF("ȫ�浿");
		dos.writeInt(25);
		// �Ǽ����� �⺻������ double�̱� ������ writeFloat(�Ǽ�)�ϸ� ����
		// writeDouble(�Ǽ�)  or  writeFloat(�Ǽ�f) ���� ��� ����
		dos.writeFloat(195.3f);
		dos.close(); // ���� ������� ��
		
		DataInputStream dis = new DataInputStream(new FileInputStream("result.txt"));
		System.out.println("�̸� = "+dis.readUTF());
		System.out.println("���� = "+dis.readInt());
		System.out.println("Ű = "+dis.readFloat()); // writeFloat���� �Է��Ѱ� readFloat���� ����ؾ���
	}

}
