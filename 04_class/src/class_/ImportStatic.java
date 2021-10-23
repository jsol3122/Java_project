package class_;

import static java.lang.Math.random; 
import static java.lang.Math.pow; // ���� static.Math�ȿ� �־ �Լ����� import �ؾ� �ν�
//import static java.lang.Math.*;  // �̷��� ���ϵ�ī��(*) �ɸ� java.lang.Math���� ����Լ� import�Ŵ°�
import static java.lang.System.out; // �̷��� import�ɾ������ System.out.print���� System ��������

import java.util.Random; // static �Լ��� import static�� ����

public class ImportStatic {

	public static void main(String[] args) {
		out.println("���� = "+random()); // 0<=����<1  --> 1�� ���� �ȳ���
		// �̷������� Math.random()�̷��� �Ⱦ��� ���� import�ɾ random()�� �� �� ����
		// �̷����ϸ� import������ �� random()�Լ��� main�޼ҵ尡 �ƴ϶� static������ �� [static���θ� ����]
		
		Random r = new Random();
		out.println("���� = "+r.nextDouble()); // ����. static�� �ƴ϶� import static����
		out.println("������ ���� = "+r.nextInt()); // 21�� ~ -21�� ���� ����
		out.println("������ ���� = "+r.nextInt(100)); // 0~99 ���� ����
		out.println("������ ���� = "+(r.nextInt(100)+1)); // 1~100 ���� ���� / ��ȣ�ʼ�
		
		out.println("2�� 5�� = "+pow(2, 5)); // Math.pow�� �Ǽ��������� ������ 
	}

}
