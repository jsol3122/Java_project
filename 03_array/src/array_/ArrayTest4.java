package array_;

public class ArrayTest4 {

	public static void main(String[] args) {
		int[] ar = new int[100];
		int[] count = new int[26];
		int i, j;
		
		for(i=0; i<ar.length; i++) {
			ar[i] = (int)(Math.random()*26)+65;	
		} // for �����Է�

		for(i=0; i<ar.length; i++) {
			System.out.print((char)ar[i]+" ");
			if((i+1)%10==0) System.out.println();
			
			for(j=0; j<count.length; j++) { //count�迭�� A~Z���� ���� ���� ����for������ 
				if (ar[i]==j+'A') count[j]++; // 'A'�� i������ j���� �̿��ؼ� �����ؾ� ++�� �������� �ݺ��Ǵϱ�
			} // for ī��Ʈ
			
		} // for �������
		for(i=0; i<count.length; i++) { //A����~Z���� ��� �ݺ��� for�� ����� ������
			System.out.print((char)(i+'A')+"�� ���� = "+count[i]+"\t");
			if((i+1)%3==0) System.out.println();
		} // for �������ϱ�
	}
}

