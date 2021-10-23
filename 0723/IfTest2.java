import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class IfTest2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫번째 과목 점수 : ");
		int a = Integer.parseInt(br.readLine());
		System.out.print("두번째 과목 점수 : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("세번째 과목 점수 : ");
		int c = Integer.parseInt(br.readLine());

		if(a>=40 && b>=40 && c>=40 && (a+b+c)/3 >=60)
			System.out.print("합격");
		else if (a<40 || b<40 || c<40) 
			System.out.print("과락으로 불합격");
		else 
			System.out.print("불합격");

		// double avg = (double)(a+b+c)/3;
		// if(avg>=60)
        //	 if(a>=40 && b>=40 && c>=40) System.out.println("합격");
        //	 else System.out.println("과락으로 불합격");
        // else System.out.println("불합격");

		
	}
}
