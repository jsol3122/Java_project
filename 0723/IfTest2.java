import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class IfTest2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("ù��° ���� ���� : ");
		int a = Integer.parseInt(br.readLine());
		System.out.print("�ι�° ���� ���� : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("����° ���� ���� : ");
		int c = Integer.parseInt(br.readLine());

		if(a>=40 && b>=40 && c>=40 && (a+b+c)/3 >=60)
			System.out.print("�հ�");
		else if (a<40 || b<40 || c<40) 
			System.out.print("�������� ���հ�");
		else 
			System.out.print("���հ�");

		// double avg = (double)(a+b+c)/3;
		// if(avg>=60)
        //	 if(a>=40 && b>=40 && c>=40) System.out.println("�հ�");
        //	 else System.out.println("�������� ���հ�");
        // else System.out.println("���հ�");

		
	}
}
