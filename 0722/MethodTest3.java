import java.util.Random;
import java.util.Arrays;

class MethodTest3 {
	public static void main(String[] args) {  // static�� ������ new�� ���� �����ؼ� ���ϸ� ������
		System.out.println("�ִ밪 = "+ Math.max(25,36)); 
		System.out.println("�ּڰ� = "+Math.min(25.3,36.7));
// �׳� max()�ϸ� �����ʵ�Ҽ��̶�� �ν���(Math�ʵ� �Ҽ��ΰ� ���������)-�����ʵ忡 max�����ϱ� �״�ζ�� ������

		System.out.println("���� = "+Math.random());

		Random random = new Random();
		System.out.println("���� = "+random.nextDouble());

		int[] ar = {25,12,37,56};
		System.out.println(ar[0]+", "+ar[1]+", "+ar[2]+", "+ar[3]);

		Arrays.sort(ar);
		System.out.println(ar[0]+", "+ar[1]+", "+ar[2]+", "+ar[3]);
	}
}
