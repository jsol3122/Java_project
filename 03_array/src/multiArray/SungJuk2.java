package multiArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SungJuk2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�ο��� �Է� : ");
		int cnt = Integer.parseInt(br.readLine());
		
		String[] name = new String[cnt];
		int subjectCnt;  // �迭�� ���� �ʿ� ����
		String[][] subject = new String[cnt][];  // �ο����� �Է¹޾����� ������� ���� �Է� �ȹ޾Ƽ� �����ؠ����� ����x
		int[][] jumsu = new int[cnt][];
		double[] avg = new double[cnt];			 // ������ �Ҽ��� ��°�ڸ����� ǥ���ؾ��ϴϱ�

		// �Է� + ó��
		
		for(int i=0; i<cnt; i++) { // �ο�����ŭ �ݺ��ؼ� �� �־��ֱ�
			System.out.print("�̸� �Է� : ");
			name[i] = br.readLine();
			
			System.out.print("����� �Է� : ");
			subjectCnt = Integer.parseInt(br.readLine());
			
			subject[i] = new String[subjectCnt]; 	// �޸𸮿� �������� ������ ����
			for(int j=0; j<subjectCnt; j++) {
				System.out.print("����� �Է� : ");
				subject[i][j] = br.readLine();
			}
			jumsu[i] = new int[subjectCnt+1];			// �����+1�ؼ� ���� ���� �������� ����! (������ ���� int���̴ϱ�)
			for(int j=0; j<subjectCnt; j++) {
				System.out.print(subject[i][j] +"���� �Է� : ");
				jumsu[i][j] = Integer.parseInt(br.readLine());
				jumsu[i][subjectCnt] += jumsu[i][j];	// ���� ���ϱ�
			}
			avg[i] = (double)jumsu[i][subjectCnt]/subjectCnt;	// int���� ����ε� ����� �Ǽ����� �ϴϱ�
		} //for i
		
		// ���
		
		for(int i=0; i<cnt; i++) {
			// �̸� ���� ����~~~ Ÿ��Ʋ ���
			System.out.print("�̸�\t");
			for(int j=0; j<subject[i].length; j++) {
				System.out.print(subject[i][j]+"\t");			
			}
			System.out.println("����\t���");
			
			// �Է¹��� ������ ���
			System.out.print(name[i]+"\t");
			for(int j=0; j<jumsu[i].length; j++) {
				System.out.print(jumsu[i][j]+"\t");
			}
			System.out.println(String.format("%.2f", avg[i]));
			System.out.println();
			
		}	
	} //main
}
