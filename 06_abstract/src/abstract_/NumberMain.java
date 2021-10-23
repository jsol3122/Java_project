package abstract_;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberMain {

	public static void main(String[] args) {
		// NumberFormat�� import�غ��� �߻��̶� new���� �õ��ϸ� ������
		// NumberFormat�� �ڽ�Ŭ�����δ� DecimalFormat �� ������ �� �̿��غ���
		// DecimalFormat�� �⺻������ 3�ڸ����� �ĸ� ��� �Ҽ��� 3°�ڸ����� ���
		NumberFormat nf = new DecimalFormat(); 
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		NumberFormat nf2 = new DecimalFormat("#,###.##��"); // ����Ŭ���� #���9�� ǥ��
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();
		
		NumberFormat nf3 = new DecimalFormat("#,###.00��"); // ������ 0ǥ��
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		//�߻�Ŭ������ �޼ҵ带 �̿��Ͽ� ����
		//NumberFormat nf4 = NumberFormat.getInstance(); // new�ƴϾ �޼ҵ� ���� ���� - static�Լ���
		NumberFormat nf4 = NumberFormat.getCurrencyInstance(); // ���� ��ȭ��ȣ ǥ��
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		NumberFormat nf5 = NumberFormat.getInstance();
		nf5.setMaximumFractionDigits(2); // �Ҽ��� 2°�ڸ����� ���
		nf5.setMinimumFractionDigits(2); // ������ 2°�ڸ����� 0 ǥ�� - �� ���
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();
		
		//NumberFormat nf6 = NumberFormat.getInstance(Locale.US);
		NumberFormat nf6 = NumberFormat.getCurrencyInstance(Locale.US); //���� ��ȭǥ��
		nf6.setMaximumFractionDigits(2); // �Ҽ��� 2°�ڸ����� ���
		nf6.setMinimumFractionDigits(2); // ������ 2°�ڸ����� 0 ǥ�� - �� ���
		System.out.println(nf6.format(12345678.456789));
		System.out.println(nf6.format(12345678));
		System.out.println();	
	}
}
